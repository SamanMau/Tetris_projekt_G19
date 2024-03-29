package view;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;


public class Spelplan extends JPanel{
    private final int column = 10;
    private final int row = 20; // 600 / kvadrat
    private final int kvadrat = 600 / row; //30
    ListOfBlocks listOfBlocksObj; //For testing , should be in controller
    private ArrayList<TetrisBlock> listOfBlocks; //For testing , should be in controller
    private int blockNum = 6;

    public Spelplan(){
        this.setPreferredSize(new Dimension(300, 600));
        this.setBackground(Color.BLACK);
        listOfBlocksObj = new ListOfBlocks(); //For testing , should be in controller
        this.listOfBlocks = listOfBlocksObj.getBlockList(); //For testing , should be in controller
        this.setLayout(null);
        this.setVisible(true);

    }

    private void drawBlock(Graphics g) {
        for(int row = 0; row < listOfBlocks.get(blockNum).getShape().length; row++){
            for (int col = 0; col < listOfBlocks.get(blockNum).getShape()[0].length; col++){
                if(listOfBlocks.get(blockNum).getShape()[row][col] == 1){
                    g.setColor(listOfBlocks.get(blockNum).getColor());
                    g.fillRect(col * kvadrat, row * kvadrat, kvadrat, kvadrat);
                }
            }
        }
    }

    public void moveBlock(){

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
        /*for(int width = 0; width < column; width++){
            for(int height = 0; height < row; height++){
                g.drawRect(width * kvadrat, height * kvadrat, kvadrat, kvadrat);
            }
        }*/

        for(int width = 0; width < column; width++){
            for(int height = 0; height < row; height++){
                g.drawRect(width * kvadrat, height * kvadrat, kvadrat, kvadrat);
            }
        }
        // Coordinate
        /* 00,0 | 00,30 | 00,60 | 00,90 | 00,120 | 00,150 | 00,180 | 00,210 | 00,240 | 00,270 | 00,300
           10,0 | 10,30 | 10,60 | 10,90 | 10,120 | 10,150 | 10,180 | 10,210 | 10,240 | 10,270 | 10,300
           20,0 | 20,30 | 20,60 | 20,90 | 20,120 | 20,150 | 20,180 | 20,210 | 20,240 | 20,270 | 20,300
           ...
        */
        drawBlock(g);
    }
}
