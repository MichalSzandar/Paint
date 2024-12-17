package michal.projects;

import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;

public class PaintToolBar extends ToolBar {
    @SuppressWarnings("exports")
    public PaintToolBar(Button recButton, Button circleButton, Button triangleButton)
    {
        super(recButton, circleButton, triangleButton);
        setPrefHeight(100);
    }
}
