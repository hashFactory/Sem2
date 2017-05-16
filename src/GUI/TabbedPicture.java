package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by charpentiert on 5/12/17.
 */
public class TabbedPicture extends JFrame
{
    public static void main(String [] args)
    {
        TabbedPicture ob = new TabbedPicture();
        ob.setVisible(true);
    }

    public TabbedPicture()
    {
        super("Pictures in tabbed pane");
        setSize(700, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        JTabbedPane tabs = new JTabbedPane();
        JPanel panel1 = new JPanel();
        ImageIcon icon;
        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("thing.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        icon = new ImageIcon(image);
        JLabel hello = new JLabel("Hello", icon, JLabel.CENTER);
        panel1.add(hello);
        tabs.add(panel1, icon);
        add(tabs);
    }
}
