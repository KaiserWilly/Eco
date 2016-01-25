package Filing;

import javax.swing.*;
import java.awt.*;

/**
 * Created by JD Isenhart on 9/16/2015.
 */
public class FilingWidget {

    public static JPanel makeRankingWidget(Object[][] rankings, int width) {
        int panelLoc = 20;
        JPanel base = new JPanel();
        base.setBackground(new Color(198, 240, 198));
        base.setLayout(null);
        JLabel title = new JLabel("Rankings");
        title.setSize(100, 20);
        title.setLocation((width / 2) - 50, 0);
        base.add(title);
        for (int playIndex = 0; playIndex < rankings.length; playIndex++) {
            JPanel widgetPanel = new JPanel();
            widgetPanel.setLayout(null);
            widgetPanel.setSize(width, 30);
            widgetPanel.setBackground(new Color(114, 114, 114, 120));
            JLabel name = new JLabel(String.valueOf(rankings[playIndex][0]));
            name.setSize(width / 2, 20);
            name.setLocation(5, 5);
            widgetPanel.add(name);
            JLabel score = new JLabel(String.valueOf(rankings[playIndex][1]));
            score.setSize(width / 2, 20);
            score.setLocation(width / 2, 5);
            widgetPanel.add(score);
            widgetPanel.setLocation(0, panelLoc);
            base.add(widgetPanel);
            panelLoc = panelLoc + 30;
        }
        return base;
    }

    public static JPanel nonPStockWidget(Object[][] data, int width, String wTitle) {
        int panelLoc = 20;
        JPanel base = new JPanel();
        base.setBackground(new Color(198, 240, 198));
        base.setSize(250,300);
        base.setLayout(null);
        JLabel title = new JLabel(wTitle);
        title.setVerticalAlignment(SwingConstants.CENTER);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setSize(100, 20);
        title.setLocation((width / 2) - 50, 0);
        base.add(title);
        for (int playIndex = 0; playIndex < data.length; playIndex++) {
            JPanel widgetPanel = new JPanel();
            widgetPanel.setLayout(null);
            widgetPanel.setSize(width, 30);
            widgetPanel.setBackground(new Color(114, 114, 114, 120));
            JLabel name = new JLabel(String.valueOf(data[playIndex][0]));
            name.setSize(width / 2, 20);
            name.setLocation(5, 5);
            widgetPanel.add(name);
            JLabel score = new JLabel(String.valueOf(data[playIndex][1]));
            score.setSize(width / 2, 20);
            score.setLocation(width / 2, 5);
            widgetPanel.add(score);
            widgetPanel.setLocation(0, panelLoc);
            base.add(widgetPanel);
            panelLoc = panelLoc + 30;
        }
        return base;
    }

    public static JPanel playStockWidget(Object[][] data, int width, String wTitle) {
        int panelLoc = 20;
        JPanel base = new JPanel();
        base.setBackground(new Color(198, 240, 198));
        base.setLayout(null);
        JLabel title = new JLabel(wTitle);
        title.setVerticalAlignment(SwingConstants.CENTER);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setSize(150, 20);
        title.setLocation((width / 2) - 75, 0);
        base.add(title);
        for (int playIndex = 0; playIndex < data.length; playIndex++) {
            JPanel widgetPanel = new JPanel();
            widgetPanel.setLayout(null);
            widgetPanel.setSize(width, 30);
            widgetPanel.setBackground(new Color(114, 114, 114, 120));
            JLabel name = new JLabel(String.valueOf(data[playIndex][0]));
            name.setSize(width / 2, 20);
            name.setLocation(5, 5);
            widgetPanel.add(name);
            JLabel score = new JLabel(String.valueOf(data[playIndex][1]));
            score.setSize(width / 2, 20);
            score.setLocation(width / 2, 5);
            widgetPanel.add(score);
            widgetPanel.setLocation(0, panelLoc);
            base.add(widgetPanel);
            panelLoc = panelLoc + 30;
        }
        return base;
    }
}
