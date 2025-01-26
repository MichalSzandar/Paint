package michal.projects.shape_builders;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import michal.projects.Utils;
import michal.projects.shapes.MyCircle;

public class CircleBuilder extends ShapeBuilder {
    @Override
    public Shape generateShape(Color color) {
        if(points.size()!=2)
            throw new IndexOutOfBoundsException("not enough points to create full Circle, only preview available");
        
        return new MyCircle(points.get(0).getX(), points.get(0).getY(), Utils.distance(points.get(1), points.get(0)), color);
    }

    @Override
    public Shape getPreview() {
        if(points.size()==1)
            return new MyCircle(points.get(0).getX(), points.get(0).getY(), 0, Color.GRAY);
        if(points.size() == 0)
            return new MyCircle(0, 0, 0, Color.GRAY);
        else
            throw new IndexOutOfBoundsException("you need at least one point to create preview");
    }
}
