package client;

import filing.FilingMain;
import filing.FilingWidget;

import javax.swing.*;
import java.awt.*;

/**
 * Created by james on 1/30/2016.
 */
public class FilingBuy {
    public static JPanel getWidBase,getCOH,getAssets;

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
        cOHLab.setFont(mHeading);
        cOHLab.setSize(200, 50);
        cOHLab.setHorizontalAlignment(SwingConstants.CENTER);
        cOHLab.setVerticalAlignment(SwingConstants.CENTER);
        cOHLab.setLocation(0, 0);
        cOHP.add(cOHLab);
        base.add(cOHP);

        //Assets Panel
        JPanel assetsP = new JPanel();
        assetsP.setLayout(null);
        assetsP.setSize(500, 50);
        assetsP.setLocation(725, 25);
        assetsP.setBackground(new Color(198, 240, 198));
        JLabel assetsLab = new JLabel("Assets: $" + Score.assetsFormatted /*+"   Net Change: $ " + NetChangeOfAssets.netChangeFormateed*/);
        assetsLab.setFont(mHeading);
        assetsLab.setSize(500, 50);
        assetsLab.setHorizontalAlignment(SwingConstants.CENTER);
        assetsLab.setVerticalAlignment(SwingConstants.CENTER);
        assetsLab.setLocation(0, 0);
        assetsP.add(assetsLab);
        base.add(assetsP);
    }
}
