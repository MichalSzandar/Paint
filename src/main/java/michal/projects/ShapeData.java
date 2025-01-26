package michal.projects;
import java.io.Serializable;
import java.util.ArrayList;

//class to store data about shapes
public class ShapeData implements Serializable {
    private ArrayList<Point> parameters;
    private String fill;
    private double angle;
    private String type;
    private double scaleX;
    private double scaleY;
    
    public ShapeData(final ArrayList<Point> parameters, final String color, final double angle, final String type,
            final double scaleX, final double scaleY) {
        this.parameters = parameters;
        this.fill = color;
        this.angle = angle;
        this.type = type;
        this.scaleX = scaleX;
        this.scaleY = scaleY;
    }

    public final ArrayList<Point> getParameters() {
        return parameters;
    }

    public final String getFill() {
        return fill;
    }

    public final double getAngle() {
        return angle;
    }

    public final String getType() {
        return type;
    }

    public final double getScaleX() {
        return scaleX;
    }

    public final double getScaleY() {
        return scaleY;
    }
}
