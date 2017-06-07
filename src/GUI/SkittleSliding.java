package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by charpentiert on 5/26/17.
 */
public class SkittleSliding extends JFrame implements ActionListener, ChangeListener
{
    JLabel plabel;
    JSlider redSlider;
    BufferedImage image;

    public static void main(String [] args)
    {
        SkittleSliding ob = new SkittleSliding();
        ob.setVisible(true);
    }

    public SkittleSliding()
    {
        super("Skittles");
        setSize(1000, 500);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon;
        image = null;
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("f.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        icon = new ImageIcon(image);

        plabel = new JLabel("", icon, JLabel.CENTER);
        add(plabel);

        JButton org = new JButton("ORIGINAL");
        org.addActionListener(this);
        add(org);

        redSlider = new JSlider(JSlider.VERTICAL, 0,255,50);
            redSlider.setMajorTickSpacing(25);
            redSlider.setMinorTickSpacing(10);
            redSlider.setPaintTicks(true);
            redSlider.setPaintLabels(true);

            redSlider.addChangeListener(this);
            add(redSlider);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String rst = e.getActionCommand();
        if (rst.equals("ORIGINAL"))
        {
            ImageIcon icon;
            BufferedImage image = null;
            try {
                image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("f.jpg"));
            } catch (IOException b) {
                b.printStackTrace();
            }

            icon = new ImageIcon(image);

            plabel.setIcon(icon);
        }

    }

    @Override
    public void stateChanged(ChangeEvent e)
    {
        int redValue = redSlider.getValue();

        ImageIcon icon;
        BufferedImage buf = image;

        for (int x = 0; x < buf.getWidth(); x++)
        {
            for (int y = 0; y < buf.getHeight(); y++)
            {
                Color is = new Color(image.getRGB(x, y));
                int red = ((((is.getRed()))*(redValue))/255);
                int green = (is.getGreen());
                int blue = (is.getBlue());
                Color newColor = new Color(red, green, blue);
                buf.setRGB(x, y, newColor.getRGB());
            }
        }

        icon = new ImageIcon(buf);

        plabel.setIcon(icon);
    }
}
