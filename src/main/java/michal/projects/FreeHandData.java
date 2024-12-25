package michal.projects;

import java.io.Serializable;
import java.util.ArrayList;

public class FreeHandData implements Serializable{
    private final ArrayList<Double> points;
    private final String color;
    private final double strokeWidth;
    private final double opacity;

    public FreeHandData(ArrayList<Double> points, String color, double strokeWidth, double opacity){
        this.points = points;
        this.color = color;
        this.strokeWidth = strokeWidth;
        this.opacity = opacity;
    }

    public ArrayList<Double> getPoints(){return points;}
    public String getColor(){return color;}
    public double getStrokeWidth(){return strokeWidth;}
    public double getOpacity(){return opacity;}
}
