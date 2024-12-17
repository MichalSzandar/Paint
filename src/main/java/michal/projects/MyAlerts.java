package michal.projects;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public final class MyAlerts {
    public static void displayInfo()
    {
        Alert info = new Alert(AlertType.INFORMATION);
        info.setHeight(500);
        info.setWidth(300);
        info.setHeaderText("about this application");
        info.setTitle("Information");
        info.setContentText("use: simple graphic editor which allows to: \ncreate, move, resize, recolor, rotate shapes\nauthor: Michał Szandarowski");
        info.showAndWait();
    }

    public static void displayControls()
    {
        Alert controls = new Alert(AlertType.INFORMATION);
        controls.setHeight(500);
        controls.setWidth(300);
        controls.setHeaderText("Controls");
        controls.setTitle("Information");
        controls.setContentText("activate shape: left mouse button\nrotate: left mouse button + shift\nresize: scroll\nrecolor:right mouse button + ctrl");
        controls.showAndWait();

    }

}
