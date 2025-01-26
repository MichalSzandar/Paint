package michal.projects;

import java.io.Serializable;

public class Point implements Serializable {
    private double x;
    private double y;

    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public final double getX() {
        return x;
    }

    public final double getY() {
        return y;
    }

    public final void setX(final double x) {
        this.x = x;
    }

    public final void setY(final double y) {
        this.y = y;
    }
}
