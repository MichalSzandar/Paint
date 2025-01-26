package michal.projects;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javafx.scene.paint.Color;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Shape;
import michal.projects.gui.PaintPane;
import michal.projects.shape_builders.ShapeBuilder;
import michal.projects.shapes.IMyShape;

public final class Serializer {
    @SuppressWarnings("exports")
    public static void serializeShapesFromCanvas(PaintPane canvas, String fileName) {
        List<Object> serializedObjects = new ArrayList<>();

        for(var node : canvas.getChildren())
        {
            if(node instanceof IMyShape){
                serializedObjects.add(new ShapeData(((IMyShape)node).getVertices(), 
                Utils.colorToHex((Color)((Shape)node).getFill()), 
                ((Shape)node).getRotate(), 
                ((IMyShape)node).getType(), 
                ((Shape)node).getScaleX(), 
                ((Shape)node).getScaleY()));

                MyLogger.logger.log(Level.INFO, "shape saved");
            } else if(node instanceof javafx.scene.shape.Path){
                var path = (javafx.scene.shape.Path)node ;
                ArrayList<Double> points = new ArrayList<>();
                path.getElements().forEach(element ->  {
                    if(element instanceof MoveTo){
                        MoveTo moveTo = (MoveTo)element;
                        points.add(moveTo.getX());
                        points.add(moveTo.getY());
                    } else if(element instanceof javafx.scene.shape.LineTo) {
                        javafx.scene.shape.LineTo lineTo = (javafx.scene.shape.LineTo) element;
                        points.add(lineTo.getX());
                        points.add(lineTo.getY());  
                    }
                });
                serializedObjects.add(new FreeHandData(points, 
                Utils.colorToHex((Color) path.getStroke()), 
                path.getStrokeWidth(),
                path.getOpacity()));

                MyLogger.logger.log(Level.INFO, "line saved");
            }   
        }

        try
        {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            out.writeObject(serializedObjects);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("exports")
    public static void desrializeShapes(PaintPane canvas, String fileName) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            @SuppressWarnings("unchecked")
            List<Object> serializedObjects = (List<Object>) in.readObject();
    
            for (Object data : serializedObjects) {
                if (data instanceof ShapeData) {
                    ShapeData shapeData = (ShapeData) data;
                    ShapeBuilder builder = canvas.shapeMap.getValue(shapeData.getType());
                    builder.loadPointsFromList(shapeData.getParameters());
                    Shape shape = builder.generateShape(Utils.hexToColor(shapeData.getFill()));
                    shape.setRotate(shapeData.getAngle());
                    shape.setScaleX(shapeData.getScaleX());
                    shape.setScaleY(shapeData.getScaleY());
                    shape.setStrokeWidth(4);
                    MyLogger.logger.log(Level.INFO, ((IMyShape) shape).getType() + " added to canvas");
                    canvas.getChildren().add(shape);
                } else if (data instanceof FreeHandData) {
                    FreeHandData freehandData = (FreeHandData) data;
    
                    javafx.scene.shape.Path path = new javafx.scene.shape.Path();
                    List<Double> points = freehandData.getPoints();
                    if (points.size() >= 2) {
                        path.getElements().add(new javafx.scene.shape.MoveTo(points.get(0), points.get(1)));
                        for (int i = 2; i < points.size(); i += 2) {
                            path.getElements().add(new javafx.scene.shape.LineTo(points.get(i), points.get(i + 1)));
                        }
                    }
                    path.setStroke(Utils.hexToColor(freehandData.getColor()));
                    path.setStrokeWidth(freehandData.getStrokeWidth());
                    path.setOpacity(freehandData.getOpacity());
    
                    MyLogger.logger.log(Level.INFO, "freehand line added to canvas");
                    canvas.getChildren().add(path);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
 