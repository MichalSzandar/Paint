package michal.projects;
import java.util.HashMap;

public class ShapeMap {
    private HashMap<String, ShapeBuilder> shapeMap;

    public ShapeMap()
    {
        shapeMap = new HashMap<>();
        shapeMap.put("Circle", new CircleBuilder());
        shapeMap.put("Rectangle", new RectangleBuilder());
        shapeMap.put("Triangle", new TriangleBuilder());
    }

    public ShapeBuilder getValue(String key)
    {
        return shapeMap.get(key);
    }

    public void addSet(String type, ShapeBuilder builder)
    {
        shapeMap.put(type, builder);
    }
}
