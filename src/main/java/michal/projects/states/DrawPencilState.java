package michal.projects.states;

import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import michal.projects.gui.PaintPane;

public class DrawPencilState extends PaneState {
    private Path currentPath;
    private double opacity;

    public DrawPencilState(final PaintPane canvas, final double opacity) {
        super(canvas);
        this.opacity = opacity;
    }

    @Override
    protected final void onMouseClicked(final MouseEvent e) {
        return;
    }

    @Override
    protected final void onMousePressed(final MouseEvent e) {
        currentPath = new Path();
        currentPath.setStrokeWidth(canvas.getCurrentBrushSize());
        currentPath.setOpacity(opacity);
        currentPath.setStroke(canvas.getActiveColor());

        MoveTo moveTo = new MoveTo(e.getX(), e.getY());
        currentPath.getElements().add(moveTo);
        canvas.addElement(currentPath);
    }

    @Override
    protected final void onMouseDragged(final MouseEvent e) {
        if (currentPath != null) {
            LineTo lineTo = new LineTo(e.getX(), e.getY());
            currentPath.getElements().add(lineTo);
        }
    }

    @Override
    protected final void onMouseMoved(final MouseEvent e) {
        return;
    }

    @Override
    protected final void onMouseExited(final MouseEvent e) {
        return;
    }

    @Override
    protected final void onScroll(final ScrollEvent e) {
        return;
    }
}
