package Complex;


public class α
{
    public double a = 0;
    public double b = 0;

    public α(double _a, double _b)
    {
        a = _a;
        b = _b;
    }

    public static α add(α x, α y)
    {
        return new α(x.a + y.a, x.b + y.b);
    }

    public static α sub(α x, α y)
    {
        return add(x, new α(-1.0 * y.a, -1.0 * y.b));
    }

    public static α mul(α x, α y)
    {
        return new α(x.a * y.a - x.b * y.b, x.b * y.a + x.a * y.b);
    }

    public static α div(α x, α y)
    {
        return new α((x.a * y.a + x.b * y.b) / (y.a * y.a + y.b * y.b), (x.b * y.a - x.a * y.b) / (y.a * y.a + y.b * y.b));
    }
}
