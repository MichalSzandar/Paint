package michal.projects;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PaintPane extends Pane 
{
    private Color activeColor;
    public  ShapeMap shapeMap;

    public PaintPane()
    {
        super();
        setPrefSize(800, 1000);
        shapeMap = new ShapeMap();
        Rectangle clip = new Rectangle();
        clip.widthProperty().bind(widthProperty());
        clip.heightProperty().bind(heightProperty());
        setClip(clip);
    
        activeColor = Color.BLACK;
        setOnMouseClicked(event -> { DefaultState.onMouseClicked(event);});

        
    }

    @SuppressWarnings("exports")
    public Color getActiveColor()
    {
        return activeColor;
    }

    @SuppressWarnings("exports")
    public void setActiveColor(Color color)
    {
        activeColor = color;
    }
}
