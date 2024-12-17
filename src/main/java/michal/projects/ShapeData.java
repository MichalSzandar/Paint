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
    
    public ShapeData(ArrayList<Point> parameters, String color, double angle, String type, double scaleX, double scaleY)
    {
        this.parameters = parameters;
        this.fill = color;
        this.angle = angle;
        this.type = type;
        this.scaleX = scaleX;
        this.scaleY = scaleY;
    }

    public ArrayList<Point> getParameters(){return parameters;}
    public String getFill(){return fill;}
    public double getAngle(){return angle;}
    public String getType(){return type;}
    public double getScaleX(){return scaleX;}
    public double getScaleY(){return scaleY;}
}
