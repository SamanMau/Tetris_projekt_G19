package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopPanel extends JPanel {
    private JButton startGame = new JButton("Starta spel");
    private JButton showHighscore = new JButton("Visa highscore");
    private JButton endGame = new JButton("Avsluta spel");
    private Spelplan spelplan;

    private boolean gameStarted;

    private MainFrame mainFrame;

    public TopPanel(Spelplan spelplan, MainFrame mainFrame){
        this.setPreferredSize(new Dimension(600, 100));
        this.setBackground(Color.gray);

        this.mainFrame = mainFrame;
        this.spelplan = spelplan;

        CreateBtn();
        this.setLayout(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        MainFrame mf = new MainFrame();
    }

    private void CreateBtn(){
        startGame.setBounds(247, 28, 95, 35);
        Color green = new Color(0, 128, 60, 157);
        startGame.setBackground(green);
        startGame.setFocusPainted(false);
        startGame.setFocusable(false);

        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spelplan.startTimer(true);
                mainFrame.linkButtonToEvent(true);
                gameStarted = true;
            }
        });

        this.add(startGame);

        showHighscore.setBounds(147, 64, 120, 35);
        Color orange = new Color(167, 112, 50);
        showHighscore.setBackground(orange);
        showHighscore.setFocusPainted(false);
        this.add(showHighscore);

        endGame.setBounds(335, 64, 115, 35);
        Color red = new Color(192, 30, 30);
        endGame.setBackground(red);
        //  avslutaSpel.setFocusPainted(false);

        endGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(gameStarted){
                    spelplan.stopTimer();
                    gameStarted = false;
                } else {
                    return;
                }
            }
        });
        this.add(endGame);


    }

}
