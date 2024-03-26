package Model;
import java.awt.*;
import java.util.*;

public class TetrisBlock  {
    private int[][] shape;
    private Color color;
   public TetrisBlock(int[][] shape, Color color){
       createBlock(shape, color);
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

}
