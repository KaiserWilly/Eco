package filing;

import client.FilingStocks;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

/**
 * Created by JD Isenhart on 9/16/2015.
 */
public class FilingWidget {

    public static JPanel makeRankingWidget(Object[][] rankings, int width) {
        int panelLoc = 20;
        JPanel base = new JPanel();
        base.setBackground(new Color(198, 240, 198));
        base.setLayout(null);
        base.setSize(width, 300);
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
        base.setSize(width, 300);
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

    public static JPanel buyWidget(String stockName, int wid, int hei) {
        JPanel base = new JPanel();
        base.setSize(wid, hei);
        base.setLayout(null);
        Font nameF = new Font("Tahoma", Font.BOLD, 8);
        JLabel name = new JLabel(stockName);
        name.setSize(100, 10);
        name.setVerticalAlignment(SwingConstants.CENTER);
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setLocation(0, 0);
        name.setFont(nameF);
        base.add(name);

//        StockHistory.getStockHistory(stockName);
        DecimalFormat df = new DecimalFormat("$#,###.##");
        double change = 3.7/*Double.parseDouble(df.format(StockHistory.percentChange))*/;
        JLabel perChange = new JLabel(/*Double.toString(change) + "%"*/ "3.4%");
        if (change >= 0) {
            perChange.setForeground(new Color(0, 0, 0));
        } else {
            perChange.setForeground(new Color(225, 149, 152));
        }
        perChange.setSize(100, 10);
        perChange.setVerticalAlignment(SwingConstants.CENTER);
        perChange.setHorizontalAlignment(SwingConstants.CENTER);
        perChange.setLocation(100, 0);
        perChange.setFont(nameF);
        base.add(perChange);

        JLabel price = new JLabel(df.format(FilingStocks.getPrice(stockName)));
        price.setSize(100, 10);
        price.setVerticalAlignment(SwingConstants.CENTER);
        price.setHorizontalAlignment(SwingConstants.CENTER);
        price.setLocation(250, 0);
        price.setFont(nameF);
        base.add(price);
        return base;
    }
}
