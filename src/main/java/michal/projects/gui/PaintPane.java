package michal.projects.gui;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import michal.projects.ShapeMap;
import michal.projects.states.DefaultState;
import michal.projects.states.PaneState;

public class PaintPane extends Pane 
{
    private Color activeColor;
    public  ShapeMap shapeMap;
    private PaneState state;
    private double currentBrushSize = 5;

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
        state = new DefaultState(this);
        state.setMouseEvents();
    }

    public Color getActiveColor()
    {
        return activeColor;
    }

    public void setActiveColor(Color color)
    {
        activeColor = color;
    }

    public double getCurrentBrushSize(){
        return currentBrushSize;
    }

    public void setBrushSize(double size){
        currentBrushSize = size;
    }

    public void setState(PaneState state){
        this.state = state;
        state.setMouseEvents();
    }
}
