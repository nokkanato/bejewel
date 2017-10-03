import javafx.scene.Group;
import javafx.scene.Parent;

public class View {

    public Parent createContent(int sceneWidth, int sceneHeight, int row,int col) {
        double gridWidth = sceneWidth / row;
        double gridHeight = sceneHeight / col;
        Node[][] playfield = new Node[row][col];
        Group root = new Group();
        // initialize playfield
        for( int i=0; i < row; i++) {
            for( int j=0; j < col; j++) {
                Node node = new Node(   i + "," + j, i * gridWidth, j * gridHeight, gridWidth, gridHeight);
                root.getChildren().add( node);
                playfield[i][j] = node;
            }
        }
        return root;
    }

}
