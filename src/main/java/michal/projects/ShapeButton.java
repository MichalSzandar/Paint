package michal.projects;

import java.util.logging.Level;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ShapeButton extends Button
{
    public ShapeButton(String name, PaintPane canvas, DrawShapeState state)
    {
        super(name);
        setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent e)
            {   
                canvas.setOnMouseClicked(event -> {state.onMouseClicked(event, canvas);});
                canvas.setOnMouseMoved(event->{state.onMouseMoved(event, canvas);});
                canvas.setOnMouseExited(event -> {state.onMouseExited(event, canvas);});

                MyLogger.logger.log(Level.INFO, "draw shape enabled");
            }
        });
    }
}
