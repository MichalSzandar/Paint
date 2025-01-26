package michal.projects.shape_builders;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import michal.projects.shapes.MyTriangle;

public class TriangleBuilder extends ShapeBuilder {

    @Override
    public final Shape generateShape(final Color color) {
        if (points.size() != 2) {
            throw new IndexOutOfBoundsException(
                "not enough points to create full Triangle, only preview available");
        }

        return new MyTriangle(
            points.get(0).getX(),
            points.get(0).getY(),
            points.get(1).getX(),
            points.get(1).getY(),
            color);
    }

    @Override
    public final Shape getPreview() {
        if (points.size() != 1) {
            throw new IndexOutOfBoundsException(
                "you need at least one point to create preview");
        }

        return new MyTriangle(points.get(0).getX(),
        points.get(0).getY(),
        points.get(0).getX(),
        points.get(0).getY(),
        Color.GRAY);
    }
}
