package michal.projects.gui;

import java.util.logging.Level;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import michal.projects.MyLogger;
import michal.projects.states.PaneState;

public class ShapeButton extends Button
{
    public ShapeButton(PaintPane canvas, PaneState state)
    {
        super("");
        setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent e)
            {   
                canvas.setState(state);
                MyLogger.logger.log(Level.INFO, "draw shape enabled");
            }
        });
    }
}
