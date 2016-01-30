package client;

import filing.FilingMain;
import filing.FilingWidget;

import javax.swing.*;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

/**
 * Created by james on 1/30/2016.
 */
public class FilingBuy {
    public static JPanel getWidBase = new JPanel(), getCOH = new JPanel(), getAssets = new JPanel();
    public static JScrollPane widPane;
    static Font assetsHeading = new Font("Trebuchet MS", Font.PLAIN, 16);
    static Font buyHeading = new Font("Trebuchet MS", Font.PLAIN, 40);
    static int vScrollLoc = 0;

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
    public static void createLabels(){
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

    public static JPanel createBuyPanel(String stock) {
        JPanel base = new JPanel();
        base.setSize(425,700);
        base.setLocation(425,100);
        base.setLayout(null);
        if (stock == null) {
            return base;
        }
        else{
        JLabel stockN = new JLabel(stock);
            stockN.setSize(200,100);
            stockN.setLocation(5,5);
            stockN.setHorizontalAlignment(SwingConstants.CENTER);
            stockN.setVerticalAlignment(SwingConstants.CENTER);
            stockN.setFont(buyHeading);
            base.add(stockN);

            

        }
        return base;

    }

    public static class adListener implements AdjustmentListener {

        @Override
        public void adjustmentValueChanged(AdjustmentEvent e) {

            vScrollLoc = widPane.getVerticalScrollBar().getValue();
            System.out.println("VScrollLoc: " + vScrollLoc);
        }
    }
}
