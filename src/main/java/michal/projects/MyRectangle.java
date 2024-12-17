package michal.projects;

import java.util.ArrayList;
import java.util.logging.Level;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

public class MyRectangle extends Rectangle implements IMyShape
{
    private double initialX;
    private double initialY;
    private EditShapeState editState;

    @SuppressWarnings("exports")
    public MyRectangle(double startX, double startY, double width, double height, Color borderColor)
    {
        super(startX, startY, width, height);
        initialX = getX();
        initialY = getY();

        setFill(borderColor);
        setStrokeType(StrokeType.INSIDE);
        setStrokeWidth(4);
        setStroke(Color.TRANSPARENT);

        editState = new EditShapeState();
    }

    @Override
    public void moveShape(Point point) {
        setX(point.getX());
        setY(point.getY());
        initialX = getX();
        initialY = getY();
    }

    @Override
    public void setSecondParameter(Point point) {
        double width = point.getX() - initialX;
        double height = point.getY() - initialY;

        setWidth(Math.abs(width));
        setHeight(Math.abs(height));

        if(width < 0)
            setX(point.getX());
        if(height < 0)
            setY(point.getY());
    }

    @Override
    public void setParameters(ArrayList<Point> points) {
        moveShape(points.get(0));
        setSecondParameter(points.get(1));
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
        return "Rectangle";
    }

    @Override
    public ArrayList<Point> getVertices() {
        ArrayList<Point> params = new ArrayList<>();
        params.add(new Point(getX(), getY()));
        params.add(new Point(getX() + getWidth(), getY() + getHeight()));
        return params;
    }


}
