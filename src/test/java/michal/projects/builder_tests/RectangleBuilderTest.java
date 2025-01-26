package michal.projects.builder_tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import javafx.scene.paint.Color;
import michal.projects.Point;
import michal.projects.shape_builders.RectangleBuilder;
import michal.projects.shapes.MyRectangle;

public class RectangleBuilderTest {
     private RectangleBuilder builder;
    
    @Before
    public void setup() {
        builder = new RectangleBuilder(); 
    }

    @Test
    public void testGenerateRectangle() {
        builder.addPoint(new Point(0, 0));
        builder.addPoint(new Point(5, 0));

        MyRectangle rect = (MyRectangle)builder.generateShape(Color.BLACK);
        assertEquals(0, rect.getX(), 0);
        assertEquals(0, rect.getY(), 0);
        assertEquals(5, rect.getWidth(), 0);
    }

    @Test
    public void testGetShapePreview() {
        builder.addPoint(new Point(0, 0));
        MyRectangle preview = (MyRectangle)builder.getPreview();

        assertEquals(0, preview.getX(), 0);
        assertEquals(0, preview.getY(), 0);
        assertEquals(0, preview.getWidth(), 0);
    }   
}
