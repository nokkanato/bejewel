public class TestTile {
    private String color;
    private int row;
    private int col;
    private double x;
    private double y;

    public TestTile(String color,int row,int col,double width,double height){ // width,height
        this.color = color;
        this.row = row;
        this.col = col;
        this.x = row*width;
        this.y = row*height;
    }

    public String getColor(){
        return color;
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }
}