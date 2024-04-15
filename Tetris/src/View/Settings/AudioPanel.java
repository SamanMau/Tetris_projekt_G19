package View.Settings;

import Control.Controller;
import View.MainFrame;

import javax.swing.*;
import java.awt.*;

public class AudioPanel extends JPanel {
    private Controller controller;
    private MainFrame mainFrame;

    public AudioPanel(Controller controller, MainFrame mainFrame, SettingsFrame settingsFrame){
        this.setBounds(100, 100, 100, 100);
        this.setBackground(Color.ORANGE);
        this.setLayout(null);

        this.controller = controller;
        this.mainFrame = mainFrame;

        setUpSongs();
    }

    public void setUpSongs(){
        JLabel choose = new JLabel("Choose song!");
        choose.setBounds(200, 10, 80, 40);

        JRadioButton theme1 = new JRadioButton("Theme 1");
        JRadioButton theme2 = new JRadioButton("Theme 2");
        JRadioButton theme3 = new JRadioButton("Theme 3");

        theme1.setBounds(200, 50, 80, 35);
        theme1.setBackground(Color.LIGHT_GRAY);

        theme1.setBounds(200, 50, 80, 35);
        theme1.setBackground(Color.LIGHT_GRAY);

        theme1.setBounds(200, 50, 80, 35);
        theme1.setBackground(Color.LIGHT_GRAY);

        this.add(theme1);
        this.add(choose);
    }

}
