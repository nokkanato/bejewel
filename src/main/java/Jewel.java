import com.sun.javafx.fxml.builder.TriangleMeshBuilder;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.TriangleMesh;

import java.util.List;
import java.util.Random;

public class Jewel extends Parent {

    private static final int W = 7;
    private static final int H = 9;
    private static final int SIZE = 50;
    private Jewel selected = null;
    private List<Jewel> jewels;

    private Color[] colors = new Color[] {
            Color.rgb(60, 186, 84),
            Color.rgb(244, 194, 13),
            Color.rgb(219,50, 54),
            Color.rgb(72, 133, 237),
    };


    private Circle circle = new Circle(SIZE / 2);

    public Jewel(Point2D point) {
        DropShadow dropShadow2 = new DropShadow();
        dropShadow2.setOffsetX(3.0);
        dropShadow2.setOffsetY(1.0);
        circle.setCenterX(SIZE / 2);
        circle.setCenterY(SIZE / 2);
        circle.setEffect(dropShadow2);

        circle.setFill(colors[new Random().nextInt(colors.length)]);

        setTranslateX(point.getX() * SIZE);
        setTranslateY(point.getY() * SIZE);
        getChildren().add(circle);

        setOnMouseClicked(event -> {
            if (selected == null) {
                System.out.println("clicked");
                selected = this;
            }
            else {
                swap(selected, this);
                checkState();
                selected = null;
            }
        });
    }
    public void swap(Jewel selected, Jewel swap){

    }
    public void checkState() {

    }

    public void randomize() {
        circle.setFill(colors[new Random().nextInt(colors.length)]);
    }

    public int getColumn() {
        return (int)getTranslateX() / SIZE;
    }

    public int getRow() {
        return (int)getTranslateY() / SIZE;
    }

    public void setColor(Paint color) {
        circle.setFill(color);
    }

    public Paint getColor() {
        return circle.getFill();
    }
}