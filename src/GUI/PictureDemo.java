package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PictureDemo extends JFrame
{
    public static void main(String [] args)
    {
        PictureDemo ob = new PictureDemo();
        ob.setVisible(true);
    }

    public PictureDemo()
    {
        super("My photoshop");
        setSize(1000, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        File input = new File("thing.jpg");
        System.out.println();
        ImageIcon icon;
        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("thing.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int x = 0; x < image.getWidth(); x++)
        {
            for (int y = 0; y < image.getHeight(); y++)
            {
                Color is = new Color(image.getRGB(x, y));
                int red = (int)(is.getRed()*(1-0.587-0.114));
                int green = (int)(is.getGreen()*0.587);
                int blue = (int)(is.getBlue()*0.114);
                Color newColor = new Color(red+green+blue, red+green+blue, red+green+blue);
                image.setRGB(x, y, newColor.getRGB());
            }
        }
        icon = new ImageIcon(image);
        JLabel picture = new JLabel("Here is a picture of Darth Vader", icon, JLabel.CENTER);
        add(picture);
    }
}
