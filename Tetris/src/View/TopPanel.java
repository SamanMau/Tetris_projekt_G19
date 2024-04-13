/**
 * A panel in the GUI which represents the top panel. It has 3 buttons.
 */
package View;

import Control.Controller;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class TopPanel extends JPanel {
    private JButton startGame = new JButton("Start game");
    private JButton showHighscore = new JButton("Show highscore");
    private JButton endGame = new JButton("End spel");

    private JButton playMusic = new JButton("Music");


    private String music, musicOff;
    private Playfield playfield;
    private soundEffect se= new soundEffect();
    private boolean gameStarted;

    private MainFrame mainFrame;

    private Controller controller;

    /**
     * Constructor that sets a dimension for the panel and a color.
     * @param playfield used to call the timer method
     * @param mainFrame used to call a method that linkes keys (right, left, up, down, space) to a specific action.
     */
    public TopPanel(Playfield playfield, MainFrame mainFrame, Controller controller){
        this.setPreferredSize(new Dimension(600, 100));
        this.setBackground(Color.gray);

        this.controller = controller;
        this.mainFrame = mainFrame;
        this.playfield = playfield;
        CreateBtn();
        this.setLayout(null);
        this.setVisible(true);


    }

    /**
     * Initializes buttons and gives them coordinates and colors. Each button is then given an
     * actionlistener, for instance, for the "startgame" button, we call the startTimer method which
     * basically makes the blocks fall down. And then we also call "linkButtonToEvent" to link keys to events.
     * For the "startgame" button we use "setFocusable(false)" because without this method, it is not possible to
     * use the keys after pressing a button. Try removing the method. And then, run the program, press "startGame"
     * button, and then you will se what I mean :)
     */
    private void CreateBtn(){
        startGame.setBounds(247, 28, 100, 35);
        Color green = new Color(0, 128, 60, 157);
        startGame.setBackground(green);
        startGame.setFocusPainted(false);
        startGame.setFocusable(false);

        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.linkKeyToEvent(true);
                controller.startTimer(true);
                gameStarted = true;
            }
        });

        this.add(startGame);

        showHighscore.setBounds(147, 64, 129, 35);
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
                    controller.stopTimer();
                    gameStarted = false;
                } else {
                    return;
                }
            }
        });
        this.add(endGame);

        playMusic.setBounds(400,28,100,40);
        playMusic.setFocusPainted(false);
        playMusic.setActionCommand("gameMusic");
        music = "src/Ljud/dark.wav";
        musicOff ="off";

        playMusic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String btnPressed = actionEvent.getActionCommand();
                        if (musicOff.equals("off")) {
                            se.setFile(music);
                            se.playTheSong();
                            musicOff = "on";
                            playMusic.setText("music on");
                        }
                        else if (musicOff.equals("on")) {
                            se.stop();
                            musicOff = ("off");
                            playMusic.setText("music off");
                        }
                }
        });
        this.add(playMusic);
    }
    public class soundEffect{
        Clip clip;
    public void setFile(String SoundFileName) {
        try {
            File file = new File(SoundFileName);
            AudioInputStream sound = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(sound);
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void playTheSong(){
        clip.start();
    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
        clip.close();
    }
    }
}
