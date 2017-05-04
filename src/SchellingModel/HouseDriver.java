package SchellingModel;

import Housing.DrunkGuy;
import Housing.Grass;
import Housing.HousingMethods;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by charpentiert on 3/17/17.
 */
public class HouseDriver extends JApplet implements Runnable
{
    public static int tilex = 25;
    public static int tiley = 25;
    public static House[][] houses = new House[tilex][tiley];
    private double tileWidth;
    private double tileHeight;

    private static Scanner kb = new Scanner(System.in);

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
                houses[i][j] = new House(i, j, 45);
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

        for (int i = 0; i < tilex; i++)
        {
            for (int j = 0; j < tiley; j++)
            {
                if (!HouseMethods.isHappy(houses[i][j])) {
                    g.setColor(Color.BLACK);
                    g.fillRect(i * (int) tileWidth, j * (int) tileWidth, (int) tileWidth, (int) tileHeight);
                } else {
                    g.setColor(Color.WHITE);
                    g.fillRect(i * (int) tileWidth, j * (int) tileWidth, (int) tileWidth, (int) tileHeight);
                }

                if (houses[i][j].color == 1)
                    g.setColor(Color.GREEN);
                else if (houses[i][j].color == 2)
                    g.setColor(Color.BLUE);
                else if (houses[i][j].color == 3)
                    g.setColor(getBackground());

                g.fillOval(i * (int) tileWidth, j * (int) tileWidth, (int) tileWidth, (int) tileHeight);
                g.setColor(Color.ORANGE);
                g.drawString(Integer.toString(i * tilex + j), i * (int) tileWidth, j * (int) tileWidth + (int) tileWidth);

                //System.out.println("House " + i + " is happy? " + HouseMethods.isHappy(houses[i][j]));
            }
        }
    }

    public void run() {
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        while (true)
        {

            for (int i = 0; i < tiley; i++)
            {
                int j = (int)(Math.random() * tilex);
                if (!HouseMethods.isHappy(houses[i][j]))
                {
                    boolean found_empty_house = false;
                    int random = 0;
                    while (!found_empty_house)
                    {
                        random = (int)(Math.random() * tilex * tiley);
                        if (houses[random % tilex][random / tiley].color == 3 && HouseMethods.isHappy(new House(random % tilex, random / tiley, houses[i][j].color)))
                            found_empty_house = true;
                    }

                    System.out.println("Will switch house (" + (random % tilex) + "," + (random / tiley) + ") with house (" + i + "," + j + ")");

                    House temp = houses[random % tilex][random / tiley];
                    houses[random % tilex][random / tiley] = houses[i][j];
                    houses[i][j] = temp;
                }
            }


            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Input house number: ");
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int i = kb.nextInt();

            int x = i % tilex;
            int y = i / tiley;

            System.out.println("House " + i + " has " + HouseMethods.getNeighbors(houses[x][y]).length + " neighbors");
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("Its neighbors are: ");
            for (House num: HouseMethods.getNeighbors(houses[x][y]))
                System.out.print((num.x * tilex + num.y) + ", ");
            System.out.println();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("House " + (i) + " is happy? " + Boolean.toString(HouseMethods.isHappy(houses[x][y])));

            int of_kind_1 = 0;
            int of_kind_2 = 0;
            for (House house: HouseMethods.getNeighbors(houses[x][y])) {
                if (house.color == 1)
                    of_kind_1++;
                if (house.color == 2)
                    of_kind_2++;
            }
            System.out.println("It has " + of_kind_1 + " neighbors of kind 1 and " + of_kind_2 + " neighbors of kind 2");

            int poop = kb.nextInt();


            repaint();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
