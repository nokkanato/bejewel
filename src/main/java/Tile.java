import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Random;

class Tile extends StackPane {


    private String color;
    private int row;
    private int col;
    private double x;
    private double y;
    private int[] clicked = new int[2];
//    private LevelController levelController;





    private Color[] colors = new Color[] {
            Color.rgb(219,50, 54),
            Color.rgb(60, 186, 84),
            Color.rgb(72, 133, 237),
            Color.rgb(244, 194, 13),

    };


    public Tile(String color, int row, int col, double width, double height) {
        this.color = color;
        this.row = row;
        this.col = col;
        this.x = row*height;
        this.y = col*width;
//        this.levelController = levelController;

        Rectangle rectangle = new Rectangle( width, height);
        rectangle.setStroke(Color.WHITE);
        rectangle.setStrokeWidth(2);
        switch (color.toLowerCase()) {
            case "red":  rectangle.setFill(colors[0]); break;
            case "green": rectangle.setFill(colors[1]); break;
            case "blue": rectangle.setFill(colors[2]); break;
            case "yellow": rectangle.setFill(colors[3]);break;
        }
        rectangle.setArcWidth(20);
        rectangle.setArcHeight(20);
        // create label
        Label label = new Label( color);
        // set position
        setTranslateX( y);
        setTranslateY( x);
        int[] pos = new int[]{row,col};
       getChildren().addAll( rectangle, label);


    }
    public int[] getClicked() {
        return clicked;
    }

    public Tile getTile() {
        return this;
    }

    public void checkSwap(){
//        ArrayList<ArrayList<Integer>> pos


    }

    public String getColor() {
        return color;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }


}
