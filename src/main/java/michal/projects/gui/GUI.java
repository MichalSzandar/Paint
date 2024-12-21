package michal.projects.gui;
import java.io.File;
import java.util.logging.Level;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToolBar;
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
import michal.projects.states.DrawShapeState;

public class GUI 
{
    public GUI(Stage stage)
    {
        PaintPane canvas = new PaintPane();

        DrawShapeState drawRectangle = new DrawShapeState(new RectangleBuilder());
        DrawShapeState drawCircle = new DrawShapeState(new CircleBuilder());
        DrawShapeState drawTriangle = new DrawShapeState(new TriangleBuilder());

        ShapeButton rectangleButton = new ShapeButton("rectangle", canvas, drawRectangle);
        ShapeButton circleButton = new ShapeButton("circle", canvas, drawCircle);
        ShapeButton triangleButton = new ShapeButton("triangle",  canvas, drawTriangle);

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

        ToolBar toolBar = new ToolBar(circleButton, rectangleButton, triangleButton, colorPicker);
        VBox root = new VBox(menuBar, toolBar,canvas);
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Paint");
        stage.show();
        MyLogger.logger.log(Level.INFO, "Scene has been inited");
    }
    
}
