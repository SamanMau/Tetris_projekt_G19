package View.Settings;

import Control.Controller;
import View.MainFrame;
import com.sun.tools.javac.Main;

import javax.swing.*;

public class SettingsFrame extends JFrame {
    private Controller controller;
    private MainFrame mainFrame;

    public SettingsFrame(Controller controller, MainFrame mainFrame){
        super("Settings");
        this.controller = controller;
        this.mainFrame = mainFrame;
        this.setSize(500, 500);

        createTabs();

        this.setVisible(true);
    }

    public void createTabs(){
        JTabbedPane tab = new JTabbedPane();

        AudioPanel audioPanel = new AudioPanel(controller, mainFrame, this);

        KeyboardPanel keyboardPanel = new KeyboardPanel(controller, mainFrame, this);

        tab.addTab("Audio", audioPanel);
        tab.addTab("Keyboard", keyboardPanel);


        this.add(tab);
    }
}
