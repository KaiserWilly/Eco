package client;

import filing.FilingMain;
import filing.FilingWidget;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created 12/11/15
 * Software Development
 * TSA Conference, 2016
 * FilingBuy: Class containing code creating Buy tab GUI components
 */

public class FilingBuy {
    static JPanel base;
    public static JPanel getWidBase = new JPanel(), getCOH = new JPanel(), getAssets = new JPanel(), getBuyPanel = new JPanel();
    static Font assetsHeading = new Font("Trebuchet MS", Font.PLAIN, 16);
    static Font buyHeading = new Font("Tahoma", Font.BOLD, 56);
    public static int sliderPosition = 0;
    static JSlider slider;
    static JLabel slideValue;
    static JButton buyButton;
    static String stockName;
    static Font nameF = new Font("Tahoma", Font.BOLD, 10);

    public static void createWidget() {
        if (FilingMain.getData() != null) {
            int panelLoc = 20;
            JPanel buyWidBase = new JPanel();
            buyWidBase.setBackground(new Color(198, 240, 198));
            buyWidBase.setSize(425, 500);
            buyWidBase.setLocation(25, 25);
            buyWidBase.setLayout(null);

            //Name Title
            JLabel name = new JLabel("Stock Name");
            name.setSize(100, 20);
            name.setVerticalAlignment(SwingConstants.CENTER);
            name.setHorizontalAlignment(SwingConstants.CENTER);
            name.setLocation(0, 0);
            name.setFont(nameF);
            buyWidBase.add(name);

            //%Change Title
            JLabel perChange = new JLabel("% Chg. over 60s");
            perChange.setSize(100, 20);
            perChange.setVerticalAlignment(SwingConstants.CENTER);
            perChange.setHorizontalAlignment(SwingConstants.CENTER);
            perChange.setLocation(100, 0);
            perChange.setFont(nameF);
            buyWidBase.add(perChange);

            //Price of stock
            JLabel price = new JLabel("Price of Stock");
            price.setSize(100, 20);
            price.setVerticalAlignment(SwingConstants.CENTER);
            price.setHorizontalAlignment(SwingConstants.CENTER);
            price.setLocation(200, 0);
            price.setFont(nameF);
            buyWidBase.add(price);

            //Add BuyWidget
            for (int playIndex = 0; playIndex < FilingMain.getData().length; playIndex++) {
                JPanel wid = FilingWidget.buyWidget((String) FilingMain.getData()[playIndex][0], 425, 10);
                wid.setLocation(0, panelLoc);
                wid.setBackground(new Color(198, 240, 198));
                buyWidBase.add(wid);
                panelLoc = panelLoc + 10;
            }
            getWidBase = buyWidBase;
        }
    }

    public static void createLabels() {
        //Cash on Hand panel
        JPanel cOHP = new JPanel();
        cOHP.setLayout(null);
        cOHP.setSize(300, 50);
        cOHP.setLocation(500, 25);
        cOHP.setBackground(new Color(198, 240, 198));
        JLabel cOHLab = new JLabel("Cash On Hand: $" + Score.cashOnHandFormatted);
        cOHLab.setFont(assetsHeading);
        cOHLab.setSize(300, 50);
        cOHLab.setHorizontalAlignment(SwingConstants.CENTER);
        cOHLab.setVerticalAlignment(SwingConstants.CENTER);
        cOHLab.setLocation(0, 0);
        cOHP.add(cOHLab);
        getCOH = cOHP;

        //Assets Panel
        JPanel assetsP = new JPanel();
        assetsP.setLayout(null);
        assetsP.setSize(400, 50);
        assetsP.setLocation(825, 25);
        assetsP.setBackground(new Color(198, 240, 198));
        JLabel assetsLab = new JLabel("Assets: $" + Score.assetsFormatted + "   Net Change: $ " + NetChangeOfAssets.netChangeFormatted);
        assetsLab.setFont(assetsHeading);
        assetsLab.setSize(400, 50);
        assetsLab.setHorizontalAlignment(SwingConstants.CENTER);
        assetsLab.setVerticalAlignment(SwingConstants.CENTER);
        assetsLab.setLocation(0, 0);
        assetsP.add(assetsLab);
        getAssets = assetsP;
    }

    public static void createBuyPanel(String stock) {
        stockName = stock;
        base = new JPanel();
        base.setSize(725, 425);
        base.setLocation(500, 100);
        base.setBackground(new Color(213, 255, 213));
        base.setLayout(null);
        if (stock == null) {
            getBuyPanel = base;
        } else {
            base.setBackground(new Color(198, 240, 198));

            //Stock Name
            JLabel stockN = new JLabel(stock);
            stockN.setSize(200, 100);
            stockN.setLocation(5, 0);
            stockN.setBackground(Color.BLUE);
            stockN.setHorizontalAlignment(SwingConstants.LEFT);
            stockN.setVerticalAlignment(SwingConstants.TOP);
            stockN.setFont(buyHeading);
            base.add(stockN);

            //%Change over 60s
            JLabel stockP = new JLabel("$" + String.valueOf(filingStocks.getPrice(stock)));
            stockP.setSize(300, 100);
            stockP.setLocation(423, 0);
            stockP.setBackground(Color.BLUE);
            stockP.setHorizontalAlignment(SwingConstants.RIGHT);
            stockP.setVerticalAlignment(SwingConstants.TOP);
            stockP.setFont(buyHeading);
            base.add(stockP);

            //history graph for stock
            JPanel compositeP = new JPanel();
            compositeP.setLayout(null);
            compositeP.setSize(725, 200);
            compositeP.setLocation(0, 100);
            compositeP.setBackground(new Color(198, 240, 198));
            compositeP.add(new ChartBuySell(StockHistory.getStockHistory(stockName)));
            base.add(compositeP);

            //Slider
            if (Math.floor(Score.getCashOnHand() / filingStocks.getPrice(stockName)) < 1000) {
                slider = new JSlider(JSlider.HORIZONTAL, 0, (int) Math.floor(Score.getCashOnHand() / filingStocks.getPrice(stockName)), 0);
            } else {
                slider = new JSlider(JSlider.HORIZONTAL, 0, 1000, 0);
            }
            slider.addChangeListener(new slidLis());
            slider.setValue(sliderPosition);
            slider.setSize(600, 50);
            slider.setLocation(0, 300);
            slider.setBackground(new Color(198, 240, 198));
            base.add(slider);

            //Display of slide values
            slideValue = new JLabel(sliderPosition + " shares");
            slideValue.setSize(125, 50);
            slideValue.setFont(assetsHeading);
            slideValue.setLocation(600, 300);
            base.add(slideValue);

            //Buy shares
            buyButton = new JButton("Buy Shares");
            buyButton.setSize(100, 50);
            buyButton.setLocation(625, 375);
            buyButton.addActionListener(new butLis(stock));
            base.add(buyButton);

            getBuyPanel = base;
        }

    }

    public static class slidLis implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            sliderPosition = slider.getValue();
            base.remove(slideValue);
            slideValue = new JLabel(sliderPosition + " shares");
            slideValue.setSize(125, 50);
            slideValue.setFont(assetsHeading);
            slideValue.setLocation(600, 300);
            base.add(slideValue);
            base.revalidate();
            base.repaint();
        }
    }

    public static class butLis implements ActionListener {

        public butLis(String stockN) {
            stockName = stockN;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //Register buy
            Score.buyOrSellAssets(stockName, sliderPosition);
            sliderPosition = 0;
            base.remove(slideValue);
            slideValue = new JLabel(sliderPosition + " shares");
            slideValue.setSize(125, 50);
            slideValue.setFont(assetsHeading);
            slideValue.setLocation(600, 300);
            base.add(slideValue);
            base.revalidate();
            base.repaint();
        }
    }

}
