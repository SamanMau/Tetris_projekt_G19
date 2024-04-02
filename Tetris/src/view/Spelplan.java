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
    private ArrayList<TetrisBlock> listOfBlocks; //For testing , should be in controller
    private Timer speed;
    private TetrisBlock block;
    private Random rd = new Random();
    private int randomNum = rd.nextInt(7); // 7
    private boolean collision;
    private boolean gameState = false;


    public Spelplan(){
        this.setPreferredSize(new Dimension(300, 600));
        this.setBackground(Color.BLACK);

         /*
        I vår inputMap så lägger vi till key strokes. En key stroke är en händelse
        som exekveras beroende på vilken tangent bord knapp har tryckts. Detta koncept
        ska användas för att kunna hantera blocken (höger, vänster, ner, rotera) med hjälp av pilar
         */

        listOfBlocksObj = new ListOfBlocks(); //For testing , should be in controller
        this.listOfBlocks = listOfBlocksObj.getBlockList(); //For testing , should be in controller

        this.setLayout(null);
        this.setVisible(true);

        block = listOfBlocks.get(randomNum);

        collision = false;
        //startTimer(true);
    }

    public void stopTimer(){
        this.speed.stop();
    }

    public void decideMove(String action){
        if(action.equals("left")) {

            if ((block.checkLeft() == 0) || ((block.getShape().length + block.getY()) * kvadrat == 600)) {
                return;
            } else {
                block.goLeft();
                repaint();
            }
        }

        if(action.equals("right")){
            if(((block.checkRight() + block.getShape()[0].length == column))  || ((block.getShape().length + block.getY()) * kvadrat == 600)){
                return;
            } else {
                block.goRight();
                repaint();
            }

        }

        if(action.equals("down")){

            if((block.getShape().length + block.getY()) * kvadrat == 600){
                return;
            } else {
                block.goDown();
                repaint();
            }
        }

        if(action.equals("space")){
            while((block.getShape().length + block.getY()) * kvadrat < 600){
                block.goDown();
            }
            repaint();
        }

        if(action.equals("up")){
            block.rotateBlock();
            repaint();
        }

    }

    public void startTimer(boolean gameState){
        this.gameState = gameState;
        if(gameState){
            this.speed = new Timer(200, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(collision){
                       // generateNewBlock();
                        return;
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

    private void generateNewBlock(){
        listOfBlocks.get(randomNum).resetCoordinate();
        randomNum = rd.nextInt(listOfBlocksObj.getBlockList().size());
        this.block = listOfBlocks.get(randomNum);
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
                g.drawRect(width * kvadrat, height * kvadrat, kvadrat, kvadrat);
            }
        }

        drawBlock(g, block);

    }
}
