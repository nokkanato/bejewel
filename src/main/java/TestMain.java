
import java.util.ArrayList;

/**
 * Created by chananyu2539 on 10/3/2017 AD.
 */
public class TestMain {
    public static void main(String[] args) {

        LevelController levelController = new LevelController(4,4);

        levelController.printBoard();
        System.out.println(levelController.isFull());
        /// is full ask board  if fulll
        System.out.println(levelController.isNeededToDestroy());
        // is ask is needed To destory

//        ArrayList<Tile> d = levelController.getAllDestroyedTiles();
//        levelController.destroyJewel(d);





//
//        levelController.printBoard();
//        System.out.println(levelController.isFull());
//        levelController.addScore(d);
//        System.out.println(levelController.getScore());
//        levelController.clicked();
//
//        levelController.pushDown();
//        levelController.printBoard();



//        System.out.println("-----------------");
//        levelController.clicked(0,0);
//        levelController.clicked(1,0);
//        levelController.printBoard();
//        System.out.println("-----------------");
//        levelController.fillBoard();
//        levelController.printBoard();

    }
}
