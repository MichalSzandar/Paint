package michal.projects.gui;
import java.io.File;
import java.util.logging.Level;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import michal.projects.MyAlerts;
import michal.projects.MyLogger;
import michal.projects.Serializer;
import michal.projects.shape_builders.CircleBuilder;
import michal.projects.shape_builders.RectangleBuilder;
import michal.projects.shape_builders.TriangleBuilder;
import michal.projects.states.DrawPencilState;
import michal.projects.states.DrawShapeState;

public class GUI 
{
    public GUI(Stage stage)
    {
        Image circleImg = new Image(getClass().getResource("/circle.png").toExternalForm());
        Image rectImg = new Image(getClass().getResource("/rectangle.png").toExternalForm());
        Image triangleImg = new Image(getClass().getResource("/triangle.png").toExternalForm());

        PaintPane canvas = new PaintPane();

        DrawShapeState drawRectangle = new DrawShapeState(canvas, new RectangleBuilder());
        DrawShapeState drawCircle = new DrawShapeState(canvas, new CircleBuilder());
        DrawShapeState drawTriangle = new DrawShapeState(canvas, new TriangleBuilder());

        ShapeButton rectangleButton = new ShapeButton(canvas, drawRectangle);
        rectangleButton.setGraphic(createImageView(rectImg));

        ShapeButton circleButton = new ShapeButton(canvas, drawCircle);
        circleButton.setGraphic(createImageView(circleImg));

        ShapeButton triangleButton = new ShapeButton(canvas, drawTriangle);
        triangleButton.setGraphic(createImageView(triangleImg));

        ShapeButton pencilButton = new ShapeButton(canvas, new DrawPencilState(canvas));
        pencilButton.setText("Pencil");

        FileChooser fileChooser = new FileChooser();

        MenuItem save = new MenuItem("save");
        save.setOnAction(event -> {
            fileChooser.setTitle("save shapes");
            File file = fileChooser.showSaveDialog(stage);
            if(file!=null)
                Serializer.serializeShapesFromCanvas(canvas, file.getAbsolutePath());
        });

        MenuItem open = new MenuItem("open");
        open.setOnAction(event -> {
            canvas.getChildren().clear(); 
            fileChooser.setTitle("open shapes");
            File file = fileChooser.showOpenDialog(stage);
            if(file!=null)
                Serializer.desrializeShapes(canvas, file.getAbsolutePath());
        });

        MenuItem about = new MenuItem("about");
        about.setOnAction(event -> {MyAlerts.displayInfo();});

        MenuItem controls = new MenuItem("controls");
        controls.setOnAction(event -> {MyAlerts.displayControls();});

        ColorPicker colorPicker = new ColorPicker(Color.BLACK);
        colorPicker.setOnAction(event -> {
            canvas.setActiveColor(colorPicker.getValue());
        });
    
        final Menu menu1 = new Menu("File");
        menu1.getItems().addAll(open, save);

        final Menu menu2 = new Menu("Info");
        menu2.getItems().addAll(about, controls);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menu1, menu2);

        ToolBar toolBar = new ToolBar(circleButton, rectangleButton, triangleButton, pencilButton, colorPicker);
        VBox root = new VBox(menuBar, toolBar,canvas);
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Paint");
        stage.show();
        MyLogger.logger.log(Level.INFO, "Scene has been inited");
    }

    private ImageView createImageView(Image img){
        ImageView view = new ImageView();
        view.setFitHeight(25);
        view.setFitWidth(25);
        view.setImage(img);
        return view;
    }
    
}
