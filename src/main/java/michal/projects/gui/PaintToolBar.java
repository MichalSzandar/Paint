package michal.projects.gui;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;

public class PaintToolBar extends ToolBar {
    public PaintToolBar() {
        super();
        setPrefHeight(50);
    }

    /**
     * adds StateButton to the ToolBar.
     * @param button - Button to add
     */
    public void addStateButton(final StateButton button) {
        getItems().add(button);
    }

    /**
     * adds a color picker to tool bar.
     * @param colorPicker - ColorPicker to add
     */
    public void addColorPicker(final ColorPicker colorPicker) {
        getItems().add(colorPicker);
    }

    /**
     * adds a vbox to toolbar.
     * @param radiusControl - vbox to add
     */
    public void addRadiusControl(final VBox radiusControl) {
        getItems().add(radiusControl);
    }

    /**
     * adds a button to toolBar.
     * @param button
     */
    public void addButton(final Button button) {
        getItems().add(button);
    }

}
