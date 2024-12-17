package michal.projects;
import java.util.ArrayList;
import java.util.logging.Level;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;

public class MyCircle extends Circle implements IMyShape
{
    private EditShapeState editState;
    
    /**
     * @brief created MyCircle object based on center point, radius, color
     * @param centerX x coordinate of circle's center
     * @param centerY y coordinate of circle's center
     * @param radius radius of circle
     * @param color color of shape
     */
    @SuppressWarnings("exports")
    public MyCircle(double centerX, double centerY, double radius, Color color)
    {
        super(centerX, centerY, radius);
        
        setFill(color);
        setStrokeType(StrokeType.INSIDE);
        setStrokeWidth(4);
        setStroke(Color.TRANSPARENT);

        editState = new EditShapeState();
    }

    @Override
    public void moveShape(Point point) {
       setCenterX(point.getX());
       setCenterY(point.getY());
    }

    @Override
    public void setSecondParameter(Point point) {
        setRadius(utils.distance(point, new Point(getCenterX(), getCenterY())));
    }

    @Override
    public void setActive() 
    {
        setStroke(utils.invertColor(getFill()));
        setOnMousePressed(event -> {editState.onMousePressed(event);});
        setOnMouseDragged(event -> {editState.onMouseDrag(event);});
        setOnScroll(event -> {editState.onScroll(event);});

        if(getParent() instanceof PaintPane)
            setOnMouseClicked(event -> {editState.onMouseClicked(event);});

        MyLogger.logger.log(Level.INFO, "is active");
    }

    @Override
    public void setDisabled() 
    {
        setStroke(Color.TRANSPARENT);

        setOnMousePressed(null);
        setOnMouseDragged(null);
        setOnScroll(null);
        setOnMouseClicked(null);

        MyLogger.logger.log(Level.INFO, "is disabled");
    }

    @Override
    public String getType() {
       return "Circle";
    }

    @Override
    public ArrayList<Point> getVertices() {
        ArrayList<Point> params = new ArrayList<>();
        params.add(new Point(getCenterX(), getCenterY()));
        params.add(new Point(getCenterX(), getCenterY() + getRadius()));
        return params;
    }

    @Override
    public void setParameters(ArrayList<Point> points) {
        moveShape(points.get(0));
        setSecondParameter(points.get(1));
    }

}
