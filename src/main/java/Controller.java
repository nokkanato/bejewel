import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;

import javafx.stage.Stage;

public class Controller extends Application{

    private static final int W = 7;
    private static final int H = 9;
    private static final int SIZE = 50;
    private Jewel selected = null;
    private List<Jewel> jewels;


    @Override
    public void start(Stage primaryStage) throws Exception {

        View view = new View();
        primaryStage.setScene(new Scene(view.createContent(7, 9, 50)));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }





}
