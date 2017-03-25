package SchellingModel;

import java.util.ArrayList;

/**
 * Created by charpentiert on 3/17/17.
 */
public class HouseMethods
{
    public static int[] getNeighbors(House house)
    {
        ArrayList<House> houses = new ArrayList<>();

        try
        {
            for (int i = -1; i <= 1; i++)
            {
                for (int j = -1; j <= 1; j++)
                {
                    houses.add(HouseDriver.houses[(house.x + i) * HouseDriver.tilex + j]);
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException ex) {}

        int[] houses1 = new int[houses.size()];
        for (int i = 0; i < houses1.length; i++)
            houses1[i] = houses.get(i).color;
        return houses1;
    }

    public static boolean isHappy(House house)
    {
        int[] colors;

        colors = getNeighbors(house);

        double problems = 0;
        for (int color: colors)
        {
            if (color != house.color)
                problems+=12.5;
        }

        return (problems > house.tolerance);
    }

    public static ArrayList<Integer> returnEmptyHouses()
    {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < HouseDriver.tilex; i++)
        {
            for (int j = 0; j < HouseDriver.tiley; j++)
            {
                if (HouseDriver.houses[i * HouseDriver.tilex + j].color == 3)
                    list.add(i * HouseDriver.tilex + j);
            }
        }

        return list;
    }


}
