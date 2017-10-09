import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;


public class GameController extends Application {

    private LevelController levelController;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.levelController = new LevelController();
        primaryStage.setScene(levelController.getScene());
        primaryStage.show();
    }


    public static void main(String[] args) {
        Application.launch(GameController.class, args);
    }
}


