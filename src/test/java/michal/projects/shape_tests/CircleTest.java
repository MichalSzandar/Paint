package michal.projects.shape_tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import javafx.scene.paint.Color;
import michal.projects.Point;
import michal.projects.shapes.MyCircle;

public class CircleTest {
    private MyCircle circle;

    @Before
    public void setup(){
        circle = new MyCircle(0, 0, 0, Color.BLACK);
    }

    @Test
    public void testMoveShape(){
        circle.moveShape(new Point(5, 5));

        assertEquals(5.0, circle.getCenterX(), 0);
        assertEquals(5.0, circle.getCenterY(), 0);
    }

    @Test
    public void testSetSecondParameter(){
        circle.setSecondParameter(new Point(5, 0));

        assertEquals(5.0, circle.getRadius(), 0);
    }

    @Test
    public void testSetParameters(){
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(1, 1));
        points.add(new Point(1, 3));
        circle.setParameters(points);

        assertEquals(1, circle.getCenterX(), 0);
        assertEquals(1, circle.getCenterY(), 0);
        assertEquals(2, circle.getRadius(), 0);
    }
}
