package Model;
import java.awt.*;

public class Tetromino {
    private int[][] shape;
    private Color color;
    private int x;
    private int y;
   public Tetromino(int[][] shape, Color color){
       createBlock(shape, color);
       this.x = 4;
       this.y = 0;
   }

   public void createBlock(int[][] shape, Color color){
       this.shape = shape;
       this.color = color;
   }

   public int[][] getShape(){
       return this.shape;
   }

   public Color getColor(){
       return this.color;
   }

    public void incrementY() {
        y++;
    }

    public void incrementX() {
        x++;
    }

    public void decrementX() {
        x--;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void resetCoordinate(){
        this.x = 4; // 4
        this.y = -2; // -2
    }

    public void blockRight(){
       x++;
    }

    public void blockLeft(){
       x--;
    }

    public void blockDown(){
       y++;
    }

}
