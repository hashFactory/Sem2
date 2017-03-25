import java.applet.Applet;
import java.util.ArrayList;

public class CashMoney
{
    /*
    public static void main(String [] args)
    {
        int[] array = {7, 11, 13, 17, 23};

        ArrayList<Integer> malleable_array = new ArrayList();
        for (int number: array)
        {
            malleable_array.add(number);
        }
        malleable_array.add(2);

        System.out.println(malleable_array.toString());
    }
    */

    public static void main(String [] args)
    {
        int i = (byte) + (char) - (int) + (long) - 1;
        int a = 6;
        int b = 7;

        a=b+a-(b=a);

        for(long l=4946144450195624l; l>0; l>>=5)
            System.out.print((char) (((l & 31 | 64) % 95) + 32));

        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                System.out.println(getClass().getName());
                System.out.println(random());
            }

            private int random()
            {
                return (int)(Math.random() * 1000);
            }
        });

        System.out.println("\n" + a + " " + b);
    }
}
