import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIone extends JFrame implements ActionListener
{
    public static void main(String [] args)
    {
        GUIone object = new GUIone();
        object.setVisible(true);
    }

    public GUIone()
    {
        super("My first gui");
        setSize(800, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel northCanvas = new JPanel();
        JButton click = new JButton("Click here");
        JRadioButton radioButton = new JRadioButton("Circle here");
        JCheckBox check = new JCheckBox("check here");

        northCanvas.add(click);
        northCanvas.add(radioButton);
        northCanvas.add(check);
        add(northCanvas, BorderLayout.NORTH);

        JPanel southCanvas = new JPanel();
        JSlider slider = new JSlider(0, 100, 10);
        JLabel words = new JLabel("Here is a word");

        southCanvas.add(slider);
        southCanvas.add(words);
        add(southCanvas, BorderLayout.SOUTH);

        JPanel centerCanvas = new JPanel();
        JTextField answer = new JTextField("Place text here");
        centerCanvas.add(answer);
        add(centerCanvas, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }
}
