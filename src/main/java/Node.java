import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.Random;

class Node extends StackPane {
    private Color[] colors = new Color[] {
            Color.rgb(60, 186, 84),
            Color.rgb(244, 194, 13),
            Color.rgb(219,50, 54),
            Color.rgb(72, 133, 237),
    };


    public Node(String name, double x, double y, double width, double height) {

//        //create circle
//        Circle circle = new Circle(40);
//        circle.setStroke(Color.BLACK);
//        circle.setFill(colors[new Random().nextInt(colors.length)]);



        // create rectangle
        Rectangle rectangle = new Rectangle( width, height);
        rectangle.setStroke(Color.WHITE);
        rectangle.setStrokeWidth(2);

        rectangle.setFill(colors[new Random().nextInt(colors.length)]);
        rectangle.setArcWidth(20);
        rectangle.setArcHeight(20);

        // create label
        Label label = new Label( name);

        // set position
        setTranslateX( x);
        setTranslateY( y);

        getChildren().addAll( rectangle, label);
        setOnMouseClicked(event -> {
            System.out.println(name);

        });

    }

}
