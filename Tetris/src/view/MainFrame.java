package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame{
    private static int width = 615; //600
    private static int height = 840; // 800

    private InputMap key;

    private ActionMap action;

    private Spelplan spelplan;

    public MainFrame(){
        super("Tetris");
        this.setSize(width, height);
        this.spelplan = new Spelplan();
        TopPanel tp = new TopPanel(spelplan, this);
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

        createKeys();

    }

    public void createKeys(){
        key = this.getRootPane().getInputMap();
        action = this.getRootPane().getActionMap();

        key.put(KeyStroke.getKeyStroke("LEFT"), "leftKey"); //fungerar lite som en hashmap. "actionMapKey" är vår identifierare
        key.put(KeyStroke.getKeyStroke("SPACE"), "spaceKey");
        key.put(KeyStroke.getKeyStroke("DOWN"), "downKey");
        key.put(KeyStroke.getKeyStroke("RIGHT"), "rightKey");
        key.put(KeyStroke.getKeyStroke("UP"), "upKey");
    }

    public void linkButtonToEvent(boolean started){
        if(started){
            action.put("leftKey", new AbstractAction() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    spelplan.decideMove("left");
                }
            });

            action.put("spaceKey", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    spelplan.decideMove("space");
                }
            });

            action.put("downKey", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    spelplan.decideMove("down");
                }
            });

            action.put("rightKey", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    spelplan.decideMove("right");
                }
            });

            action.put("upKey", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    spelplan.decideMove("up");
                }
            });
        }
    }



    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
    }

}
