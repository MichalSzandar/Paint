package michal.projects.gui;
import java.io.File;
import java.util.logging.Level;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
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
import michal.projects.states.DefaultState;
import michal.projects.states.DrawPencilState;
import michal.projects.states.DrawShapeState;
import michal.projects.states.DrawSprayState;

/**
 * class responsible for setting up main stage.
 */
public class GUI {
    /**sets up main stage.
     * @param stage
     */
    public GUI(final Stage stage) {

        // importing icons
        Image circleImg = new Image(getClass()
            .getResource("/circle.png").toExternalForm());
        Image rectImg = new Image(getClass()
            .getResource("/rectangle.png").toExternalForm());
        Image triangleImg = new Image(getClass()
            .getResource("/triangle.png").toExternalForm());
        Image pencilImg = new Image(getClass()
            .getResource("/default_brush.png").toExternalForm());
        Image highlighterImg = new Image(getClass()
            .getResource("/highlighter.png").toExternalForm());
        Image sprayImg = new Image(getClass()
            .getResource("/spray.png").toExternalForm());
        Image handImg = new Image(getClass()
            .getResource("/hand.png").toExternalForm());
        Image undoImg = new Image(getClass()
            .getResource("/undo.png").toExternalForm());
        Image redoImg = new Image(getClass()
            .getResource("/redo.png").toExternalForm());

        PaintPane canvas = new PaintPane();

        DrawShapeState drawRectangle = new DrawShapeState(canvas, new RectangleBuilder());
        DrawShapeState drawCircle = new DrawShapeState(canvas, new CircleBuilder());
        DrawShapeState drawTriangle = new DrawShapeState(canvas, new TriangleBuilder());

        StateButton rectangleButton = new StateButton(canvas, drawRectangle);
        rectangleButton.setGraphic(createImageView(rectImg));

        StateButton circleButton = new StateButton(canvas, drawCircle);
        circleButton.setGraphic(createImageView(circleImg));

        StateButton triangleButton = new StateButton(canvas, drawTriangle);
        triangleButton.setGraphic(createImageView(triangleImg));

        StateButton pencilButton = new StateButton(canvas, new DrawPencilState(canvas, 1));
        pencilButton.setGraphic(createImageView(pencilImg));

        StateButton highlighterButton = new StateButton(canvas, new DrawPencilState(canvas, 0.5));
        highlighterButton.setGraphic(createImageView(highlighterImg));

        StateButton sprayButton = new StateButton(canvas, new DrawSprayState(canvas));
        sprayButton.setGraphic(createImageView(sprayImg));

        StateButton handButton = new StateButton(canvas, new DefaultState(canvas));
        handButton.setGraphic(createImageView(handImg));

        Button undoButton = new Button();
        undoButton.setGraphic(createImageView(undoImg));
        undoButton.setOnAction(event -> canvas.undo());

        Button redoButton = new Button();
        redoButton.setGraphic(createImageView(redoImg));
        redoButton.setOnAction(event -> canvas.redo());

        FileChooser fileChooser = new FileChooser();

        MenuItem save = new MenuItem("save");
        save.setOnAction(event -> {
            fileChooser.setTitle("save shapes");
            File file = fileChooser.showSaveDialog(stage);
            if (file != null) {
                Serializer.serializeShapesFromCanvas(canvas, file.getAbsolutePath());
            }
        });

        MenuItem open = new MenuItem("open");
        open.setOnAction(event -> {
            canvas.getChildren().clear();
            fileChooser.setTitle("open shapes");
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                Serializer.desrializeShapes(canvas, file.getAbsolutePath());
            }
        });

        MenuItem about = new MenuItem("about");
        about.setOnAction(event -> {
            MyAlerts.displayInfo();
        });

        MenuItem controls = new MenuItem("controls");
        controls.setOnAction(event -> {
            MyAlerts.displayControls();
        });

        ColorPicker colorPicker = new ColorPicker(Color.BLACK);
        colorPicker.setOnAction(event -> {
            canvas.setActiveColor(colorPicker.getValue());
        });

        Label radiusLabel = new Label("size of brush: ");
        Slider radiusSlider = new Slider(1, 50, 5);
        radiusSlider.setBlockIncrement(0.5);
        radiusSlider.valueProperty().addListener((obs, oldVal, newVal) -> canvas.setBrushSize(newVal.doubleValue()));
        radiusSlider.setShowTickLabels(true);
        radiusSlider.setShowTickMarks(true);

        VBox radiusControl = new VBox(5, radiusLabel, radiusSlider);

        final Menu menu1 = new Menu("File");
        menu1.getItems().addAll(open, save);

        final Menu menu2 = new Menu("Info");
        menu2.getItems().addAll(about, controls);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menu1, menu2);

        PaintToolBar toolBar = new PaintToolBar();
        toolBar.addStateButton(circleButton);
        toolBar.addStateButton(rectangleButton);
        toolBar.addStateButton(triangleButton);
        toolBar.addStateButton(handButton);
        toolBar.addStateButton(pencilButton);
        toolBar.addStateButton(highlighterButton);
        toolBar.addStateButton(sprayButton);
        toolBar.addColorPicker(colorPicker);
        toolBar.addRadiusControl(radiusControl);
        toolBar.addButton(undoButton);
        toolBar.addButton(redoButton);
        toolBar.requestLayout();

        VBox root = new VBox(menuBar, toolBar, canvas);
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Paint");
        stage.show();
        MyLogger.logger.log(Level.INFO, "Scene has been inited");
    }

    private ImageView createImageView(final Image img) {
        ImageView view = new ImageView();
        view.setFitHeight(25);
        view.setFitWidth(25);
        view.setImage(img);
        return view;
    }
}
