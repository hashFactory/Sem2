import javafx.util.converter.BigIntegerStringConverter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by charpentiert on 3/31/17.
 */

public class Palindrome
{
    static BigIntegerStringConverter bs = new BigIntegerStringConverter();

    private static void lychrel()
    {
        ArrayList<Integer> lychel = new ArrayList<>();

        for (int j = 1; j <= 10000; j++)
        {
            int i = 0;

            BigInteger k = bs.fromString(Integer.toString(j));
            do
            {
                i++;
                if (i > 50)
                    break;
                System.out.print(k.toString() + " + " + reverse(k).toString() + " = ");
                k = k.add(reverse(k));
                System.out.println(k);
            }
            while (!is_palindrome(k));

            if (i == 51)
            {
                lychel.add(j);
            }
        }

        System.out.println(lychel.size());
        //System.out.println(k.toString() + " is a palindrome after " + i + " iterations");
        System.out.print("Lychel numbers under 10000: ");
        for (int thing: lychel)
            System.out.print(thing + ", ");
    }

    private static void input()
    {
        Scanner kb = new Scanner(System.in);
        BigInteger k = bs.fromString(kb.nextLine());

        int i = 0;

        do
        {
            i++;
            System.out.print(k.toString() + " + " + reverse(k).toString() + " = ");
            k = k.add(reverse(k));
            System.out.println(k);
        }
        while (!is_palindrome(k));

        System.out.println(k.toString() + " is a palindrome after " + i + " iterations");
    }

    private static void find_big_one()
    {
        BigInteger i = BigInteger.ONE;
        int iteration_record = 1;

        while (true)
        {
            int iteration = 0;
            i = i.add(BigInteger.ONE);
            BigInteger thing = i;

            do
            {
                iteration++;
                //System.out.print(i.toString() + " + " + reverse(i).toString() + " = ");
                thing = thing.add(reverse(thing));
                //System.out.println(i);
            }
            while (!is_palindrome(thing));

            if (iteration > iteration_record)
            {
                iteration_record = iteration;
                System.out.println("With an iteration count of : " + iteration_record + ", with the number " + i.toString());
            }
        }
    }


    public static void main(String [] args)
    {
        input();
        //find_big_one();
    }

    private static BigInteger reverse(BigInteger n)
    {
        String n_str = n.toString();
        String reverse = "";
        for (int i = n_str.length() - 1; i > -1; i--)
        {
            reverse += n_str.charAt(i);
        }

        n = bs.fromString(reverse);

        return n;

    }

    private static boolean is_palindrome(BigInteger n)
    {
        String n_str = n.toString();
        String reverse = reverse(n).toString();

        if (n_str.equalsIgnoreCase(reverse))
            return true;
        return false;
    }
}
