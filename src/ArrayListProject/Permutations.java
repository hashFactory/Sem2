package ArrayListProject;

import java.util.ArrayList;
import java.util.Scanner;

class PermutationGenerator
{
    public PermutationGenerator()
    {

    }

    public ArrayList<Integer> nextPermutation(int low, int high)
    {
        if (low > high)
            low = high + low - (high = low);

        ArrayList<Integer> original_set = new ArrayList<Integer>();
        ArrayList<Integer> result_set = new ArrayList<Integer>();

        for (int i = low; i < high + 1; i++)
            original_set.add(i);

        int size = original_set.size();
        for (int i = size; i > 0; i--)
        {
            int random_index = (int)(Math.random() * (double)original_set.size());
            result_set.add(original_set.get(random_index));
            original_set.remove(random_index);
        }

        return result_set;
    }
}

public class Permutations
{
    public static void main(String [] args)
    {
        PermutationGenerator pg = new PermutationGenerator();
        Scanner kb = new Scanner(System.in);

        System.out.println("Please input minimum number: ");
        int min = kb.nextInt();
        System.out.println("Please input maximum number: ");
        int max = kb.nextInt();
        System.out.println("Please input number of permutations desired");
        int perm = kb.nextInt();

        System.out.println("Your " + perm + " permutations: ");
        for (int i = 0; i < perm; i++)
        {
            ArrayList<Integer> set = new ArrayList<Integer>();
            set = pg.nextPermutation(min, max);
            System.out.print("#" + (i + 1) + ": ");
            for (int number : set)
                System.out.print("\t" + number);
            System.out.print("\n");
        }
    }
}
