package michal.projects.shape_builders;
import java.util.ArrayList;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import michal.projects.Point;

public abstract class ShapeBuilder {
    /**list of points for shape.*/
    protected ArrayList<Point> points;

    /**
     * initializes ShapeBuilder.
     */
    public ShapeBuilder() {
        points = new ArrayList<Point>();
    }

    /**
     * adds point to list of points.
     * @param p - point to add
     */
    public void addPoint(final Point p) {
        points.add(p);
    }

    /**
     * removes all point from the list.
     */
    public void clearPoints() {
        points.clear();
    }

    /**
     * @return number of points in the list.
     */
    public int getNumberOfPoints() {
        return points.size();
    }

    /**
     * sets the list of points to the list passed as argument.
     * 
     * @param points
     */
    public void loadPointsFromList(final ArrayList<Point> points) {
        this.points = points;
    }

    /**
     * generates shape from points gathered in the builder.
     * @param color color assigned to new shape
     * @return Shape object generated from given points
     */
    public abstract Shape generateShape(Color color);

    /**
     * creates a preview of what a shape will look like if we add another point.
     * @return uncomplete shape, because of lack of
     * paramters needed to create full shape
     */
    public abstract Shape getPreview();
}
