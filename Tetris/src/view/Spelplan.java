package view;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;


public class Spelplan extends JPanel{
    private final int column = 10;
    private final int row = 20; // 600 / kvadrat
    private final int kvadrat = 600 / row; //30
    TetrisBlock tetrisBlock;
    private ArrayList<int[][]> listOfBlocks; //For testing , should be in controller

    public Spelplan(){
        this.setPreferredSize(new Dimension(300, 600));
        this.setBackground(Color.BLACK);
        tetrisBlock = new TetrisBlock(); //For testing , should be in controller
        this.listOfBlocks = tetrisBlock.getBlockList(); //For testing , should be in controller
        this.setLayout(null);
        this.setVisible(true);
    }

    private void drawBlock(Graphics g) {
        for(int row = 0; row < listOfBlocks.get(2).length; row++){
            for (int col = 0; col < listOfBlocks.get(2)[0].length; col++){
                if(listOfBlocks.get(2)[row][col] == 1){
                    g.setColor(Color.red);
                    g.fillRect(col * kvadrat, row * kvadrat, kvadrat, kvadrat);
                }
            }
        }
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
        drawBlock(g);
    }
}
