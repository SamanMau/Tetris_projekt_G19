package view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
    private static int width = 615; //600
    private static int height = 840; // 800

    public MainFrame(){
        super("Tetris");
        this.setSize(width, height);
        Spelplan spelplan = new Spelplan();
        TopPanel tp = new TopPanel();
        LPanel lp = new LPanel();
        RPanel rp = new RPanel();
        BottomPanel bp = new BottomPanel();

        //Add panel
        this.add(lp, BorderLayout.WEST);
        this.add(rp, BorderLayout.EAST);
        this.add(tp, BorderLayout.NORTH);
        this.add(bp, BorderLayout.SOUTH);
        this.add(spelplan, BorderLayout.CENTER);

        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
    }

}
