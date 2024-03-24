package view;

import javax.swing.*;
import java.awt.*;

public class TopPanel extends JPanel {
    private JButton startaSpel = new JButton("Starta spel");
    private JButton visaHighScore = new JButton("Visa highscore");

    public TopPanel(){
        this.setPreferredSize(new Dimension(600, 100));
        this.setBackground(Color.gray);
        CreateBtn();
        this.setLayout(null);
        this.setVisible(true);
    }

    private void CreateBtn(){
        startaSpel.setBounds(134, 25, 95, 35);
        Color green = new Color(0, 128, 60, 157);
        startaSpel.setBackground(green);
        startaSpel.setFocusPainted(false);
        this.add(startaSpel);

        visaHighScore.setBounds(268, 25, 95, 35);
        Color red = new Color(128, 26, 0);
        visaHighScore.setBackground(red);
        visaHighScore.setFocusPainted(false);
        this.add(visaHighScore);


    }

}
