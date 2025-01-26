package michal.projects.gui;

import java.util.logging.Level;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import michal.projects.MyLogger;
import michal.projects.states.PaneState;

public class StateButton extends Button {
    /**
     * creates new StateButon object and sets
     * PaintPane state to given PaneState.
     * @param canvas - main PaintPane on which we are drawing
     * @param state - state that we should switch to
     * once user clicks on the button
     */
    public StateButton(final PaintPane canvas, final PaneState state) {
        super("");
        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent e) {
                canvas.setState(state);
                MyLogger.logger.log(Level.INFO, "draw shape enabled");
            }
        });
    }
}
