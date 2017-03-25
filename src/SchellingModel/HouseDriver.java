package SchellingModel;

import Housing.DrunkGuy;
import Housing.Grass;
import Housing.HousingMethods;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by charpentiert on 3/17/17.
 */
public class HouseDriver extends JApplet implements Runnable
{
    public static int tilex = 25;
    public static int tiley = 25;
    public static House[] houses = new House[tilex * tiley];
    private double tileWidth;
    private double tileHeight;

    public void init()
    {
        setSize(600,600);
        setFocusable(true);
        /*
        for (int i = 0; i < 10; i++)
        {
            house[i] = new HousingMethods();
            house[i].setColor();
        }
        */
        tileWidth = (double)getWidth() / (double)tilex;
        tileHeight = (double)getHeight() / (double)tiley;
        for (int i = 0; i < tilex; i++)
            for (int j = 0; j < tiley; j++)
                houses[i * tilex + j] = new House(i, j, 25);
    }

    public void start()
    {
        Thread th = new Thread(this);
        th.start();
    }

    public void stop()
    {

    }

    /*
    private Color generateColor(int timeSinceWalkedOn)
    {
        if (timeSinceWalkedOn >= timeThreshold)
            return Color.GREEN;
        int[] green_rgb = {0, 255, 0};
        int[] yellow_rgb = {255, 255, 0};
        int[] gradient_rgb = {0, 255, 0};

        gradient_rgb[0] = (int)(((timeThreshold - (double)timeSinceWalkedOn) / (double)timeThreshold) * 255);

        return new Color(gradient_rgb[0], gradient_rgb[1], gradient_rgb[2]);
    }*/

    @Override
    public void paint(Graphics g)
    {

        for (int i = 0; i < tilex * tiley; i++)
        {
            if (houses[i].color == 1)
                g.setColor(Color.GREEN);
            else if (houses[i].color == 2)
                g.setColor(Color.BLUE);
            else if (houses[i].color == 3)
            {
                g.setColor(getBackground());
            }
            g.fillOval((i % tilex) * (int)tileWidth, ((i / tiley) % tiley) * (int)tileWidth, (int)tileWidth, (int)tileHeight);
        }
    }

    public void run() {
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        while (true)
        {
            /*
            ArrayList<Integer> emptyHouses = HouseMethods.returnEmptyHouses();
            for (int i = 0; i < emptyHouses.size(); i++)
                System.out.print(emptyHouses.get(i) + "\t");
            System.out.println();
*/
            ArrayList<Integer> emptyHouses  = new ArrayList<>();
            for (int i = 0; i < tilex; i++)
            {
                for (int j = 0; j < tiley; j++)
                {
                    if (HouseMethods.isHappy(houses[i * tilex + j]))
                        emptyHouses.add(i * tilex + j);
                }
            }

            for (int i = 0; i < tilex; i++)
            {
                for (int j = 0; j < tiley; j++)
                {

                }
            }

            for (int i = 0; i < 7893454; i++)
            {
                int num = (int)(Math.random() * tilex * tiley);

                boolean result = HouseMethods.isHappy(houses[num]);
                if (!result)
                {
                    boolean isHappy = false;
                    int random_house = 0;
                    while (!isHappy)
                    {
                        random_house = (int)(Math.random() * tilex * tiley);
                        isHappy = HouseMethods.isHappy(houses[random_house]);
                    }
                    House temp = houses[num];
                    houses[num] = houses[random_house];
                    houses[random_house] = temp;
                }
            }


            repaint();
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
