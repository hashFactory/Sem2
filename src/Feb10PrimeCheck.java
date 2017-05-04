import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Feb10PrimeCheck extends JFrame implements ActionListener
{
    JTextField input_field = new JTextField();
    JLabel is_prime = new JLabel();
    JLabel status = new JLabel();

    public static void main(String [] args)
    {
        Feb10PrimeCheck object = new Feb10PrimeCheck();
        object.setVisible(true);
    }

    public Feb10PrimeCheck()
    {
        super("Prime checker");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel northPanel = new JPanel();
        JLabel input_text = new JLabel("Please input number:");

        input_field.setColumns(10);
        input_field.addActionListener(this);
        northPanel.add(input_text);
        northPanel.add(input_field);

        JPanel centerPanel = new JPanel();
        JButton button = new JButton("Check now");

        button.addActionListener(this);
        centerPanel.add(status);
        centerPanel.add(button);

        JPanel southPanel = new JPanel();

        southPanel.add(is_prime);

        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equalsIgnoreCase("Check now"))
        {
            //slow_is_prime(Long.valueOf(input_field.getText()));
        }
    }
}
