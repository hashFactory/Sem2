import java.util.ArrayList;
import java.util.Scanner;

public class GCD
{
    static ArrayList<Integer> gcd = new ArrayList<>(), factor = new ArrayList<>();

    public static void main(String[] args)
    {
        System.out.println("Please input two positive integers in a comma separated way");
        String[] input = new Scanner(System.in).nextLine().split(",");
        int[] n = {Integer.parseInt(input[0]), Integer.parseInt(input[1])};
        int iterations = -1, latest = n[0], _latest = n[1];
        do {
            iterations++;
            factor.add(latest / _latest);
            gcd.add(latest - (factor.get(iterations) * _latest));
            System.out.println(latest + " = " + _latest + " x " + factor.get(iterations) + " + " + (char) 27 + "[33m" + gcd.get(iterations) + (char) 27 + "[0m");
            latest = _latest;
            _latest = gcd.get(iterations);
        }
        while (gcd.get(iterations) != 0);
        System.out.println("GCD(" + n[0] + "," + n[1] + ") = " + (char) 27 + "[34m" + gcd.get(iterations - 1) + (char) 27 + "[0m");
    }
}