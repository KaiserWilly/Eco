package client;

import javax.swing.*;
import java.awt.*;

/**
 * Created 01/01/16
 * Software Development
 * TSA Conference, 2016
 * ChartBuySell: Class containing code creating
 * the Buy and Sell GUI graphs
 */
public class ChartBuySell extends JPanel {
    double[] gData;

    public ChartBuySell(double[] data) {
        gData = data;
        setSize(725, 200);
        setLocation(0, 0);
        setBackground(Color.WHITE);
    }

    //Create actual graph components
    public void paintComponent(Graphics g) {
        int minVal = filingStocks.getMinValue(gData);
        int maxVal = filingStocks.getMaxValue(gData);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        g.setColor(Color.WHITE);
        g.fillRect(25, 25, 675, 150); //Background
        g.setColor(Color.BLACK);
        g.drawRect(25, 25, 675, 150); //Foreground
        g.drawString("Price Over Last 60 Seconds", 262, 15);
        g.drawLine(25, 25, 22, 25);
        g.drawLine(25, 175, 22, 175);
        g.drawString("$" + maxVal, 0, 20);
        g.drawString("$" + minVal, 0, 190);

        int x1 = 25;
        int x2 = x1 + 23;
        int arrayDiff = maxVal - minVal;
        int y1;
        if (gData[0] == 0) {
            y1 = 0;
        } else {
            y1 = (int) (150 - (125 * ((gData[0] - minVal)) / arrayDiff));
        }
        g.setColor(Color.BLUE);
        for (int i = 1; i < gData.length; i++) { // Draws lines displayed
            if (gData[i] != 0) {
                int val = (int) (150 - (125 * ((gData[i] - minVal)) / arrayDiff));
                if (y1 != 0) {
                    g2.drawLine(x1, y1, x2, val);
                }
                y1 = val;
            }
            x1 = x2;
            x2 = x1 + 23;

        }

    }
}
