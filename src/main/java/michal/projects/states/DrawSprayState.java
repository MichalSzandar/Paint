package michal.projects.states;

import java.util.Random;

import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import michal.projects.gui.PaintPane;

public class DrawSprayState extends PaneState{
    private Random random;
    private int sprayDensity;
    
    public DrawSprayState(PaintPane canvas){
        super(canvas);
        random = new Random();
        sprayDensity = 30;
    }

    @Override
    protected void onMouseClicked(MouseEvent e) {
        return;
    }

    @Override
    protected void onMousePressed(MouseEvent e) {
        return;
    }

    @Override
    protected void onMouseDragged(MouseEvent e) {
        spray(e.getX(), e.getY());
    }

    @Override
    protected void onMouseMoved(MouseEvent e) {
        return;
    }

    @Override
    protected void onMouseExited(MouseEvent e) {
        return;
    }
    
    private void spray(double x, double y) {
        for (int i = 0; i < sprayDensity; i++) {
            // Generate random angle and distance for each dot
            double angle = random.nextDouble() * 2 * Math.PI; 
            double distance = random.nextDouble() * canvas.getCurrentBrushSize(); 

            // Calculate the coordinates of the dot
            double dx = x + distance * Math.cos(angle);
            double dy = y + distance * Math.sin(angle);

            // Create a small circle to represent the spray dot
            Circle dot = new Circle(dx, dy, 1, canvas.getActiveColor()); // Radius 1, Black color
            canvas.getChildren().add(dot);
        }
    }
}
