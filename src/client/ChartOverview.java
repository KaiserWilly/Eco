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
        int minVal = FilingStocks.getMinValue(gData);
        int maxVal = FilingStocks.getMaxValue(gData);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        g.setColor(Color.WHITE);
        g.fillRect(25, 25, 1175, 200);
        g.setColor(Color.BLACK);
        g.drawRect(25, 25, 1175, 200);
        g.drawString("Avg. Price over last 60 seconds", 538, 15);
        g.drawLine(25, 25, 22, 25);
        g.drawLine(25, 225, 22, 225);
        g.drawString("$" + maxVal, 0, 20);
        g.drawString("$" + minVal, 0, 240);

        int x1 = 25;
        int x2 = x1 + 40;
        int arrayDiff = maxVal - minVal;
        int y1;
        if (gData[0] == 0) {
            y1 = 0;
        } else {
            y1 = (int) (175 - (150 * ((gData[0] - minVal)) / arrayDiff));
        }
        g.setColor(Color.BLUE);
        for (int i = 1; i < gData.length; i++) {
            if (gData[i] != 0) {
                int val = (int) (175 - (150 * ((gData[i] - minVal)) / arrayDiff));
                if (y1 != 0) {
                    g2.drawLine(x1, y1, x2, val);
                }
                y1 = val;
            }
            x1 = x2;
            x2 = x1 + 40;

        }

    }
}
