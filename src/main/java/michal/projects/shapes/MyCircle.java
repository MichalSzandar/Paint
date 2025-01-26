package michal.projects.shapes;
import java.util.ArrayList;
import java.util.logging.Level;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import michal.projects.MyLogger;
import michal.projects.Point;
import michal.projects.Utils;

public class MyCircle extends Circle implements IMyShape {
    /**defines wether shape is set asactive or not. */
    private boolean isActive;
    /**
     * initializes MyCircle object based on center point, radius, color.
     * @param centerX x coordinate of circle's center
     * @param centerY y coordinate of circle's center
     * @param radius radius of circle
     * @param color color of shape
     */
    public MyCircle(final double centerX, final double centerY,
                    final double radius, final Color color) {
        super(centerX, centerY, radius);

        setFill(color);
        setStrokeType(StrokeType.INSIDE);
        setStrokeWidth(4);
        setStroke(Color.TRANSPARENT);

        isActive = false;
    }

    @Override
    public final void moveShape(final Point point) {
        setCenterX(point.getX());
        setCenterY(point.getY());
    }

    @Override
    public final void setSecondParameter(final Point point) {
        setRadius(Utils.distance(point, new Point(getCenterX(), getCenterY())));
    }

    @Override
    public final void setActive() {
        setStroke(Utils.invertColor(getFill()));
        isActive = true;

        MyLogger.logger.log(Level.INFO, "is active");
    }

    @Override
    public final void setDisabled() {
        setStroke(Color.TRANSPARENT);
        isActive = false;

        MyLogger.logger.log(Level.INFO, "is disabled");
    }

    @Override
    public final String getType() {
        return "Circle";
    }

    @Override
    public final ArrayList<Point> getVertices() {
        ArrayList<Point> params = new ArrayList<>();
        params.add(new Point(getCenterX(), getCenterY()));
        params.add(new Point(getCenterX(), getCenterY() + getRadius()));
        return params;
    }

    @Override
    public final void setParameters(final ArrayList<Point> points) {
        moveShape(points.get(0));
        setSecondParameter(points.get(1));
    }

    @Override
    public final boolean isActive() {
        return isActive;
    }

}
