package MagicSquare;

public class MagicSquareDriver
{
    public static void main(String [] args)
    {
        int size = 3;
        int[][] magic_square = new int[size][size];
        MagicSchoolBus msb = new MagicSchoolBus();

        magic_square = msb.fillArray(magic_square);
    }
}
