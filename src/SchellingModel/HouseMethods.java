package SchellingModel;

import java.util.ArrayList;

import static SchellingModel.HouseDriver.tilex;
import static SchellingModel.HouseDriver.tiley;

/**
 * Created by charpentiert on 3/17/17.
 */
public class HouseMethods
{
    public static House[] getNeighbors(House house)
    {
        ArrayList<House> houses = new ArrayList<>();

        for (int i = -1; i <= 1; i++)
        {
            for (int j = -1; j <= 1; j++)
            {
                if (!(i == 0 && j == 0))
                {
                    try
                    {
                        houses.add(HouseDriver.houses[house.x + i][house.y + j]);
                    }
                    catch (ArrayIndexOutOfBoundsException ex)
                    {
                    }
                }
            }
        }

        //System.out.println("House: (" + house.x + "," + house.y + ") has " + houses.size() + " neighbours");

        House[] houses1 = new House[houses.size()];
        for (int i = 0; i < houses1.length; i++)
            houses1[i] = houses.get(i);
        return houses1;
    }

    public static boolean isHappy(House house)
    {
        House[] colors = getNeighbors(house);

        int of_kind_1 = 0;
        int of_kind_2 = 0;

        double tolerance = 100;

        for (House identifier: getNeighbors(house))
        {
            if (identifier.color == 1)
                of_kind_1++;
            if (identifier.color == 2)
                of_kind_2++;
        }

        int total = of_kind_1 + of_kind_2;
        double diff = 100.0 * (1.0 / (double)total);

        if (house.color == 3)
            return true;

        if (house.color == 1)
            tolerance -= diff * of_kind_2;
        if (house.color == 2)
            tolerance -= diff * of_kind_1;

        return (tolerance > house.tolerance);

        /*
        double problems = 100;
        for (int location: colors)
        {
            if (house.color == 1 && HouseDriver.houses[location].color == 2)
                    problems -= 100.0 * (1.0 / 8.0);
            if (house.color == 2 && HouseDriver.houses[location].color == 1)
                    problems -= 100.0 * (1.0 / 8.0);
        }

        return (problems > house.tolerance);*/
    }

    public static ArrayList<Integer> returnEmptyHouses()
    {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < tilex; i++)
        {
            for (int j = 0; j < HouseDriver.tiley; j++)
            {
                //if (HouseDriver.houses[i * tilex + j].color == 3)
                //    list.add(i * tilex + j);
            }
        }

        return list;
    }


}
