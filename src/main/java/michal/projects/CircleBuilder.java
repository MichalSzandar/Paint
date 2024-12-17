package michal.projects;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class CircleBuilder extends ShapeBuilder 
{
    
    @SuppressWarnings("exports")
    @Override
    public Shape generateShape(Color color) 
    {
        if(points.size()!=2)
            throw new IndexOutOfBoundsException("not enough points to create full Circle, only preview available");
        
        return new MyCircle(points.get(0).getX(), points.get(0).getY(), utils.distance(points.get(1), points.get(0)), color);
    }

    @SuppressWarnings("exports")
    @Override
    public Shape getPreview() 
    {
        if(points.size()==1)
            return new MyCircle(points.get(0).getX(), points.get(0).getY(), 0, Color.GRAY);
        if(points.size() == 0)
            return new MyCircle(0, 0, 0, Color.GRAY);
        else
            throw new IndexOutOfBoundsException("you need at least one point to create preview");
    }
}
