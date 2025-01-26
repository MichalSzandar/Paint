package michal.projects.states;

import java.util.logging.Level;

import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.shape.Shape;
import michal.projects.MyLogger;
import michal.projects.Point;
import michal.projects.gui.PaintPane;
import michal.projects.shapes.IMyShape;

public class DefaultState extends PaneState {
    private IMyShape shape;
    private double difX;
    private double difY;
    private double startRotation;

    public DefaultState(final PaintPane pane) {
        super(pane);
    }

    /**
     * if user clicked on shape it sets the shape to
     * active and all other shapes on
     * scene to disabled.
     */
    @Override
    protected void onMouseClicked(final MouseEvent e) {
        if (e.getButton().equals(MouseButton.PRIMARY)) {
            Node object = e.getPickResult().getIntersectedNode();

            for (Node node : canvas.getChildrenUnmodifiable()) {
                if (node instanceof IMyShape) {
                    ((IMyShape) node).setDisabled();
                }
            }

            if (object instanceof IMyShape && object instanceof Shape) {
                ((IMyShape) object).setActive();
                shape = (IMyShape) object;
            }
        } else if (e.getButton().equals(MouseButton.SECONDARY)
                    && e.isControlDown() && shape != null
                    && shape.isActive()) {
            ((Shape) shape).setFill(canvas.getActiveColor());
        }

    }

    @Override
    protected final void onMousePressed(final MouseEvent e) {
        if (shape == null || !shape.isActive()) {
            return;
        }

        difX = e.getSceneX() - shape.getVertices().get(0).getX();
        difY = e.getSceneY() - shape.getVertices().get(0).getY();
        startRotation = ((Shape) shape).getRotate();
        MyLogger.logger.log(Level.INFO, "mouse pressed");
    }

    @Override
    protected final void onMouseDragged(final MouseEvent e) {
        if (shape == null || !shape.isActive()) {
            return;
        }

        if (e.getButton() == MouseButton.PRIMARY) {
            shape.moveShape(
                new Point(e.getSceneX() - difX, e.getSceneY() - difY));
        } else if (e.getButton() == MouseButton.SECONDARY) {
            ((Shape) shape).setRotate((startRotation + e.getSceneX() - shape.getVertices().get(0).getX() - difX) % 360);
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
        double zoomfactor = 1.05;
        double deltaY = e.getDeltaY();
        if (deltaY < 0) {
            zoomfactor = 1.8 - zoomfactor;
        }
        Shape shape = (Shape)this.shape;
        shape.setScaleX(shape.getScaleX()*zoomfactor);
        shape.setScaleY(shape.getScaleY()*zoomfactor);
        shape.setStrokeWidth(shape.getStrokeWidth()/zoomfactor);
    }
}
