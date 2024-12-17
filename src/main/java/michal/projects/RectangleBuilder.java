package michal.projects;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class RectangleBuilder extends ShapeBuilder 
{
    @SuppressWarnings("exports")
    @Override
    public Shape generateShape( Color color) 
    {
        if(points.size()!=2)
            throw new IndexOutOfBoundsException("not enough points to create full Rectangle, only preview available");

        MyRectangle myRec = new MyRectangle(0, 0, 0, 0, color);
        myRec.setParameters(points);
        return myRec;
    }

    @SuppressWarnings("exports")
    @Override
    public Shape getPreview() 
    {
        if(points.size()!=1)
            throw new IndexOutOfBoundsException("you need at least one point to create preview");

        return new MyRectangle(points.get(0).getX(), points.get(0).getY(), 0, 0, Color.GRAY);
    }
}
