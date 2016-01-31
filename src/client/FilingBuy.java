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
 * Created by james on 1/30/2016.
 */
public class FilingBuy {
    static JPanel base;
    public static JPanel getWidBase = new JPanel(), getCOH = new JPanel(), getAssets = new JPanel(), getBuyPanel = new JPanel();
    public static JScrollPane widPane;
    static Font assetsHeading = new Font("Trebuchet MS", Font.PLAIN, 16);
    static Font buyHeading = new Font("Tahoma", Font.BOLD, 56);
    public static int sliderPosition = 0;
    static JSlider slider;
    static JLabel slideValue;
    static JButton buyButton;

    public static void createWidget() {
        if (FilingMain.getData() != null) {
            int panelLoc = 20;
            JPanel buyWidBase = new JPanel();
            buyWidBase.setBackground(new Color(136, 172, 136));
            buyWidBase.setSize(425, 500);
            buyWidBase.setLocation(25, 25);
            buyWidBase.setLayout(null);
            JLabel title = new JLabel("Stocks Available");
            title.setVerticalAlignment(SwingConstants.CENTER);
            title.setHorizontalAlignment(SwingConstants.CENTER);
            title.setSize(100, 20);
            title.setLocation((425 / 2) - 50, 0);
            title.setBackground(new Color(198, 240, 198, 0));
            buyWidBase.add(title);
            for (int playIndex = 0; playIndex < FilingMain.getData().length; playIndex++) {
                JPanel wid = FilingWidget.buyWidget((String) FilingMain.getData()[playIndex][0], 425, 10);
                wid.setLocation(0, panelLoc);
                wid.setBackground(new Color(136, 172, 136));
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
        cOHP.setSize(200, 50);
        cOHP.setLocation(500, 25);
        cOHP.setBackground(new Color(198, 240, 198));
        JLabel cOHLab = new JLabel("Cash On Hand: $" + Score.cashOnHandFormatted);
        cOHLab.setFont(assetsHeading);
        cOHLab.setSize(200, 50);
        cOHLab.setHorizontalAlignment(SwingConstants.CENTER);
        cOHLab.setVerticalAlignment(SwingConstants.CENTER);
        cOHLab.setLocation(0, 0);
        cOHP.add(cOHLab);
        getCOH = cOHP;

        //Assets Panel
        JPanel assetsP = new JPanel();
        assetsP.setLayout(null);
        assetsP.setSize(500, 50);
        assetsP.setLocation(725, 25);
        assetsP.setBackground(new Color(198, 240, 198));
        JLabel assetsLab = new JLabel("Assets: $" + Score.assetsFormatted /*+"   Net Change: $ " + NetChangeOfAssets.netChangeFormateed*/);
        assetsLab.setFont(assetsHeading);
        assetsLab.setSize(500, 50);
        assetsLab.setHorizontalAlignment(SwingConstants.CENTER);
        assetsLab.setVerticalAlignment(SwingConstants.CENTER);
        assetsLab.setLocation(0, 0);
        assetsP.add(assetsLab);
        getAssets = assetsP;
    }

    public static void createBuyPanel(String stock) {
        base = new JPanel();
        base.setSize(725, 425);
        base.setLocation(500, 100);
        base.setBackground(new Color(213, 255, 213));
        base.setLayout(null);
        if (stock == null) {
            getBuyPanel = base;
        } else {
            base.setBackground(new Color(146, 185, 146));
            JLabel stockN = new JLabel(stock);
            stockN.setSize(200, 100);
            stockN.setLocation(5, 0);
            stockN.setBackground(Color.BLUE);
            stockN.setHorizontalAlignment(SwingConstants.LEFT);
            stockN.setVerticalAlignment(SwingConstants.TOP);
            stockN.setFont(buyHeading);
            base.add(stockN);

            JLabel stockP = new JLabel("$" + String.valueOf(FilingStocks.getPrice(stock)));
            stockP.setSize(300, 100);
            stockP.setLocation(423, 0);
            stockP.setBackground(Color.BLUE);
            stockP.setHorizontalAlignment(SwingConstants.RIGHT);
            stockP.setVerticalAlignment(SwingConstants.TOP);
            stockP.setFont(buyHeading);
            base.add(stockP);

            JPanel compositeP = new JPanel();
            compositeP.setLayout(null);
            compositeP.setSize(725, 200);
            compositeP.setLocation(0, 100);
            compositeP.setBackground(new Color(198, 240, 198));
            compositeP.add(new ChartBuySell(StockHistory.getCompositeHistory()));
            base.add(compositeP);

            slider = new JSlider(JSlider.HORIZONTAL, 0, 1000, 0);
            slider.addChangeListener(new slidLis());
            slider.setValue(sliderPosition);
            slider.setSize(600, 50);
            slider.setLocation(0, 300);
            slider.setBackground(new Color(146, 185, 146));
            base.add(slider);

            slideValue = new JLabel(sliderPosition + " shares");
            slideValue.setSize(125, 50);
            slideValue.setFont(assetsHeading);
            slideValue.setLocation(600, 300);
            base.add(slideValue);

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
        String stockName;

        public butLis(String stockN) {
            stockName = stockN;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //Register buy
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
