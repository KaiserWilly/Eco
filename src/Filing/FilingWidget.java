package filing;

import client.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/**
 * Created 11/07/15
 * Software Development
 * TSA Conference, 2016
 * FilingWidget: Class containing code that creates Widgets used in every panel
 */
public class FilingWidget {


    public static JPanel nonPStockWidget(Object[][] data, int width, String wTitle) {
        int panelLoc = 20;

        JPanel base = new JPanel();
        base.setBackground(new Color(198, 240, 198));
        base.setSize(width, 300);
        base.setLayout(null);

        //Title
        JLabel title = new JLabel(wTitle);
        title.setVerticalAlignment(SwingConstants.CENTER);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setSize(100, 20);
        title.setLocation((width / 2) - 50, 0);
        base.add(title);

        for (int playIndex = 0; playIndex < data.length; playIndex++) {
            //WidgetPanel
            JPanel widgetPanel = new JPanel();
            widgetPanel.setLayout(null);
            widgetPanel.setSize(width, 30);
            widgetPanel.setBackground(new Color(114, 114, 114, 120));

            //Stock Name
            JLabel name = new JLabel(String.valueOf(data[playIndex][0]));
            name.setSize(width / 2, 20);
            name.setLocation(5, 5);
            widgetPanel.add(name);

            //Stock Score
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

        //Title
        JLabel title = new JLabel(wTitle);
        title.setVerticalAlignment(SwingConstants.CENTER);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setSize(150, 20);
        title.setLocation((width / 2) - 75, 0);
        base.add(title);

        for (int playIndex = 0; playIndex < data.length; playIndex++) {
            if (!String.valueOf(data[playIndex][1]).equals("5000") && !String.valueOf(data[playIndex][1]).equals("0")) { // Not null

                //WidgetPanel
                JPanel widgetPanel = new JPanel();
                widgetPanel.setLayout(null);
                widgetPanel.setSize(width, 30);
                widgetPanel.setBackground(new Color(114, 114, 114, 120));

                //Stock Title
                JLabel name = new JLabel(String.valueOf(data[playIndex][0]));
                name.setSize(width / 2, 20);
                name.setLocation(5, 5);
                widgetPanel.add(name);

                //Stock Score
                JLabel score = new JLabel(String.valueOf(data[playIndex][1]));
                score.setSize(width / 2, 20);
                score.setLocation(width / 2, 5);
                widgetPanel.add(score);

                widgetPanel.setLocation(0, panelLoc);
                base.add(widgetPanel);
                panelLoc = panelLoc + 30;
            }
        }
        return base;
    }

    public static JPanel buyWidget(String stockName, int wid, int hei) {
        JPanel base = new JPanel();
        base.setSize(wid, hei);
        base.setLayout(null);
        Font nameF = new Font("Tahoma", Font.BOLD, 8);

        //Stock Name
        JLabel name = new JLabel(stockName);
        name.setSize(100, hei);
        name.setVerticalAlignment(SwingConstants.CENTER);
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setLocation(0, 0);
        name.setFont(nameF);
        base.add(name);

        //Percent change over 60s
        StockHistory.getStockHistory(stockName);
        DecimalFormat df = new DecimalFormat("$#,###.##");
        DecimalFormat percentChangeDF = new DecimalFormat("##.##");
        String change = percentChangeDF.format(StockHistory.percentChange);
        JLabel perChange = new JLabel(change + "%");
        perChange.setForeground(new Color(0, 0, 0));
        perChange.setSize(100, hei);
        perChange.setVerticalAlignment(SwingConstants.CENTER);
        perChange.setHorizontalAlignment(SwingConstants.CENTER);
        perChange.setLocation(100, 0);
        perChange.setFont(nameF);
        base.add(perChange);

        //Stock Price
        JLabel price = new JLabel(df.format(FilingStocks.getPrice(stockName)));
        price.setSize(100, hei);
        price.setVerticalAlignment(SwingConstants.CENTER);
        price.setHorizontalAlignment(SwingConstants.CENTER);
        price.setLocation(200, 0);
        price.setFont(nameF);
        base.add(price);

        //Focus button
        JButton lookin = new JButton("Get Details!");
        lookin.setSize(100, 10);
        lookin.setLocation(300, 0);
        lookin.setFont(nameF);
        lookin.addActionListener(new BuyActLis(stockName));
        base.add(lookin);

        return base;

    }

    public static JPanel sellWidget(String stockName, int wid, int hei) {
        JPanel base = new JPanel();
        base.setSize(wid, hei);
        base.setLayout(null);
        Font nameF = new Font("Tahoma", Font.BOLD, 8);

        //Stock Name
        JLabel name = new JLabel(stockName);
        name.setSize(100, hei);
        name.setVerticalAlignment(SwingConstants.CENTER);
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setLocation(0, 0);
        name.setFont(nameF);
        base.add(name);

        //Percent Change over 60s
        StockHistory.getStockHistory(stockName);
        DecimalFormat df = new DecimalFormat("$#,###.##");
        DecimalFormat percentChangeDF = new DecimalFormat("##.##");
        String change = percentChangeDF.format(StockHistory.percentChange);
        JLabel perChange = new JLabel(change + "%");
        perChange.setForeground(new Color(0, 0, 0));
        perChange.setSize(100, hei);
        perChange.setVerticalAlignment(SwingConstants.CENTER);
        perChange.setHorizontalAlignment(SwingConstants.CENTER);
        perChange.setLocation(100, 0);
        perChange.setFont(nameF);
        base.add(perChange);

        //Stock Price
        JLabel price = new JLabel(df.format(FilingStocks.getPrice(stockName)));
        price.setSize(100, hei);
        price.setVerticalAlignment(SwingConstants.CENTER);
        price.setHorizontalAlignment(SwingConstants.CENTER);
        price.setLocation(200, 0);
        price.setFont(nameF);
        base.add(price);

        //Focus Button
        JButton lookin = new JButton("Get Details!");
        lookin.setSize(100, 10);
        lookin.setLocation(300, 0);
        lookin.setFont(nameF);
        lookin.addActionListener(new SellActLis(stockName));
        base.add(lookin);

        return base;

    }

    public static class BuyActLis implements ActionListener {
        String stockName;

        public BuyActLis(String sName) {
            stockName = sName;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            FilingBuy.sliderPosition = 0;
            GUIBuy.stockbuy = stockName;
            FilingBuy.createLabels();
            FilingBuy.createWidget();
            FilingBuy.createBuyPanel(stockName);
            GUIBuy.updateBuy();
        }
    }

    public static class SellActLis implements ActionListener {
        String stockName;

        public SellActLis(String stockN) {
            stockName = stockN;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            FilingSell.sliderPosition = 0;
            GUISell.stockSell = stockName;
            FilingSell.createLabels();
            FilingSell.createWidget();
            FilingSell.createSellPanel(stockName);
            GUISell.updateSell();
        }
    }
}
