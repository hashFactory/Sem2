package Applets;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class IBExample extends Applet implements Runnable, KeyListener
{
    // TODO what is the difference between modeling and simulating

    ArrayList<Rectangle2D.Double> cars = new ArrayList<>();
    Rectangle2D.Double player;

    public void init()
    {
        setSize(400, 400);
        setBackground(new Color(2,2,2));
        for (int i = 0; i < 3; i++)
            cars.add(new Rectangle2D.Double(i * (getWidth() / 3) + (getWidth() / 9),0,getWidth() / 9,40));
        player = new Rectangle2D.Double((getWidth() / 3) + getWidth() / 12, getHeight() - 30, getWidth() / 6, 30);
    }

    public void start()
    {
        Thread t = new Thread();
        t.start();
    }

    public void stop() {}

    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.clearRect(0, 0, getWidth(), getHeight());

        g2.setColor(new Color(255, 255, 255));

        for (Rectangle2D.Double car: cars)
            g2.fill(car);

        g2.fill(player);

    }

    private boolean checkForIntersection(Rectangle2D.Double car)
    {
        return true;
    }

    private void update()
    {
        for (int i = 0; i < 3; i++)
        {
            cars.get(i).setRect(cars.get(i).getX(), cars.get(i).getY() + 2, cars.get(i).getWidth(), cars.get(i).getHeight());
        }
    }


    @Override
    public void run()
    {
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);

        while (true)
        {
            update();
            repaint();

            try
            {
                Thread.sleep(20);
            }
            catch (InterruptedException ex)
            {
                stop();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
