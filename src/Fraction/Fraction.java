package Fraction;

import javafx.util.converter.BigIntegerStringConverter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Fraction
{
    long num = 0;
    long den = 0;

    public Fraction(long num_, long den_)
    {
        num = num_;
        den = den_;
    }

    public Fraction userInput()
    {
        Scanner kb = new Scanner(System.in);
        System.out.print("Please input numerator: ");
        num = kb.nextLong();
        System.out.print("Please input denominator: ");
        den = kb.nextLong();
        return this;
    }

    public void createFraction(long first, long second)
    {

    }

    public Fraction reduce()
    {
        //BigInteger b1 = BigInteger.valueOf(num);
        //BigInteger b2 = BigInteger.valueOf(den);
        //BigInteger gcd = b1.gcd(b2);
        //num /= Long.valueOf(gcd.toString());
        //den /= Long.valueOf(gcd.toString());
        //return this;

        ArrayList<Long> gcd = new ArrayList<>(), factor = new ArrayList<>();
        //int num1, int num2;
        long iterations = -1, latest = num, _latest = den;
        do {
            iterations++;
            factor.add(latest / _latest);
            gcd.add(latest - (factor.get((int)iterations) * _latest));
            System.out.println(latest + " = " + _latest + " x " + factor.get((int)iterations) + " + " + (char) 27 + "[33m" + gcd.get((int)iterations) + (char) 27 + "[0m");
            latest = _latest;
            _latest = gcd.get((int)iterations);
        }
        while (gcd.get((int)iterations) != 0);
        num /= gcd.get((int)iterations - 1);
        den /= gcd.get((int)iterations - 1);
        return this;
    }

    public Fraction addFractions(Fraction first, Fraction second) {
        long _num = first.num * second.den + second.num * first.den;
        long _den = first.den * second.den;

        Fraction temp = new Fraction(_num, _den);
        temp.reduce();

        return temp;
    }

    public Fraction subFractions(Fraction first, Fraction second) {
        return addFractions(first, new Fraction(-1 * second.num, second.den));
    }

    public Fraction multFractions(Fraction first, Fraction second)
    {
        long _num = first.num * second.num;
        long _den = first.den * second.den;

        Fraction temp = new Fraction(_num, _den);
        temp = temp.reduce();

        return temp;
    }

    public Fraction divFractions(Fraction first, Fraction second)
    {
        return multFractions(first, new Fraction(second.den, second.num));
    }
}
