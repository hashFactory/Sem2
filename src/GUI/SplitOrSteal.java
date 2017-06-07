package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by charpentiert on 5/24/17.
 */
public class SplitOrSteal extends JFrame implements ActionListener
{
    static Boolean[] split = new Boolean[2];

    JButton one = null;
    JButton two = null;
    JButton _one = null;
    JButton _two = null;

    JLabel result = null;

    public static void main(String [] args)
    {
        SplitOrSteal ob = new SplitOrSteal();
        ob.setVisible(true);
    }

    public SplitOrSteal()
    {
        super("Pictures in tabbed pane");
        setSize(700, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JTabbedPane tabs = new JTabbedPane();

        // Tab 1
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        one = new JButton("Split");
        two = new JButton("Steal");
        _one = new JButton("Split");
        _two = new JButton("Steal");

        one.addActionListener(this);
        two.addActionListener(this);
        _one.addActionListener(this);
        _two.addActionListener(this);

        panel1.add(one);
        panel1.add(two);
        panel2.add(_one);
        panel2.add(_two);

        //panel1.add(hello);
        tabs.add("Player 1", panel1);
        tabs.add("Player 2", panel2);
        add(tabs);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String button = e.getActionCommand();

        if (split[0] == new Boolean(true) || split[1] == new Boolean(false))
        {
            if (button.equalsIgnoreCase("Split"))
            {
                split[1] = true;
            }
            else
            {
                split[1] = false;
            }
        }
        else
        {
            one.setEnabled(false);
            two.setEnabled(false);
            if (button.equalsIgnoreCase("Split"))
            {
                split[1] = true;
            }
            else
            {
                split[1] = false;
            }
        }
    }
}
