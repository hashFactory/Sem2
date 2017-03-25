package Housing;

public class HousingMethods
{
    private int num;

    public HousingMethods()
    {
        num = 2;
    }

    public void setColor()
    {
        // Green(~35%), blue(~55%), or empty(~10%)
        // Num 3 = green, num 4 = blue, num 5 = empty
        double value = Math.random();
        if (value < 0.55)
            num = 4;
        else if (value < 0.90)
            num = 3;
        else
            num = 5;
    }

    public int getColor()
    {
        return num;
    }
}
