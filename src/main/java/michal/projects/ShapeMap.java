package michal.projects;
import java.util.HashMap;

import michal.projects.shape_builders.CircleBuilder;
import michal.projects.shape_builders.RectangleBuilder;
import michal.projects.shape_builders.ShapeBuilder;
import michal.projects.shape_builders.TriangleBuilder;

public class ShapeMap {
    private HashMap<String, ShapeBuilder> shapeMap;

    public ShapeMap()
    {
        shapeMap = new HashMap<>();
        shapeMap.put("Circle", new CircleBuilder());
        shapeMap.put("Rectangle", new RectangleBuilder());
        shapeMap.put("Triangle", new TriangleBuilder());
    }

    @SuppressWarnings("exports")
    public final ShapeBuilder getValue(final String key) {
        return shapeMap.get(key);
    }

    @SuppressWarnings("exports")
    public final void addSet(final String type, final ShapeBuilder builder)
    {
        shapeMap.put(type, builder);
    }
}
