
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static java.lang.Math.abs;

/**
 * Created by chananyu2539 on 10/1/2017 AD.
 */
public class LevelController {

    private int ROWS;
    private int COLS;
    private Tile grid[][];
    private int[] neededTile;
    private int score;

    double GRID_WIDTH;
    double GRID_HEIGHT;

    private int MIN_COMBO = 3;

    private Tile firstClicked = null;
    private Tile secondClicked = null;

    private Map<Integer,String> numToString;
    private Scene scene;

    private Group root ;

    private void createMap(){
        numToString = new HashMap<>();
        numToString.put(0,"red");
        numToString.put(1,"green");
        numToString.put(2,"blue");
        numToString.put(3,"yellow");

    }

    public String getColor(int n){
        return numToString.get(n);
    }

    public Tile[][] getBoard(){
        return this.grid;
    }

    public void printBoard(){
        for (int row = 0;row<ROWS;row++){
            for (int col = 0; col<COLS; col++){
                if(grid[row][col]!=null){
                System.out.printf(""+grid[row][col].getColor()+" " +""+row+col);
                }
                else {
                    System.out.printf("null ");
                }
            }
            System.out.println();
        }
    }

    public LevelController() {
        this(4, 4);
    }

    public LevelController(int rows, int columns){
        this.root = new Group();

        this.COLS = columns;
        this.ROWS = rows;
        // initialize views
        // initialize methods
        // initialize models
        Random random = new Random();
        createMap();
        score = 0;
        GRID_WIDTH = 1024/rows;
        GRID_HEIGHT = 768/columns;
        int i = 0;
        neededTile = new int[COLS];
        grid = new Tile[ROWS][COLS];
        for(int row = 0; row<ROWS; row++){
            for(int col = 0; col<COLS; col++){
                String color = getColor(i%4);
                i++;
                grid[row][col] = new Tile(color,row,col,GRID_WIDTH, GRID_HEIGHT);
            }
        }
        grid[1][0] = new Tile("blue",1,0,GRID_WIDTH, GRID_HEIGHT);
        //Group root = new Group();
        scene = new Scene(createContent(grid));
    }
    private Parent createContent(Tile[][] grid){
        //Group root = new Group();
        root.getChildren().clear();
        for (int row =0 ; row<ROWS; row++){
            for (int col=0; col< COLS; col++){
                Tile tile= new Tile(grid[row][col].getColor(), row, col, GRID_WIDTH, GRID_HEIGHT);
                final int Row = row;
                final int Col = col;
                tile.setOnMouseClicked((MouseEvent event) -> {
                    System.out.println(""+tile.getRow()+tile.getCol());
//                    grid[0][0] = new Tile("green", 0, 0, GRID_WIDTH, GRID_HEIGHT);
                    clicked(Row, Col);

//                    createContent(grid);





                });

                root.getChildren().add(tile);
            }
        }
        return root;
    }

    public void test(){
        while (true){
            System.out.println("kwai");
        }
    }

    @SuppressWarnings("Duplicates")
    private ArrayList<DestroyedSequence> checkHorizontal(){
        ArrayList<DestroyedSequence> destroyedList = new ArrayList<>();
        for(int row = 0; row<ROWS; row++){
            int consecutiveSoFar = 1;
            int targetCol = 0;
            String targetColor = grid[row][targetCol].getColor();
            for(int col = 1; col<COLS; col++){
                String currentColor = grid[row][col].getColor();
                if(targetColor.equals(currentColor)){
                    consecutiveSoFar+=1;
                }
                else{
                    if(consecutiveSoFar >= MIN_COMBO){
                        destroyedList.add(new DestroyedSequence(row,targetCol,row,col-1));
                    }

                    targetColor = grid[row][col].getColor();
                    targetCol = col;
                    consecutiveSoFar=1;

                }
            }
            if(consecutiveSoFar >= MIN_COMBO){
                destroyedList.add(new DestroyedSequence(row,targetCol,row,COLS-1));
            }
        }
        return destroyedList;
    }

    @SuppressWarnings("Duplicates")
    private ArrayList<DestroyedSequence> checkVertical(){
        ArrayList<DestroyedSequence> destroyedList = new ArrayList<>();
        for(int col = 0; col<COLS; col++){
            int consecutiveSoFar = 1;
            int targetRow = 0;
            String targetColor = grid[targetRow][col].getColor();
            for(int row = 1; row<ROWS; row++){
                String currentColor = grid[row][col].getColor();
                if(targetColor.equals(currentColor)){
                    consecutiveSoFar+=1;
                }

                else{
                    if(consecutiveSoFar >= MIN_COMBO){
                        destroyedList.add(new DestroyedSequence(targetRow,col,row-1,col));
                    }

                    targetColor = grid[row][col].getColor();
                    targetRow = row;
                    consecutiveSoFar=1;

                }
            }
            if(consecutiveSoFar >= MIN_COMBO){
                destroyedList.add(new DestroyedSequence(targetRow,col,ROWS-1,col));
            }
        }
        return destroyedList;
    }

    public ArrayList<Tile> getAllDestroyedTiles(){

        ArrayList<Tile> allTiles = new ArrayList<>();

        boolean[][] checkedGrid = new boolean[ROWS][COLS];
        ArrayList<DestroyedSequence> allDestroyedSequence = new ArrayList<>();
        allDestroyedSequence.addAll(checkVertical());
        allDestroyedSequence.addAll(checkHorizontal());

        for (int i = 0; i < allDestroyedSequence.size();i++){
            DestroyedSequence currentSequence = allDestroyedSequence.get(i);
            int[] fromRowCol = currentSequence.getFromAxis();
            int[] toRowCol = currentSequence.getToAxis();
            int row0 = fromRowCol[0]; int col0 = fromRowCol[1];
            int rowN = toRowCol[0]; int colN = toRowCol[1];

            for (int j =row0;j<=rowN;j++){
                for (int k = col0; k<=colN; k++){
                    checkedGrid[j][k] = true;
                }
            }

        }
        for (int row = 0;row<ROWS;row++){
            for (int col = 0; col<COLS; col++){
                if(checkedGrid[row][col]){allTiles.add(grid[row][col]);}
            }
        }

        return allTiles;



    }

    public void pushDown() {
        int dest;
        for(int col = 0; col < COLS; col++){
            dest = ROWS-1;
            for(int row = ROWS-2; row>=0; row--){
                if(grid[row][col] == null){
                    continue;
                }

                else {
                    if(grid[dest][col] != null) dest--;
                    if(dest != row){
                        grid[dest][col] = grid[row][col].getTile();
                        grid[row][col] = null;
                    }
                }
            }
        }
    }

    public boolean isNeededToDestroy(){

        ArrayList<Tile> destroyedTile = getAllDestroyedTiles();

        return destroyedTile.size() != 0;

    }


    public Tile[][] destroyJewel(ArrayList<Tile> destroyedList){

        for (int i = 0; i < destroyedList.size(); i++) {
            Tile currentTile = destroyedList.get(i);
            int removedRow = currentTile.getRow();
            int removedCol = currentTile.getCol();
            grid[removedRow][removedCol] = null;
        }
        return grid;

    }

    public boolean isNextTile(Tile a, Tile b){

        return abs(a.getRow()-b.getRow()) + abs(a.getCol()-b.getCol()) == 1;
    }

    public void clicked(int row,int col){
        if (firstClicked != null){
            secondClicked = grid[row][col];
        }
        else {
            firstClicked = grid[row][col];
        }
        if(secondClicked!=null){

            // check first and second next to each other
            if(isNextTile(firstClicked,secondClicked)){
                // true: swap
                int firstRow = firstClicked.getRow();
                int firstCol = firstClicked.getCol();
                int secondRow = secondClicked.getRow();
                int secondCol = secondClicked.getCol();
                grid[firstRow][firstCol] = secondClicked;
                grid[secondRow][secondCol] = firstClicked;

                //get all destroy tile
                ArrayList<Tile> destroyedTile = getAllDestroyedTiles();

                //if invalid move
                if(destroyedTile.size() == 0){
                    //swap back
                    grid[firstRow][firstCol] = firstClicked;
                    grid[secondRow][secondCol] = secondClicked;
                }
                else {
                    addScore(destroyedTile);
                    destroyJewel(destroyedTile);
                }
            }
            //implement it hereee naa mind
            fillBoard();
            createContent(getGrid());




            //reset
            firstClicked = null;
            secondClicked = null;
        }
    }

    public void addScore(ArrayList<Tile> destroyedList){
        score+= destroyedList.size();
    }

    private void getNumberOfNeededTile(){
        for(int col = 0;col<COLS;col++){
            for (int row = 0;row<ROWS;row++){
                if(grid[row][col] == null){
                    neededTile[col]+=1;
                }
            }
        }
    }

    public ArrayList<Tile[]> createJewel(){
        pushDown();
        ArrayList<Tile[]> newJewel = new ArrayList<>();
        Random random = new Random();

        for (int col = 0; col<COLS; col++){
            int currentColAmount = neededTile[col];
            Tile[] currentColJewel = new Tile[currentColAmount];
            for( int jewelNumber = 0;jewelNumber<currentColAmount;jewelNumber++){

                String color = getColor(random.nextInt(4));

                currentColJewel[jewelNumber] = new Tile(color,jewelNumber,col,GRID_WIDTH,GRID_HEIGHT);


            }
            newJewel.add(currentColJewel);


        }
        return newJewel;
    }

    public void fillBoard(){
        if (!isFull()){
            getNumberOfNeededTile();
            ArrayList<Tile[]> newJewel =  createJewel();
            for(int col = 0; col<COLS;col++){
                Tile[] currentCol = newJewel.get(col);
                for(int row = 0; row<currentCol.length; row++){
                    grid[row][col] = currentCol[row];
                }
            }
        }
    }


    public boolean isFull(){
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if(grid[i][j]==null){
                    return false;
                }
            }

        }
        return true;
    }

    public int getScore() {
        return score;
    }

    public Tile[][] getGrid(){
        return this.grid;
    }

    public Scene getScene() {
        return scene;
    }
}
