package view;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class LPanel extends JPanel {
    JLabel poangText = new JLabel();
    JLabel levelText = new JLabel();
    public LPanel(){
        this.setPreferredSize(new Dimension(150, 300));
        this.setBackground(Color.gray);
        createPointCounter(0);
        createLevelCounter(1);
        this.setVisible(true);
    }

    public void createPointCounter(int point){
        poangText.setText("Poäng: " + point);
        poangText.setFont(new Font("Calibri", Font.BOLD, 20));
        this.add(poangText);
    }
    public void createLevelCounter(int level){
        levelText.setText("Level: " + level);
        levelText.setFont(new Font("Calibri", Font.BOLD, 20));
        this.add(Box.createVerticalStrut(50));
        this.add(levelText);
    }
}
