package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by charpentiert on 5/31/17.
 */
public class GreenScreen extends JFrame implements ActionListener
{
    JLabel plabel;
    BufferedImage source;
    BufferedImage wall;
    BufferedImage composed;

    public static void main(String [] args)
    {
        GreenScreen ob = new GreenScreen();
        ob.setVisible(true);
    }

    public GreenScreen()
    {
        super("Skittles");
        setSize(1000, 500);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon;
        try {
            source = ImageIO.read(getClass().getClassLoader().getResourceAsStream("ball_pit.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        icon = new ImageIcon(source);

        plabel = new JLabel("", icon, JLabel.CENTER);
        add(plabel);

        JButton org = new JButton("compose");
        org.addActionListener(this);
        add(org);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String rst = e.getActionCommand();
        if (rst.equals("compose"))
        {
            ImageIcon icon;
            BufferedImage image = null;
            try {
                image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("ball_pit.jpg"));
            } catch (IOException b) {
                b.printStackTrace();
            }

            BufferedImage fish = null;
            try {
                fish = ImageIO.read(getClass().getClassLoader().getResourceAsStream("fish.jpg"));
            } catch (IOException b) {
                b.printStackTrace();
            }

            for (int x = 0; x < image.getWidth(); x++)
            {
                for (int y = 0; y < image.getHeight(); y++)
                {
                    Color first = new Color(fish.getRGB(x, y));
                    Color second = new Color(image.getRGB(x, y));
                    if ((first.getRed() <= 19 + 20 && first.getRed() >= 19 - 20) && (first.getGreen() <= 255 && first.getGreen() >= 255 - 20) && (first.getBlue() <= 8 + 20 && first.getBlue() >= 8 - 20))
                        image.setRGB(x, y, second.getRGB());
                    else
                        image.setRGB(x, y, first.getRGB());
                }
            }

            icon = new ImageIcon(image);

            plabel.setIcon(icon);
        }

    }
}
