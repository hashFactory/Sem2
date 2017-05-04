package Fraction;

import java.util.Scanner;

/**
 * Created by charpentiert on 4/20/17.
 */
public class FractionDriver
{
    public static void main(String [] args)
    {
        Fraction first = new Fraction(1,1);
        Fraction second = new Fraction(1,1);
        System.out.println("Will you enter 1 or 2 fractions?");
        int input = new Scanner(System.in).nextInt();
        if (input == 1)
        {
            first = first.userInput();
            run(first);
        }
        else if (input == 2)
        {
            first = first.userInput();
            second = second.userInput();
            run(first, second);
        }
    }

    private static void o(String string)
    {
        System.out.print(string);
    }

    private static void run(Fraction first)
    {
        o("User input " + print_fraction(first) + " reduces to " + print_fraction(first.reduce()));
    }

    private static void run(Fraction first, Fraction second)
    {
        o(print_fraction(first) + " + " + print_fraction(second) + " = " + print_fraction(first.addFractions(first, second)) + "\n");
        o(print_fraction(first) + " - " + print_fraction(second) + " = " + print_fraction(first.subFractions(first, second)) + "\n");
        o(print_fraction(first) + " * " + print_fraction(second) + " = " + print_fraction(first.multFractions(first, second)) + "\n");
        o(print_fraction(first) + " / " + print_fraction(second) + " = " + print_fraction(first.divFractions(first, second)) + "\n");
    }

    public static String print_fraction(Fraction first)
    {
        return "" + first.num + "/" + first.den + "";
    }
}
