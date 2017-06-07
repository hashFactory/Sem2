package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MontyPython extends JFrame implements ActionListener
{
    static boolean[] outcome = new boolean[3];

    JButton one = null;
    JButton two = null;
    JButton three = null;
    JButton new_game = null;

    public static void main(String [] args)
    {
        MontyPython ob = new MontyPython();
        ob.setVisible(true);
    }

    public MontyPython()
    {
        super("Pictures in tabbed pane");
        setSize(700, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        ImageIcon icon;
        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("door.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        icon = new ImageIcon(image);

        JTabbedPane tabs = new JTabbedPane();

        // Tab 1
        JPanel panel1 = new JPanel();

        one = new JButton("Door one", icon);
        two = new JButton("Door two", icon);
        three = new JButton("Door three", icon);
        new_game = new JButton("New Game");

        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        new_game.addActionListener(this);

        panel1.add(one);
        panel1.add(two);
        panel1.add(three);
        panel1.add(new_game);

        // Tab 2
        JPanel panel2 = new JPanel();

        JTextArea list = new JTextArea("Testing");

        panel2.add(list);

        //panel1.add(hello);
        tabs.add(panel1, icon);
        tabs.add("Results", panel2);
        add(tabs);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String button = e.getActionCommand();
        if (button.equalsIgnoreCase("New Game"))
        {

        }
    }
}
