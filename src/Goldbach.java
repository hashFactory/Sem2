import java.util.Scanner;

public class Goldbach
{
    public static void main(String [] args)
    {
        long start;
        long end;
        long total = 0;

        Scanner kb = new Scanner(System.in);
        kb.nextLine();

        for (int j = 0; j < 100; j++)
        {
            start = System.currentTimeMillis();
            int i = 1;
            while_loop:
            while (true)
            {
                i += 2;
                if (!MyUtils.slow_is_prime(i)) {
                    //System.out.print("Testing i now: " + i + ": ");
                    if (!Goldbach.fullfills_goldbach(i)) {
                        end = System.currentTimeMillis();
                        break while_loop;
                    }
                }
            }
            total += (end - start);
        }

        System.out.println(total + " ms");
    }

    public static boolean fullfills_goldbach(long composite)
    {
        boolean goldbach = true;

        long i = 0, j = 0;

        main_loop:
        {
        while (goldbach)
        {
            loop:
            {
            for (i = composite - 1; i > 0; i--)
            {
                if (MyUtils.slow_is_prime(i))
                {
                    up_loop:
                    {
                    for (j = 0; j < composite; j++) {
                        long val = Math.round(i + 2 * j * j);
                        if (val > composite)
                        {
                            break up_loop;
                        }

                        if (val == composite) {
                            goldbach = false;
                            break loop;
                        }
                    }
                    }
                }
            }
            break main_loop;
            }
        }
        }

        if (!goldbach) {
        //System.out.println("Works with comp = " + i + " + 2 * " + j + "^2\t");
            }
        else
            {
            System.out.println("Breaks at comp = " + composite);
            return false;
        }

        return true;
    }
}
