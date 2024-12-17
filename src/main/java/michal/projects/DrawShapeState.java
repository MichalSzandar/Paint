package michal.projects;

import java.util.logging.Level;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;

public class DrawShapeState {

    private Shape shape;
    private Shape preview;
    private ShapeBuilder builder;

    public DrawShapeState(ShapeBuilder builder)
    {
        this.builder = builder;
    }
    
    /**
     * @brief when user clicks on canvas we want to generate shape if there are enough points
     * @param e
     * @param canvas
     */
    @SuppressWarnings("exports")
    public void onMouseClicked(MouseEvent e, PaintPane canvas)
    {
        MyLogger.logger.log(Level.INFO, e.getX() + " " + e.getY());
        
        
        if(e.getButton()==MouseButton.PRIMARY)
        {
            builder.addPoint(new Point(e.getX(), e.getY()));
            try
            {
                shape = builder.generateShape(canvas.getActiveColor());
                MyLogger.logger.log(Level.INFO, "new shape added to the scene");
                canvas.getChildren().add(shape);
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
     * @param canvas PaintPane object that stores all the shapes on Scene
     */
    @SuppressWarnings("exports")
    public void onMouseMoved(MouseEvent e, PaintPane canvas)
    {
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
    @SuppressWarnings("exports")
    public void onMouseExited(MouseEvent e, PaintPane canvas)
    {
        if(builder.getNumberOfPoints()!=0)
            exitState(canvas);
    }

    /**
     * @brief clears preview shape and selected points, changes mouse events to default
     * @param canvas PaintPane object that stores all the shapes on Scene
     * @see PaintPane
     */
    private void exitState(PaintPane canvas)
    {
        canvas.getChildren().remove(preview);
        builder.clearPoints();
        canvas.setOnMouseClicked(event -> {DefaultState.onMouseClicked(event);});
        canvas.setOnMouseMoved(null);
        canvas.setOnMouseExited(null);
    }
}
