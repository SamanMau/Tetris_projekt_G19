package View.Settings;

import Control.Controller;
import View.MainFrame;

import javax.swing.*;
import java.awt.*;

public class KeyboardPanel extends JPanel {
    private Controller controller;
    private MainFrame mainFrame;
    private SettingsFrame settingsFrame;

    public KeyboardPanel(Controller controller, MainFrame mainFrame, SettingsFrame settingsFrame){
        this.setBounds(100, 100, 100, 100);
        this.setBackground(Color.GREEN);
        this.setLayout(null);

        this.controller = controller;
        this.mainFrame = mainFrame;
    }
}
