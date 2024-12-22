package michal.projects.states;

import javafx.scene.input.MouseEvent;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import michal.projects.gui.PaintPane;

public class DrawPencilState extends PaneState{
    private Path currentPath;
    private double size;
    private double opacity;

    public DrawPencilState(PaintPane canvas){
        super(canvas);
        size = 5;
        opacity = 1;  
    }

    @Override
    protected void onMouseClicked(MouseEvent e) {
        return;
    }

    @Override
    protected void onMousePressed(MouseEvent e) {
        currentPath = new Path();
        currentPath.setStrokeWidth(size);
        currentPath.setOpacity(opacity);
        currentPath.setStroke(canvas.getActiveColor());

        MoveTo moveTo = new MoveTo(e.getX(), e.getY());
        currentPath.getElements().add(moveTo);
        canvas.getChildren().add(currentPath);
    }

    @Override
    protected void onMouseDragged(MouseEvent e) {
        if (currentPath != null) {
            LineTo lineTo = new LineTo(e.getX(), e.getY());
            currentPath.getElements().add(lineTo);
        }
    }

    @Override
    protected void onMouseMoved(MouseEvent e) {
        return;
    }

    @Override
    protected void onMouseExited(MouseEvent e) {
        return;
    }
    
}
