package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by charpentiert on 5/22/17.
 */
public class WordCounter extends JFrame implements ActionListener
{
    String input;
    String substring;

    JButton results = null;
    JTextField input_string = new JTextField(15);
    JTextField input_substring = new JTextField(2);

    JLabel pair = new JLabel("Pairs: ");

    JLabel pair_results = new JLabel();

    JLabel letters = new JLabel("Letters: ");
    JLabel letters_results = new JLabel();

    public static void main(String [] args)
    {
        WordCounter ob = new WordCounter();
        ob.setVisible(true);
    }

    public WordCounter()
    {
        super("Word Counter");
        setSize(700, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Tab 1
        JPanel panel1 = new JPanel();

        results = new JButton("Results");

        results.addActionListener(this);

        add(input_string);
        add(results);

        add(input_substring);
        add(pair);
        add(pair_results);

        add(letters);
        add(letters_results);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String button = e.getActionCommand();
        if (button.equalsIgnoreCase("Results"))
        {
            input = input_string.getText();
            substring = input_substring.getText();

            int t = 0;
            for (int i = 0; i < input.length() - 1; i++)
                if (input.substring(i, i+substring.length()).equalsIgnoreCase(substring))
                    t++;

            pair_results.setText("" + t);

            int[] alpha = new int[256];

            for (int i = 0; i < input.length(); i++)
                alpha[(int)input.charAt(i)]++;

            for (int i = 0; i < alpha.length; i++)
                if (alpha[i] != 0)
                    letters_results.setText(letters_results.getText() + " " + (char)i + "-" + alpha[i]);
        }
    }
}
