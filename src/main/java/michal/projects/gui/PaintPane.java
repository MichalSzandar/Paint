package michal.projects.gui;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import michal.projects.ShapeMap;
import michal.projects.states.DefaultState;

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

    public Color getActiveColor()
    {
        return activeColor;
    }

    public void setActiveColor(Color color)
    {
        activeColor = color;
    }
}
