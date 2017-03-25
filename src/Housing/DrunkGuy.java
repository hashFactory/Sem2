package Housing;

public class DrunkGuy
{
    int upBias = 50;
    int downBias = 100 - upBias;
    int rightBias = 50;
    int leftBias = 100 - rightBias;

    int x = 25;
    int y = 25;

    public DrunkGuy()
    {

    }

    public int step()
    {
        int direction = (int)(Math.random() * 200.0);
        if (direction < upBias)
            return 0;   // UP
        else if (direction < upBias + downBias)
            return 1;   // DOWN
        else if (direction < upBias + downBias + rightBias)
            return 2;   // RIGHT
        else if (direction < upBias + downBias + rightBias + leftBias)
            return 3;   // LEFT
        // FATAL ERROR
        return 4;
    }
}
