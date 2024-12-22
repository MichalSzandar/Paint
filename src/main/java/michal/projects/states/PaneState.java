package michal.projects.states;

import javafx.scene.input.MouseEvent;
import michal.projects.gui.PaintPane;

public abstract class PaneState {
    protected PaintPane canvas;

    public PaneState(PaintPane canvas){
        this.canvas = canvas;
    }

    protected abstract void onMouseClicked(MouseEvent e);
    protected abstract void onMousePressed(MouseEvent e);
    protected abstract void onMouseDragged(MouseEvent e);
    protected abstract void onMouseMoved(MouseEvent e);
    protected abstract void onMouseExited(MouseEvent e);

    public void setMouseEvents(){
        canvas.setOnMouseClicked(event -> onMouseClicked(event));
        canvas.setOnMousePressed(event -> onMousePressed(event));
        canvas.setOnMouseDragged(event -> onMouseDragged(event));
        canvas.setOnMouseMoved(event -> onMouseMoved(event));
        canvas.setOnMouseExited(event -> onMouseExited(event));
    }
}
