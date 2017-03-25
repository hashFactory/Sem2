import com.sun.javafx.geom.Vec3d;

import java.util.Scanner;

class TicTacToe
{
    public Scanner kb = new Scanner(System.in);

    public TicTacToe()
    {

    }

    public void printOut(Boolean[][][] thing)
    {
        for (int x = 0; x < thing.length; x++)
        {
            System.out.println("Level " + (x + 1) + ":");
            for (int y = 0; y < thing.length; y++)
            {
                for (int z = 0; z < thing.length; z++)
                {
                    char thing_to_print = ' ';
                    if (thing[x][y][z] == null) thing_to_print = '\u2588';
                    else if (thing[x][y][z].booleanValue()) thing_to_print = '\u2573';
                    else if (!thing[x][y][z].booleanValue()) thing_to_print = '\u25EF';
                    System.out.print(thing_to_print + "\t");
                }
                System.out.println();
            }
        }
    }

    public Vec3d askForInput()
    {
        System.out.println("Please enter [x],[y],[z] for your turn");
        String[] input = kb.nextLine().split(",");
        return new Vec3d(Integer.parseInt(input[0])-1, Integer.parseInt(input[1])-1, Integer.parseInt(input[2])-1);
    }

    public boolean checkIfValid(Boolean[][][] thing, int[] input)
    {
        return !(input[0] > 2 || input[0] < 0 || input[1] > 2 || input[1] < 0 || input[2] > 2 || input[2] < 0 || thing[input[0]][input[1]][input[2]] != null);
    }

    public int returnStatus(Boolean[][][] thing, int[] input, boolean x_turn)
    {
        // Check for victory, row
        if (thing[0][input[1]][input[2]] != null && thing[1][input[1]][input[2]] != null && thing[2][input[1]][input[2]] != null)
            if (thing[0][input[1]][input[2]] == x_turn && thing[1][input[1]][input[2]] == x_turn && thing[2][input[1]][input[2]] == x_turn)
                return 2;
        // check for victory, col
        if (thing[input[0]][0][input[2]] != null && thing[input[0]][1][input[2]] != null && thing[input[0]][2][input[2]] != null)
            if (thing[input[0]][0][input[2]] == x_turn && thing[input[0]][1][input[2]] == x_turn && thing[input[0]][2][input[2]] == x_turn)
                return 2;
        // check for victory, vertical
        if (thing[input[0]][input[1]][0] != null && thing[input[0]][input[1]][1] != null && thing[input[0]][input[1]][2] != null)
            if (thing[input[0]][input[1]][0] == x_turn && thing[input[0]][input[1]][1] == x_turn && thing[input[0]][input[1]][2] == x_turn)
                return 2;
        // check for victory, diag

        // Check for tie
        boolean is_tie = true;
        for (Boolean[][] bool_2: thing)
            for (Boolean[] bool_1: bool_2)
                for (Boolean bool: bool_1)
                    if (bool == null)
                        is_tie = false;
        if (is_tie)
            return 3;

        return 4;
    }
}

public class _3DTicTacToeDriver
{
    public static void main(String [] args)
    {
        TicTacToe tic = new TicTacToe();
        Boolean[][][] thing = new Boolean[3][3][3];
        int size_length = (int)Math.round(Math.pow(thing.length, (1.0/3.0)));
        boolean x_turn = true;
        int status = 4;

        tic.printOut(thing);

        while (status == 4)
        {
            Vec3d input = tic.askForInput();
            int[] sensible_input = {(int)(Math.round(input.x) + 0.1),(int)(Math.round(input.y) + 0.1),(int)(Math.round(input.z) + 0.1)};
            if (tic.checkIfValid(thing, sensible_input))
                thing[sensible_input[0]][sensible_input[1]][sensible_input[2]] = x_turn;
            status = tic.returnStatus(thing, sensible_input, x_turn);    // 2 = win, 3 = tie, 4 = keep going
            x_turn = !x_turn;
            tic.printOut(thing);
        }

        x_turn = !x_turn;
        if (x_turn && status == 2)
            System.out.println("Player 1 wins!");
        else if (!x_turn && status == 2)
            System.out.println("Player 2 wins");
        else if (status == 3)
            System.out.println("It's a tie!");

    }
}
