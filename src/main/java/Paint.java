import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Paint extends Application {
    private static final int W = 7;
    private static final int H = 9;
    private static final int SIZE = 50;
    private Jewel selected = null;
    private List<Jewel> jewels;


//    public Paint(int width, int height, int size, List<Jewel> jewels){
//
//    }




    private Parent createContent(int width, int height, int size) {
        Pane root = new Pane();
        root.setPrefSize(width * size + 150, height * size);

        jewels = IntStream.range(0, width * height)
                .mapToObj(i -> new Point2D(i % width, i / width))
                .map(Jewel::new)
                .collect(Collectors.toList());

        root.getChildren().addAll(jewels);

        Text textScore = new Text();
        textScore.setTranslateX(width * size);
        textScore.setTranslateY(100);
        textScore.setFont(Font.font(68));

        root.getChildren().add(textScore);
        return root;
    }




    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent(7, 9, 50)));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
//
}
