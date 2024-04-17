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

public class Controller {
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

    public Controller() {
        this.playfield = new Playfield(this);
        mainFrame = new MainFrame(this, playfield);
        listOfBlocksObj = new ListOfBlocks();
        this.listOfShape = listOfBlocksObj.getBlockList();
        this.listOfColors = listOfBlocksObj.getListOfColors();
        generateBlock();
        collision = false;
    }

    public void startTimer(boolean gameState) {
        this.gameState = gameState;

        if(gameState){
            this.speed = new Timer(400, new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (collision) {
                        addColorToBoard();
                        generateBlock();
                        collision = false;
                    } else {
                            if (isAtBottom() || isCollidingWithBlock()) {
                                addColorToBoard();
                               // generateBlock();
                            } else {
                                block.incrementY();
                            }
                    }
                    playfield.repaint();
                }
            });
            this.speed.start();
        }
    }

    //Den här metoden kontrollerar ifall det aktuella blocket har nått botten av spelplanen
    private boolean isAtBottom() {
       // block getY(),  hämtar den aktuella y-posisionen för det aktuella blocket på spelplanen
      //  block.getShape().length, Hämtar höjden på det aktuella blocket på spelplanen
        //Först beräknas den potentiella positionen för botten av blocket
        //Sedan jämförs den beräknade position med längden av spelplanen
        //Om position är större eller lika med längeden på spelplan, innebär att blocket har nått botten eller passerat botten av spelplan
        return (block.getY() + block.getShape().length) * kvadrat >= board.length * kvadrat;
    }

    private boolean isCollidingWithBlock() {
        int y = block.getY(); // Get the Y-coordinate of the block's position on the board
        int x = block.getX(); // Get the X-coordinate of the block's position on the board
        int[][] shape = block.getShape(); // Get the shape of the block

        // Loop through each cell of the block shape
        for (int row = 0; row < shape.length; row++) {
            for (int col = 0; col < shape[0].length; col++) {
                /*If the cell of the block at row and col contain 1,
                 set the board at Y-coordinate and X-coordinate to the color of the block*/
                if (shape[row][col] == 1) {
                    int boardRow = y + row;
                    int boardCol = x + col;

                    // Denna if-sats ser till att blocken inte går utanför spelplan
                    // Om boardRow + 1 är mindre än board.length innebär att det
                    // finns minst en rad kvar under den aktuella raden på spelplanen
                    // board[boardRow + 1][boardCol] != null, kontrollera om det finns block i nästa rad under det aktuella blocket
                    // Om både villkoren uppfylls returnerar true, alltså att det finns collision annars false
                    if (boardRow + 1 < board.length && board[boardRow + 1][boardCol] != null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    /**
     * Generates a random number between 0 - 6. This random generated number
     * is then used to get a tetris block from an index. We retrieve its shape
     * and color, and then we create a new instance of "block".
     */
    public void generateBlock() {
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
    public TetrisBlock getBlock() {
        return block;
    }

    /**
     * Adds the color of the current Tetris block to the game board.
     * This method loops through each cell of the block shape,
     * check its position on the board, and sets the board cell to the block color.
     */
    public void addColorToBoard() {
        int y = block.getY(); // Get the Y-coordinate of the block's position on the board
        int x = block.getX(); // Get the X-coordinate of the block's position on the board
        int[][] shape = block.getShape(); // Get the shape of the block

        // Loop through each cell of the block shape
        for (int row = 0; row < shape.length; row++) {
            for (int col = 0; col < shape[0].length; col++) {
                /*If the cell of the block at row and col contain 1,
                 set the board at Y-coordinate and X-coordinate to the color of the block*/
                if (shape[row][col] == 1) {
                    int boardRow = y + row;
                    int boardCol = x + col;
                    //Den kontrollerar att blocken inte går utanför spelplanen
                    //Om platsen vi ska gå till innehåller redan block (dvs den är inte null) så fortsätter loopen uppåt
                        board[boardRow][boardCol] = block.getColor();

                }
            }
        }
        collision = true;
    }


     /*TODO: To make the block stay on each other, everytime when the color add to the board check
                if that board coordinate contain a color. If it does put the block one column above the previous one.*/

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
    public void decideMove(String action) {

        if (action.equals("left")) {
            if ((block.getX() == 0) || isAtBottom() || isCollidingWithBlock()) {
                return;
            }
            block.goLeft();
        } else if (action.equals("right")) {
            if ((block.getX() + block.getShape()[0].length >= column) || isAtBottom() || isCollidingWithBlock()) {
                return;
            }
            block.goRight();
        } else if (action.equals("down") || action.equals("space")) {

            do {
                block.goDown();
            } while (action.equals("space") && !isAtBottom() && !isCollidingWithBlock());

            if (isAtBottom() || isCollidingWithBlock()) {
                block.incrementY(-1);
                addColorToBoard();
                generateBlock();
                restartGameLogic();
            }

        } else if (action.equals("up")) {
            block.rotateBlock();

        }
        playfield.repaint();
    }
    private void restartGameLogic(){
        collision = false;
        if (!gameState) {
            startTimer(true);
        }
    }

           /* if ((block.checkLeft() == 0) || ((block.getShape().length + block.getY()) * kvadrat == 600)) {
                return;
            } else {
                block.goLeft();
                playfield.repaint();
            }
        }

        if (action.equals("right")) {
            if (((block.checkRight() + block.getShape()[0].length == column)) || ((block.getShape().length + block.getY()) * kvadrat == 600)) {
                return;
            } else {
                block.goRight();
                playfield.repaint();
            }
        }

        if (action.equals("down")) {

            if ((block.getShape().length + block.getY()) * kvadrat == 600) {
                return;
            } else {
                block.goDown();
                playfield.repaint();
            }
        }

        if (action.equals("space")) {
            while ((block.getShape().length + block.getY()) * kvadrat < 600) {
                block.goDown();
            }
            playfield.repaint();
        }

        /*
        TODO: If the action equals "up", then the block should rotate. This needs to be fixed,
        as this feature is not implemented yet.

        if (action.equals("up")) {
            block.rotateBlock();
            playfield.repaint();
        }*/



}


/* To check if row is filled. Check the board color and see if its = to "default" (color that you start with). If true
*  remove rows with color + add points + set the boards removed to regular color.
*
 */