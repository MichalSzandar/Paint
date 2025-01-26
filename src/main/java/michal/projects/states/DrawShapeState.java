package michal.projects.states;

import java.util.logging.Level;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.shape.Shape;
import michal.projects.MyLogger;
import michal.projects.Point;
import michal.projects.gui.PaintPane;
import michal.projects.shape_builders.ShapeBuilder;
import michal.projects.shapes.IMyShape;

public class DrawShapeState extends PaneState {

    private Shape shape;
    private Shape preview;
    private ShapeBuilder builder;

    public DrawShapeState(PaintPane canvas, ShapeBuilder builder) {
        super(canvas);
        this.builder = builder;
    }
    
    /**
     * @brief when user clicks on canvas we want to generate shape if there are enough points
     * @param e
     */
    @Override
    protected void onMouseClicked(MouseEvent e) {
        MyLogger.logger.log(Level.INFO, e.getX() + " " + e.getY());
        
        
        if(e.getButton()==MouseButton.PRIMARY)
        {
            builder.addPoint(new Point(e.getX(), e.getY()));
            try
            {
                shape = builder.generateShape(canvas.getActiveColor());
                MyLogger.logger.log(Level.INFO, "new shape added to the scene");
                canvas.addElement(shape);
                exitState(canvas);
    
            }catch(IndexOutOfBoundsException ex)
            {
                canvas.getChildren().remove(preview);
                preview = builder.getPreview();
                MyLogger.logger.log(Level.INFO, "new preview added to the scene");
                canvas.getChildren().add(preview);
            }
        }
        
    }

    /**
     * @brief called when user moves the mouse. Changes parameters of preview shape to match current mouse position
     * @param e mouse event
     */
    @Override
    protected void onMouseMoved(MouseEvent e) {
        if(preview instanceof IMyShape)
            ((IMyShape)preview).setSecondParameter(new Point(e.getX(), e.getY()));
    }

    /**
     * @brief called when mouse exits canvas. 
     * @description when mouse exits canvas this function changes all mouse events 
     *              to the ones from DefaultState
     * @param e mouse event
     * @param canvas PaintPane object that stores all the shapes on Scene
     * @see DefaultState
     * @see #exitState(MouseEvent, PaintPane)
     * @see PaintPane
     */
    @Override
    protected void onMouseExited(MouseEvent e) {
        if(builder.getNumberOfPoints()!=0)
            exitState(canvas);
    }

    /**
     * @brief clears preview shape and selected points, changes mouse events to default
     * @see PaintPane
     */
    private void exitState(PaintPane canvas) {
        canvas.getChildren().remove(preview);
        builder.clearPoints();
        canvas.setState(new DefaultState(canvas));
    }

    @Override
    protected void onMousePressed(MouseEvent e) {
        return;
    }

    @Override
    protected void onMouseDragged(MouseEvent e) {
        return;
    }

    @Override
    protected void onScroll(ScrollEvent e) {
        return;
    }
}
