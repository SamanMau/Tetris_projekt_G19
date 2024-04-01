package view;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.Timer;


public class Spelplan extends JPanel{
    private final int column = 10;
    private final int row = 20;
    private final int kvadrat = 600 / row;
    private ListOfBlocks listOfBlocksObj; //For testing , should be in controller
    private ArrayList<int[][]> listOfShape; //For testing , should be in controller
    private ArrayList<Color> listOfColors;
    private Timer speed;
    private TetrisBlock block;
    private Random rd = new Random();
    private int randomNum = rd.nextInt(7); // 7
    private boolean collision;

    private Color[][] board = new Color[20][10];
    private boolean gameState = false;

    public Spelplan(){
        this.setPreferredSize(new Dimension(300, 600));
        this.setBackground(Color.BLACK);
        listOfBlocksObj = new ListOfBlocks(); //For testing , should be in controller
        this.listOfShape = listOfBlocksObj.getBlockList(); //For testing , should be in controller
        this.listOfColors = listOfBlocksObj.getListOfColors();
        this.setLayout(null);
        this.setVisible(true);
        collision = false;
        generateBlock();
        startTimer(true);
    }

    public void startTimer(boolean gameState){
        this.gameState = gameState;
        if(gameState){
            this.speed = new Timer(200, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(collision){
                       // generateNewBlock();
                        addColorToBoard();
                        generateBlock();
                        collision = false;
                    }
                    if((block.getShape().length + block.getY()) * kvadrat == 600){
                        collision = true;
                      //  generateNewBlock();
                    }
                    else{
                        block.incrementY();
                        collision = false;
                    }
                    repaint();
                }
            });
            this.speed.start();
        }

    }

    private void addColorToBoard(){
        int y = block.getY();
        int x = block.getX();
        int[][] shape = block.getShape();

        for(int row = 0; row < shape.length; row++){
            for (int col = 0; col < shape[0].length; col++){
                if(block.getShape()[row][col] == 1){
                    board[y + row][x + col] = block.getColor();
                }
            }
        }
    }

    private void generateBlock(){
        randomNum = rd.nextInt(7);
        int[][] shape = listOfShape.get(randomNum);
        Color color = listOfColors.get(randomNum);
        block = new TetrisBlock(shape, color);
    }

    @Override
    protected void paintComponent(Graphics g){ //I den här metoden skapar vi rutnät
        super.paintComponent(g);
        /*
        De två sista argumenten i "drawRect" är "width" och "height". Anledningen till varför
        vi skickar in kvadrat som argument är eftersom vi har initierat längden på kvadraten
        lite längre upp. Eftersom en kvadrat är lika långt på både höjden och bredden, så
        skickar vi in storleken på kvadrat på width och height.
         */
        for(int width = 0; width < column; width++){
            for(int height = 0; height < row; height++){
                if (board[height][width] != null) {
                    g.setColor(board[height][width]);
                    g.fillRect(width * kvadrat, height * kvadrat, kvadrat, kvadrat);
                    g.setColor(Color.BLACK);
                    g.drawRect(width * kvadrat, height * kvadrat, kvadrat, kvadrat);
                }
                else {
                    g.setColor(Color.gray);
                    g.drawRect(width * kvadrat, height * kvadrat, kvadrat, kvadrat);
                }
            }
        }

        drawBlock(g, block);
    }

    private void drawBlock(Graphics g, TetrisBlock block) {
        for(int row = 0; row < block.getShape().length; row++){
            for (int col = 0; col < block.getShape()[0].length; col++){

                if(block.getShape()[row][col] == 1){
                    int x = col * kvadrat + block.getX() * kvadrat;
                    int y = row * kvadrat + block.getY() * kvadrat;

                    //Rita blocken
                    g.setColor(block.getColor());
                    g.fillRect(x, y, kvadrat, kvadrat);

                    //Rita rutnät för blocken
                    g.setColor(Color.BLACK);
                    g.drawRect(x, y, kvadrat, kvadrat);
                }
            }
        }
    }


}
