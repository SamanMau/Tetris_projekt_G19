package Model;
import java.awt.*;
import java.util.*;

public class TetrisBlock  {
    private int[][] shape;
    private Color color;
    private int x;
    private int y;
   public TetrisBlock(int[][] shape, Color color){
       createBlock(shape, color);
       this.x = 3;
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

    public void setY() {
        y++;
    }
    public void setX() {
        x++;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
