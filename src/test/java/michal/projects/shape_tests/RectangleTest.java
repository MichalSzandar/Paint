package michal.projects.shape_tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import javafx.scene.paint.Color;
import michal.projects.Point;
import michal.projects.shapes.MyRectangle;

public class RectangleTest {
     private MyRectangle rectangle;

    @Before
    public void setup() {
        rectangle = new MyRectangle(0, 0, 0, 0, Color.BLACK);
    }

    @Test
    public void testMoveShape() {
        rectangle.moveShape(new Point(5, 5));

        assertEquals(5.0, rectangle.getX(), 0);
        assertEquals(5.0, rectangle.getY(), 0);
    }

    @Test
    public void testSetSecondParameter() {
        rectangle.setSecondParameter(new Point(5, 0));

        assertEquals(5.0, rectangle.getWidth(), 0);
    }

    @Test
    public void testSetParameters() {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(1, 1));
        points.add(new Point(1, 3));
        rectangle.setParameters(points);

        assertEquals(1, rectangle.getX(), 0);
        assertEquals(1, rectangle.getY(), 0);
        assertEquals(2, rectangle.getHeight(), 0);
    }
}
