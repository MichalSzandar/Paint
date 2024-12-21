package michal.projects.gui;

import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;

public class PaintToolBar extends ToolBar {
    public PaintToolBar(Button recButton, Button circleButton, Button triangleButton)
    {
        super(recButton, circleButton, triangleButton);
        setPrefHeight(100);
    }
}
