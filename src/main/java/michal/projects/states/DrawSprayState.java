package michal.projects.states;

import java.util.Random;

import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.shape.Circle;
import michal.projects.gui.PaintPane;

public class DrawSprayState extends PaneState {
    private Random random;
    private int sprayDensity;
    
    public DrawSprayState(final PaintPane canvas) {
        super(canvas);
        random = new Random();
        sprayDensity = 30;
    }

    @Override
    protected final void onMouseClicked(final MouseEvent e) {
        return;
    }

    @Override
    protected final void onMousePressed(final MouseEvent e) {
        return;
    }

    @Override
    protected final void onMouseDragged(final MouseEvent e) {
        spray(e.getX(), e.getY());
    }

    @Override
    protected final void onMouseMoved(final MouseEvent e) {
        return;
    }

    @Override
    protected final void onMouseExited(final MouseEvent e) {
        return;
    }

    private void spray(final double x, final double y) {
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

    @Override
    protected final void onScroll(final ScrollEvent e) {
        return;
    }
}
