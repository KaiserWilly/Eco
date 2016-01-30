package client;

import filing.FilingMain;
import filing.FilingWidget;

import javax.swing.*;
import java.awt.*;

/**
 * Created by james on 1/26/2016.
 */
public class GUIBuy {

    static JPanel base, cOHP, assetsP, stocksP, buyWidBase;
    static JLabel cOHLab, assetsLab, stocksLab;
    static Font mHeading = new Font("Trebuchet MS", Font.PLAIN, 16);

    public JPanel buyPanel() {
        base = new JPanel();
        base.setBackground(new Color(213, 255, 213));
        base.setLayout(null);
        base.setSize(1275, 550);

        //Cash on Hand panel
        cOHP = new JPanel();
        cOHP.setLayout(null);
        cOHP.setSize(200, 50);
        cOHP.setLocation(500, 25);
        cOHP.setBackground(new Color(198, 240, 198));
        cOHLab = new JLabel("Cash On Hand: $" + Score.cashOnHandFormatted);
        cOHLab.setFont(mHeading);
        cOHLab.setSize(200, 50);
        cOHLab.setHorizontalAlignment(SwingConstants.CENTER);
        cOHLab.setVerticalAlignment(SwingConstants.CENTER);
        cOHLab.setLocation(0, 0);
        cOHP.add(cOHLab);
        base.add(cOHP);

        //Assets Panel

        assetsP = new JPanel();
        assetsP.setLayout(null);
        assetsP.setSize(500, 50);
        assetsP.setLocation(725, 25);
        assetsP.setBackground(new Color(198, 240, 198));
        assetsLab = new JLabel("Assets: $" + Score.assetsFormatted + "   Net Change: $ " + NetChangeOfAssets.netChangeFormatted);
        assetsLab.setFont(mHeading);
        assetsLab.setSize(500, 50);
        assetsLab.setHorizontalAlignment(SwingConstants.CENTER);
        assetsLab.setVerticalAlignment(SwingConstants.CENTER);
        assetsLab.setLocation(0, 0);
        assetsP.add(assetsLab);
        base.add(assetsP);

        //BuyWidget Panel
        if (FilingMain.getData() != null) {
//            int panelLoc = 20;
//            buyWidBase = new JPanel();
//            buyWidBase.setBackground(new Color(136, 172, 136));
//            buyWidBase.setSize(425, 500);
//            buyWidBase.setLocation(25, 25);
//            buyWidBase.setLayout(null);
//            JLabel title = new JLabel("Stocks Available");
//            title.setVerticalAlignment(SwingConstants.CENTER);
//            title.setHorizontalAlignment(SwingConstants.CENTER);
//            title.setSize(100, 20);
//            title.setLocation((425 / 2) - 50, 0);
//            title.setBackground(new Color(198, 240, 198, 0));
//            buyWidBase.add(title);
//            for (int playIndex = 0; playIndex < FilingMain.getData().length; playIndex++) {
//                JPanel wid = FilingWidget.buyWidget((String) FilingMain.getData()[playIndex][0], 425, 10);
//                wid.setLocation(0, panelLoc);
//                wid.setBackground(new Color(136, 172, 136));
//                buyWidBase.add(wid);
//                panelLoc = panelLoc + 10;
//            }
            buyWidBase = FilingBuy.getWidBase;
            base.add(buyWidBase);
        }


        //GUIBuy return DO NOT DELETE
        return base;
    }

    public static void updateBuy() {
        base.remove(cOHP);
        base.remove(assetsP);
        try {
            base.remove(buyWidBase);
        } catch (NullPointerException e) {
            System.out.println("Non existent Widget!");
        }
        System.out.println("GUI Buy Updated!");

        //Cash on Hand panel
        cOHP = new JPanel();
        cOHP.setLayout(null);
        cOHP.setSize(200, 50);
        cOHP.setLocation(500, 25);
        cOHP.setBackground(new Color(198, 240, 198));
        cOHLab = new JLabel("Cash On Hand: $" + Score.cashOnHandFormatted);
        cOHLab.setFont(mHeading);
        cOHLab.setSize(200, 50);
        cOHLab.setHorizontalAlignment(SwingConstants.CENTER);
        cOHLab.setVerticalAlignment(SwingConstants.CENTER);
        cOHLab.setLocation(0, 0);
        cOHP.add(cOHLab);
        base.add(cOHP);

        //Assets Panel
        assetsP = new JPanel();
        assetsP.setLayout(null);
        assetsP.setSize(500, 50);
        assetsP.setLocation(725, 25);
        assetsP.setBackground(new Color(198, 240, 198));
        assetsLab = new JLabel("Assets: $" + Score.assetsFormatted /*+"   Net Change: $ " + NetChangeOfAssets.netChangeFormateed*/);
        assetsLab.setFont(mHeading);
        assetsLab.setSize(500, 50);
        assetsLab.setHorizontalAlignment(SwingConstants.CENTER);
        assetsLab.setVerticalAlignment(SwingConstants.CENTER);
        assetsLab.setLocation(0, 0);
        assetsP.add(assetsLab);
        base.add(assetsP);

        //BuyWidget Panel
        if (FilingMain.getData() != null) {
//            int panelLoc = 20;
//            buyWidBase = new JPanel();
//            buyWidBase.setBackground(new Color(136, 172, 136));
//            buyWidBase.setSize(425, 500);
//            buyWidBase.setLocation(25, 25);
//            buyWidBase.setLayout(null);
//            JLabel title = new JLabel("Stocks Available");
//            title.setVerticalAlignment(SwingConstants.CENTER);
//            title.setHorizontalAlignment(SwingConstants.CENTER);
//            title.setSize(100, 20);
//            title.setLocation((425 / 2) - 50, 0);
//            title.setBackground(new Color(198, 240, 198, 0));
//            buyWidBase.add(title);
//            for (int playIndex = 0; playIndex < FilingMain.getData().length; playIndex++) {
//                JPanel wid = FilingWidget.buyWidget((String) FilingMain.getData()[playIndex][0], 425, 10);
//                wid.setLocation(0, panelLoc);
//                wid.setBackground(new Color(136, 172, 136));
//                buyWidBase.add(wid);
//                panelLoc = panelLoc + 10;
//            }
            buyWidBase = FilingBuy.getWidBase;
            base.add(buyWidBase);
        }

        base.revalidate();
        base.repaint();
    }
}
