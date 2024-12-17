package michal.projects;
import java.io.Serializable;
import java.util.logging.Level;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

import javafx.scene.shape.Shape;

public class EditShapeState implements Serializable
{
    private double difX;
    private double difY;
    private double startRotation;
    private Shape shape;

    /**
     * @brief when user clicks right mouse button we want to change shape color
     * @param e
     */
    @SuppressWarnings("exports")
    public void onMouseClicked(MouseEvent e)
    {
        if(e.getPickResult().getIntersectedNode() instanceof Shape)
            shape = (Shape)e.getPickResult().getIntersectedNode();
            
        if(e.getButton() == MouseButton.SECONDARY && e.isControlDown())
        {
            shape.setFill(((PaintPane)shape.getParent()).getActiveColor());
        }
    }
   
    @SuppressWarnings("exports")
    public void onMousePressed(MouseEvent e)
    {
        shape = (Shape)e.getPickResult().getIntersectedNode();
        if(shape instanceof IMyShape)
        {
            difX = e.getSceneX() - ((IMyShape)shape).getVertices().get(0).getX();
            difY = e.getSceneY() - ((IMyShape)shape).getVertices().get(0).getY();
            startRotation = shape.getRotate();
        }
        MyLogger.logger.log(Level.INFO, "mouse pressed");
    }

    @SuppressWarnings("exports")
    public void onMouseDrag(MouseEvent e)
    {
        if(e.getButton() == MouseButton.PRIMARY && !e.isShiftDown() && shape instanceof IMyShape)
        {
            ((IMyShape)shape).moveShape(new Point(e.getSceneX()-difX, e.getSceneY()-difY));
        }
        else if(e.getButton() == MouseButton.SECONDARY)
        {
            shape.setRotate((startRotation + e.getSceneX()-((IMyShape)shape).getVertices().get(0).getX() - difX)%360);
        }
    }

    @SuppressWarnings("exports")
    public void onScroll(ScrollEvent e)
    {
        Shape shape = (Shape)e.getPickResult().getIntersectedNode();
        double zoomfactor = 1.05;
        double deltaY = e.getDeltaY();
        if(deltaY<0)
            zoomfactor = 1.8 - zoomfactor;
        shape.setScaleX(shape.getScaleX()*zoomfactor);
        shape.setScaleY(shape.getScaleY()*zoomfactor);
        shape.setStrokeWidth(shape.getStrokeWidth()/zoomfactor);
    }

}
