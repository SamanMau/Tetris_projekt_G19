package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BottomPanel extends JPanel {
    private BufferedImage testImage;

    public BottomPanel(){
        this.setPreferredSize(new Dimension(600, 100));
        this.setBackground(Color.gray);
       // createImage();

        this.setVisible(true);

    }

    /*
    public void createImage(){

        try{
            testImage = ImageIO.read(new File("bilder/image.png"));
            JLabel label = new JLabel(new ImageIcon(testImage));
            this.add(label);
        } catch (NullPointerException e){
            System.out.println("error");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

     */


    /*
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(testImage, 0, 0, this);
    }

     */
}
