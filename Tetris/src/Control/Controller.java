/**
 * The controller class which handles the essential game logic.
 */
package Control;

import Model.ListOfBlocks;
import Model.TetrisBlock;
import View.MainFrame;
import View.Playfield;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Controller{
    private ListOfBlocks listOfBlocksObj;
    private ArrayList<int[][]> listOfShape;
    private ArrayList<Color> listOfColors;
    private TetrisBlock block;
    private int kvadrat = 30;
    private final int column = 10;
    private final int row = 20;
    private Random rd = new Random();
    private int randomNum = rd.nextInt(7); // 7
    private Color[][] board = new Color[20][10];
    private Timer speed;
    private boolean collision;
    private boolean gameState = false;
    private Playfield playfield;
    private MainFrame mainFrame;
    public Controller(){
        this.playfield = new Playfield(this);
        mainFrame = new MainFrame(this, playfield);
        listOfBlocksObj = new ListOfBlocks();
        this.listOfShape = listOfBlocksObj.getBlockList();
        this.listOfColors = listOfBlocksObj.getListOfColors();
        generateBlock();
        collision = false;
    }

    public void startTimer(boolean gameState){
        this.gameState = gameState;
        if(gameState){
            this.speed = new Timer(400, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(collision){
                        addColorToBoard();
                        generateBlock();
                        collision = false;
                    }
                    if((block.getShape().length + block.getY()) * kvadrat == 600){
                        collision = true;
                    }
                    else{
                        block.incrementY();
                        collision = false;
                    }
                    playfield.repaint();
                }
            });
            this.speed.start();
        }
    }

    /**
     * Generates a random number between 0 - 6. This random generated number
     * is then used to get a tetris block from an index. We retrieve its shape
     * and color, and then we create a new instance of "block".
     */
    public void generateBlock(){
        randomNum = rd.nextInt(7);
        int[][] shape = listOfShape.get(randomNum);
        Color color = listOfColors.get(randomNum);
        block = new TetrisBlock(shape, color);
    }

    /**
     * Return a Tetris block with shape and color.
     *
     * @return a tetris block
     */
    public TetrisBlock getBlock(){
        return block;
    }

    /**
     * Adds the color of the current Tetris block to the game board.
     * This method loops through each cell of the block shape,
     * check its position on the board, and sets the board cell to the block color.
     */
    public void addColorToBoard(){
        int y = block.getY(); // Get the Y-coordinate of the block's position on the board
        int x = block.getX(); // Get the X-coordinate of the block's position on the board
        int[][] shape = block.getShape(); // Get the shape of the block

        // Loop through each cell of the block shape
        for(int row = 0; row < shape.length; row++){
            for (int col = 0; col < shape[0].length; col++){
                /*If the cell of the block at row and col contain 1,
                 set the board at Y-coordinate and X-coordinate to the color of the block*/
                if(shape[row][col] == 1){
                    board[y + row][x + col] = block.getColor();
                }
                /*TODO: To make the block stay on each other, everytime when the color add to the board check
                if that board coordinate contain a color. If it does put the block one column above the previous one.*/
            }
        }
    }

    /**
     * Return a game board.
     *
     * @return a game board
     */
    public Color[][] getBoard(){
        return board;
    }

    public void stopTimer(){
        this.speed.stop();
    }

    /**
     * The if statemnts after "if(action.equals(specific action)" basically checks if the tetris block already
     * is at the edge of the play field. This is essential so, when the block is at the edge or at the bottom,
     * the user cannot longer move the block. In informal words, the first if statement can be translated to
     * "if the block already is at the edge of the game area or if the block has touched the bottom". If this
     * statement is not correct, then the block is moved to the relevant location.
     * @param action represents what key has been pressed.
     */
    public void decideMove(String action){
        if(action.equals("left")) {

            if ((block.checkLeft() == 0) || ((block.getShape().length + block.getY()) * kvadrat == 600)) {
                return;
            } else {
                block.goLeft();
                playfield.repaint();
            }
        }

        if(action.equals("right")){
            if(((block.checkRight() + block.getShape()[0].length == column))  || ((block.getShape().length + block.getY()) * kvadrat == 600)){
                return;
            } else {
                block.goRight();
                playfield.repaint();
            }
        }

        if(action.equals("down")){

            if((block.getShape().length + block.getY()) * kvadrat == 600){
                return;
            } else {
                block.goDown();
                playfield.repaint();
            }
        }

        if(action.equals("space")){
            while((block.getShape().length + block.getY()) * kvadrat < 600){
                block.goDown();
            }
            playfield.repaint();
        }

        /*
        TODO: If the action equals "up", then the block should rotate. This needs to be fixed,
        as this feature is not implemented yet.
         */
        if(action.equals("up")){
            block.rotateBlock();
            playfield.repaint();
        }

    }

}
