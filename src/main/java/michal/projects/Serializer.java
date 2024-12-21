package michal.projects;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import michal.projects.gui.PaintPane;
import michal.projects.shape_builders.ShapeBuilder;
import michal.projects.shapes.IMyShape;

public final class Serializer {
    @SuppressWarnings("exports")
    public static void serializeShapesFromCanvas(PaintPane canvas, String fileName)
    {
        List<ShapeData> shapes = new ArrayList<ShapeData>();

        for(var node : canvas.getChildren())
        {
            if(node instanceof IMyShape)
                shapes.add(new ShapeData(((IMyShape)node).getVertices(), Utils.colorToHex((Color)((Shape)node).getFill()), ((Shape)node).getRotate(), ((IMyShape)node).getType(), ((Shape)node).getScaleX(), ((Shape)node).getScaleY()));
            
            MyLogger.logger.log(Level.INFO, "shape saved");
        }

        try
        {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            out.writeObject(shapes);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("exports")
    public static void desrializeShapes(PaintPane canvas, String fileName)
    {
        try
        {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            @SuppressWarnings("unchecked")
            List<ShapeData> shapeData = (List<ShapeData>) in.readObject();

            for (ShapeData data : shapeData) {
                if (data != null) {
                    ShapeBuilder builder = canvas.shapeMap.getValue(data.getType());
                    builder.loadPointsFromList(data.getParameters());
                    Shape shape = builder.generateShape(Utils.hexToColor(data.getFill()));
                    shape.setRotate(data.getAngle());
                    shape.setScaleX(data.getScaleX());
                    shape.setScaleY(data.getScaleY());
                    shape.setStrokeWidth(4);
                    MyLogger.logger.log(Level.INFO, ((IMyShape)shape).getType() + " added to canvas");
                    canvas.getChildren().add(shape);
                }
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
 