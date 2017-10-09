
/**
 * Created by chananyu2539 on 10/2/2017 AD.
 */
public class DestroyedSequence {
    private int fromRow;
    private int fromCol;
    private int toRow;
    private int toCol;

    public DestroyedSequence(int fromRow,int fromCol,int toRow,int toCol){
        this.fromRow = fromRow;
        this.fromCol = fromCol;
        this.toRow = toRow;
        this.toCol = toCol;
    }

    public int[] getFromAxis(){
        return new int[] {fromRow,fromCol};
    }

    public int[] getToAxis(){
        return new int[] {toRow,toCol};
    }

}
