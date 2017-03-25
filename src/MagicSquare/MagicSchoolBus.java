package MagicSquare;

import java.util.Scanner;

public class MagicSchoolBus
{

    public MagicSchoolBus()
    {
    }

    public int[][] fillArray(int[][] magic_square)
    {
        Scanner kb = new Scanner(System.in);
        int size = (int)Math.round(Math.sqrt(magic_square.length));
        int[][] user_options = new int[(int)Math.sqrt(magic_square.length)][(int)Math.sqrt(magic_square.length)];

        for (int i = 0; i < (int)Math.sqrt(magic_square.length); i++)
        {
            for (int j = 0; j < (int)Math.sqrt(magic_square.length); j++)
            {
                System.out.println("Please enter value for row " + (i + 1) + " and column " + (j + 1));
                user_options[i][j] = kb.nextInt();
            }
        }

        return user_options;
    }

    public boolean checkArray(int[][] magic_square)
    {
        return true;
    }

    private int sumOfCol(int[][] magic_square, int col_number)
    {

        return 2;
    }
}
