package michal.projects.shapes;

import java.util.ArrayList;
import java.util.logging.Level;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.StrokeType;
import michal.projects.MyLogger;
import michal.projects.Point;
import michal.projects.Utils;

public class MyTriangle extends Polygon implements IMyShape
{
    private double difX, difY;
    private boolean isActive;

    public MyTriangle(double startX, double startY, double endX, double endY, Color borderColor)
    {
        super(new double[]{startX, startY, endX - 50.0, endY, endX + 50.0, endY});

        setFill(borderColor);
        setStrokeType(StrokeType.INSIDE);
        setStrokeWidth(4);
        setStroke(Color.TRANSPARENT);
        isActive = false;
    }

    @Override
    public void moveShape(Point point) {
        difX = getPoints().get(0) - point.getX();
        difY = getPoints().get(1) - point.getY();
        getPoints().set(0, getPoints().get(0) - difX);
        getPoints().set(1, getPoints().get(1) - difY);
        getPoints().set(2, getPoints().get(2) - difX);
        getPoints().set(3, getPoints().get(3) - difY);
        getPoints().set(4, getPoints().get(4) - difX);
        getPoints().set(5, getPoints().get(5) - difY);
    }

    @Override
    public void setSecondParameter(Point point) {
        getPoints().set(2, point.getX() - 50.0);
        getPoints().set(3, point.getY());
        getPoints().set(4, point.getX() + 50.0);
        getPoints().set(5, point.getY());
    }

    @Override
    public void setParameters(ArrayList<Point> points) {
        moveShape(points.get(0));
        setSecondParameter(points.get(1));
    }

    @Override
    public void setActive() 
    {
        setStroke(Utils.invertColor(getFill()));
        isActive = true;

        MyLogger.logger.log(Level.INFO, "is active");
    }

    @Override
    public void setDisabled() 
    {
        setStroke(Color.TRANSPARENT);
        isActive = false;

        MyLogger.logger.log(Level.INFO, "is disabled");
    }

    @Override
    public String getType() {
        return "Triangle";
    }

    @Override
    public ArrayList<Point> getVertices() {
        ArrayList<Point> params = new ArrayList<>();
        params.add(new Point(getPoints().get(0), getPoints().get(1)));
        params.add(new Point((getPoints().get(2) + getPoints().get(4))/2.0, (getPoints().get(3) + getPoints().get(5))/2.0));
        return params;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

}
