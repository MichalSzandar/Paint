package michal.projects;

import java.io.Serializable;
import java.util.ArrayList;

public class FreeHandData implements Serializable{
    private final ArrayList<Double> points;
    private final String color;
    private final double strokeWidth;
    private final double opacity;

    public FreeHandData(final ArrayList<Double> points, final String color, final double strokeWidth,
            final double opacity) {
        this.points = points;
        this.color = color;
        this.strokeWidth = strokeWidth;
        this.opacity = opacity;
    }

    public final ArrayList<Double> getPoints() {
        return points;
    }

    public final String getColor() {
        return color;
    }

    public final double getStrokeWidth() {
        return strokeWidth;
    }

    public final double getOpacity() {
        return opacity;
    }
}
