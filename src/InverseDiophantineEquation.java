import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by charpentiert on 4/4/17.
 */
public class InverseDiophantineEquation
{
    private static ArrayList<Long[]> getDivisors(long n)
    {
        ArrayList<Long[]> divisors = new ArrayList();
        for (long i = 2; i <= n / 2; i++) {
            if (n % i == 0)
            {
                Long[] array = new Long[2];
                array[0] = i;
                array[1] = n / i;
                divisors.add(array);
            }
        }

        return divisors;
    }

    public static void main(String [] args)
    {
        int solutions = 0;
        System.out.println("Please insert number ^ -1");
        double input = new Scanner(System.in).nextDouble();
        HashMap<Integer, Long[]> solu = new HashMap<>();

        ArrayList<Long[]> div = getDivisors(Math.round(Math.pow(input, 2)));

        for (Long divisor[]: div)
            System.out.println(divisor[0] + "," + divisor[1]);

        for (double i = input; i < Math.pow(input, 2); i++)
        {
            for (double j = input; j < Math.pow(input, 2); j++)
            {
                if (1.0 / input == ((1.0 / i) + (1.0 / j)))
                {
                    Long[] thing = new Long[2];
                    thing[0] = Math.round(i);
                    thing[1] = Math.round(j);
                    if (!solu.containsValue(thing))
                        solu.put(solutions, thing);
                    System.out.println("Solution: " + solutions + "(" + solu.get(solutions)[0] + "," + solu.get(solutions)[1] + ")");
                    solutions++;
                }
            }
        }
    }
}
