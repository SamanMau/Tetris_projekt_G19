package view;

import javax.swing.*;
import java.awt.*;

public class TopPanel extends JPanel {
    private JButton startaSpel = new JButton("Starta spel");
    private JButton visaHighScore = new JButton("Visa highscore");
    private JButton avslutaSpel = new JButton("Avsluta spel");

    public TopPanel(){
        this.setPreferredSize(new Dimension(600, 100));
        this.setBackground(Color.gray);
        CreateBtn();
        this.setLayout(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        MainFrame mf = new MainFrame();
    }

    private void CreateBtn(){
        startaSpel.setBounds(247, 28, 95, 35);
        Color green = new Color(0, 128, 60, 157);
        startaSpel.setBackground(green);
        startaSpel.setFocusPainted(false);
        this.add(startaSpel);

        visaHighScore.setBounds(147, 64, 120, 35);
        Color orange = new Color(167, 112, 50);
        visaHighScore.setBackground(orange);
        visaHighScore.setFocusPainted(false);
        this.add(visaHighScore);

        avslutaSpel.setBounds(335, 64, 115, 35);
        Color red = new Color(192, 30, 30);
        avslutaSpel.setBackground(red);
        avslutaSpel.setFocusPainted(false);
        this.add(avslutaSpel);


    }

}
