package Housing;

import java.applet.Applet;
import java.awt.*;

public class HousingDriver extends Applet implements Runnable
{
    //HousingMethods[] house = new HousingMethods[10];
    private int tilex = 50;
    private int tiley = 50;
    private Grass[][] grass = new Grass[tilex][tiley];
    private DrunkGuy guy = new DrunkGuy();
    private double tileWidth;
    private double tileHeight;
    private int timeThreshold = 400;

    public void init()
    {
        setSize(1000,700);
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
        {
            for (int j = 0; j < tiley; j++)
            {
                grass[i][j] = new Grass();
            }
        }
    }

    public void start()
    {
        Thread th = new Thread(this);
        th.start();
    }

    public void stop()
    {

    }

    private Color generateColor(int timeSinceWalkedOn)
    {
        if (timeSinceWalkedOn >= timeThreshold)
            return Color.GREEN;
        int[] green_rgb = {0, 255, 0};
        int[] yellow_rgb = {255, 255, 0};
        int[] gradient_rgb = {0, 255, 0};

        gradient_rgb[0] = (int)(((timeThreshold - (double)timeSinceWalkedOn) / (double)timeThreshold) * 255);

        return new Color(gradient_rgb[0], gradient_rgb[1], gradient_rgb[2]);
    }

    @Override
    public void paint(Graphics g)
    {
        /*
        for (int i = 0; i < 10; i++)
        {
            if (house[i].getColor() == 4)
                g.setColor(Color.BLUE);
            else if (house[i].getColor() == 3)
                g.setColor(Color.GREEN);
            else if (house[i].getColor() == 5)
            {
                g.setColor(getBackground());
            }
            g.fillOval(20 * i, 0, 20, 20);
        }
        */
        g.clearRect(0, 0, getWidth(), getHeight());

        for (int i = 0; i < tilex; i++)
        {
            for (int j = 0; j < tiley; j++)
            {
                if (grass[i][j].timeSinceWalkedOn > 0)
                {
                    grass[i][j].timeSinceWalkedOn++;
                    grass[i][j].color = generateColor(grass[i][j].timeSinceWalkedOn);
                }
                g.setColor(grass[i][j].color);
                g.fillRect(i * ((int)tileWidth) + 1, j * ((int)tileHeight) + 1, (int)tileWidth - 2, (int)tileHeight - 2);

            }
        }

        g.setColor(Color.RED);
        g.fillRect(guy.x * (int)(tileWidth) + 1, guy.y * (int)(tileHeight), (int)tileWidth - 2, (int)tileHeight - 2);
    }

    @Override
    public void run()
    {
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        while (true)
        {
            boolean goodWalk = false;
            int thing = 5;
            while (!goodWalk)
            {
                thing = guy.step();
                System.out.println(thing);
                if (thing == 0)
                    if (guy.y - 1 >= 0)
                        goodWalk = true;
                if (thing == 1)
                    if (guy.y + 1 < tiley)
                        goodWalk = true;
                if (thing == 2)
                    if (guy.x + 1 < tilex)
                        goodWalk = true;
                if (thing == 3)
                    if (guy.x - 1 >= 0)
                        goodWalk = true;
            }

            if (thing == 0)
                guy.y --;
            if (thing == 1)
                guy.y ++;
            if (thing == 2)
                guy.x ++;
            if (thing == 3)
                guy.x --;

            grass[guy.x][guy.y].timeSinceWalkedOn = 1;

            System.out.println(thing + "," + guy.x + "," + guy.y);

            repaint();
            try
            {
                Thread.sleep(10);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

    }
}
