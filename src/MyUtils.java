/**
 * Created by charpentiert on 3/27/17.
 */
public class MyUtils
{
    public static boolean slow_is_prime(long number)
    {
        boolean primality = true;
        if (number > 2 && number % 2 == 0)
        {
            primality = false;
        }
        else
        {
            long sqrt = (long)(Math.sqrt(number) + 1);
            main_loop:
            {
                for (long i = 3; i < sqrt; i += 2)
                {
                    if (number % i == 0)
                    {
                        primality = false;
                        i = sqrt;
                        break main_loop;
                    }
                }
            }
        }

        return primality;
    }
}
