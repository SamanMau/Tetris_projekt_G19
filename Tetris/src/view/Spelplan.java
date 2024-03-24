package Tetris.src.view;

import javax.swing.*;
import java.awt.*;

public class Spelplan extends JPanel {
    private final int column = 10;
    private final int kvadrat = (600 / column) / 2;
    private final int row = 600 / kvadrat;
    //private final int kvadrat = 30;

    public Spelplan(){
        //this.setBounds(144, 63, 300, 600); //y = 35
        // x = 144, y = 63, width = 300, height = 600
        this.setPreferredSize(new Dimension(300, 600));
        this.setBackground(Color.BLACK);
        this.setLayout(null);
        this.setVisible(true);
        //System.out.println(this.get);
    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
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
    }

}
