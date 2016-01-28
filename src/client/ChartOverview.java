package client;

import javax.swing.*;
import java.awt.*;

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
        g.drawRect(25, 25, 1175, 200);
        g.drawString("Avg. Price over last 60 seconds", 538, 15);
        int x1 = 25;
        int x2 = x1 + 19;
        int y1 = 0;
        g.setColor(Color.BLUE);
        for (int i = 0; i < gData.length; i++) {
            int val = (int) gData[i];
            val = 225 - (val * 3);
            if (val != 225) {
                g.drawLine(x1, y1, x2, val);
            }
            x1 = x2;
            x2 = x1 + 19;
            y1 = val;
        }

    }
}
