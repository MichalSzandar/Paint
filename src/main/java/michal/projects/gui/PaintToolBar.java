package michal.projects.gui;

import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;

public class PaintToolBar extends ToolBar {
    public PaintToolBar(Button recButton, Button circleButton, Button triangleButton, Button pencilButton)
    {
        super(recButton, circleButton, triangleButton, pencilButton);
        setPrefHeight(100);
    }
}
