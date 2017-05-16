package Complex;

/**
 * Created by charpentiert on 5/12/17.
 */
public class αDriver
{
    public static void main(String [] args)
    {
        α first = new α(2, 5);
        α second = new α(1, 0.5);

        System.out.println(print(first) + " + " + print(second) + " = " + print(α.add(first, second)));
        System.out.println(print(first) + " - " + print(second) + " = " + print(α.sub(first, second)));
        System.out.println(print(first) + " * " + print(second) + " = " + print(α.mul(first, second)));
        System.out.println(print(first) + " / " + print(second) + " = " + print(α.div(first, second)));
    }

    public static String print(α first)
    {
        return "" + first.a + ((first.b >= 0) ? "+" : "-") + first.b + "i";
    }

}
