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

    //private int [][][] blockshapes;
    private int currentBlockRotation;
    private int x; // is used to determine where in the game plan the tetris block is going to move in the x coordinate.
    private int y; // is used to determine where in the game plan the tetris block is going to move in the y coordinate.

    int[][] tempBlock;

    /**
     * Constructor used to create objects of a tetris block.
     * @param shape when creating a block, you enter 1:s and 0:s in a 2d array.
     * @param color and then you give it a color.
     */
   public TetrisBlock(int[][] shape, Color color){
       createBlock(shape, color);
       this.x = 4;
       this.y = 0;
       tempBlock = new int[shape[0].length][shape.length];
       rotationBlock();
   }

    //Skriv ut tBlock
    public void rotationBlock() {
        int[][] tempBlock = new int[shape[0].length][shape.length];
        //Save the currentBlock to a tempBlock array
        for(int col = shape[0].length - 1; col >= 0 ; col--){
            for(int row = 0; row < shape.length; row++){
                tempBlock[col][row] = shape[row][col];
            }
        }

        //Flip tempBlock horizontally
        for(int row = 0; row < tempBlock.length; row++){
            for(int col = 0; col < tempBlock[0].length - 1; col++){
                int temp = tempBlock[row][col];
                tempBlock[row][col] = tempBlock[row][tempBlock[0].length-1];
                tempBlock[row][tempBlock[0].length-1] = temp;
            }
        }
    }

   //the number 4 stands for the total rotations that can be made when rotating a block, 90*4
    /*
   private void blockRotation(){
       blockshapes = new int[4][][]; // this array includes every possible rotation that a tetris block can make.

       for(int i = 0; i<4; i++){

           int r = shape[0].length; // the number of rows of the block that has been rotated is equal to the number of colomns in the original shape
           int c = shape.length; // number of columns in the new shape will be equal to the number of rows in the original shape
           blockshapes[i] = new int[r][c]; //instanstiate a new array of int arrays for the rotations

           for(int j = 0; j < r; j++){ //we need to traverse the new array

               for(int y = 0; y< c; y++){ //we need a for loop inside the for loop because its an array of arrays

                   blockshapes[i][j][y] = shape[c - y - 1][j]; //assign values to the new array by using the original shape array
               }
           }
       }
   }

     */

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

    /*
   public void rotateBlock(){
        currentBlockRotation++;
        if(currentBlockRotation > 3) {
            currentBlockRotation = 0; //We do this because the array stores 4 rotations
            shape = blockshapes[currentBlockRotation]; //assign the variable shape the element of the blockshapes array and the index of currentblockrotation
        }

   }


     */

}
