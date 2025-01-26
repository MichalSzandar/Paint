package michal.projects.shape_tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import javafx.scene.paint.Color;
import michal.projects.Point;
import michal.projects.shapes.MyTriangle;

public class TriangleTest {
     private MyTriangle triangle;

    @Before
    public void setup(){
        triangle = new MyTriangle(0, 0, 0, 0, Color.BLACK);
    }

    @Test
    public void testMoveShape() {
        triangle.moveShape(new Point(5, 5));

        assertEquals(5.0, triangle.getPoints().get(0), 0);
        assertEquals(5.0, triangle.getPoints().get(1), 0);
    }

    @Test
    public void testSetSecondParameter() {
        triangle.setSecondParameter(new Point(5, 0));

        assertEquals(5.0, triangle.getPoints().get(2) + 50, 0);
    }

    @Test
    public void testSetParameters() {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(1, 1));
        points.add(new Point(1, 3));
        triangle.setParameters(points);

        assertEquals(1, triangle.getPoints().get(0), 0);
        assertEquals(1, triangle.getPoints().get(1), 0);
        assertEquals(1, triangle.getPoints().get(2) + 50, 0);
    }
}
