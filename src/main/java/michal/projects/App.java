package michal.projects;

import javafx.application.Application;
import javafx.stage.Stage;
import michal.projects.gui.GUI;

public class App extends Application {
    public static void main(final String[] args) throws Exception {
        MyLogger.loggerConfig();
        launch(args);
    }

    @SuppressWarnings("exports")
    @Override
    public final void start(final Stage stage) {
        new GUI(stage);
    }
}
