package client;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * Created by james on 1/27/2016.
 */
public class ChartOverview extends JPanel {
    double[] gData;

    public ChartOverview(double[] data) {
        gData = data;
        setSize(1225, 250);
        setLocation(0, 0);
        setBackground(Color.WHITE);
    }


    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        g.drawRect(25, 25, 1175, 200);
        g.drawString("Avg. Price over last 60 seconds", 538, 15);
        //System.out.println(Arrays.toString(gData));
        int x1 = 25;
        int x2 = x1 + 39;
        int y1 = 0;
        g.setColor(Color.BLUE);
        for (int i = 0; i < gData.length; i++) {
            int val = (int)(175 - ((gData[i]-23) * 75));

            if (val != 175) {
                g2.drawLine(x1, y1, x2, val);
            }
            x1 = x2;
            x2 = x1 + 39;
            y1 = val;
        }

    }
}
