package michal.projects.builder_tests;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import javafx.scene.paint.Color;
import michal.projects.Point;
import michal.projects.shape_builders.CircleBuilder;
import michal.projects.shapes.MyCircle;

public class CircleBuilderTest {
    CircleBuilder builder;
    @Before
    public void setup(){
        builder = new CircleBuilder();
        
    }

    @Test
    public void testGenerateCircle(){
        builder.addPoint(new Point(0, 0));
        builder.addPoint(new Point(5, 0));

        MyCircle circle = (MyCircle)builder.generateShape(Color.BLACK);
        assertEquals(0, circle.getCenterX(), 0);
        assertEquals(0, circle.getCenterY(), 0);
        assertEquals(5, circle.getRadius(), 0);
    }

    @Test
    public void testGetShapePreview(){
        builder.addPoint(new Point(0, 0));
        MyCircle preview = (MyCircle)builder.getPreview();

        assertEquals(0, preview.getCenterX(), 0);
        assertEquals(0, preview.getCenterY(), 0);
        assertEquals(0, preview.getRadius(), 0);
    }   
}
