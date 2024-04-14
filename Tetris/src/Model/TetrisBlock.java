/**
 * A model class that represents a tetris block.
 * The class has relevant getters to manage changes in coordinates in the gameArea.
 * Study the methods and see in which context they are used (find usages).
 */
package Model;
import java.awt.*;

public class TetrisBlock  {
    private int[][] shape;
    private Color color;
    private int x; // is used to determine where in the game plan the tetris block is going to move in the x coordinate.
    private int y; // is used to determine where in the game plan the tetris block is going to move in the y coordinate.

    /**
     * Constructor used to create objects of a tetris block.
     * @param shape when creating a block, you enter 1:s and 0:s in a 2d array.
     * @param color and then you give it a color.
     */
   public TetrisBlock(int[][] shape, Color color){
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

    /**
     * The methods below are used to increment or decrement x and y coordinates so that
     * we are able to move a block in tehe gameArea.
     */

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
        this.x = 4;
        this.y = -2;
    }

    public void goRight(){
        x++;
    }

    public void goLeft(){
        x--;
    }

    public void goDown(){
        y++;
    }

    public int checkLeft(){
        return x;
    }

    public int checkRight(){
        return x;
    }

    public void rotateBlock(){

    }

    public int getHeight(){
        return shape.length;
    }



}
