package view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
    private static int width = 600;
    private static int height = 800;

    public MainFrame(){
        super("Tetris");
        this.setSize(width, height);
        JButton button = new JButton("left"),button1 = new JButton("right"), button2 = new JButton("top"),
                button3 = new JButton("bottom"),button4 = new JButton("");
        Spelplan spelplan = new Spelplan();

        button.setPreferredSize(new Dimension(150, 100));
        button1.setPreferredSize(new Dimension(150, 100));
        button2.setPreferredSize(new Dimension(600, 100));
        button3.setPreferredSize(new Dimension(600, 50));

        //Add panel
        this.add(button, BorderLayout.WEST);
        this.add(button1, BorderLayout.EAST);
        this.add(button2, BorderLayout.NORTH);
        this.add(button3, BorderLayout.SOUTH);
        this.add(spelplan, BorderLayout.CENTER);
        /*
        this.add(spelplan);
        TestPanel testPanel = new TestPanel();
        this.add(testPanel);
        */

        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();

    }
}
