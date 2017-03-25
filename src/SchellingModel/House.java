package SchellingModel;

/**
 * Created by charpentiert on 3/17/17.
 */
public class House
{
    public int x = 0;
    public int y = 0;
    public int color = 0;
    public double tolerance = 0;

    public House(int _x, int _y, double _tol)
    {
        x = _x;
        y = _y;
        double temp = Math.random();
        if (temp < 0.5)
            color = 1;
        else if (temp < 0.9)
            color = 2;
        else
            color = 3;

        tolerance = _tol;
    }
}
