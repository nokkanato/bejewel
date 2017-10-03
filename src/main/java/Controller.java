import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller extends Application{
    private int sceneWidth = 1024;
    private int sceneHeight = 768;

    private int n = 10;
    private int m = 10;

    @Override
    public void start(Stage primaryStage) throws Exception {
        View view = new View();
        primaryStage.setScene(new Scene(view.createContent(sceneWidth, sceneHeight, n,m)));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

