package michal.projects.gui;

import java.util.Stack;

import javafx.scene.Node;
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

    private Stack<Node> recentlyAddedNodes;
    private Stack<Node> recentlyDeletedNodes;

    public PaintPane() {
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

        recentlyAddedNodes = new Stack<>();
        recentlyDeletedNodes = new Stack<>();
    }

    public final Color getActiveColor() {
        return activeColor;
    }

    public final void setActiveColor(final Color color) {
        activeColor = color;
    }

    public final double getCurrentBrushSize() {
        return currentBrushSize;
    }

    public final void setBrushSize(final double size) {
        currentBrushSize = size;
    }

    public final void setState(final PaneState state) {
        this.state = state;
        state.setMouseEvents();
    }

    public final void addElement(final Node node) {
        getChildren().add(node);
        recentlyAddedNodes.push(node);
    }

    public final void removeElement(final Node node) {
        getChildren().remove(node);
        recentlyDeletedNodes.push(node);
    }

    public final void undo() {
        Node last = recentlyAddedNodes.pop();
        getChildren().remove(last);
        recentlyDeletedNodes.push(last);
    }

    public final void redo() {
        Node last = recentlyDeletedNodes.pop();
        getChildren().add(last);
        recentlyAddedNodes.push(last);
    }
}
