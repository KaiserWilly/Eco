package client;

import filing.FilingMain;

import javax.swing.*;
import java.awt.*;

/**
 * Created 11/12/15
 * Software Development
 * TSA Conference, 2016
 * FilingBuy: Class containing code that renders the Buy tab in GUI
 */
public class GUIBuy {

    static JPanel base, cOHP, assetsP, stocksP, buyWidBase;
    public static String stockbuy = null;

    public JPanel buyPanel() {
        base = new JPanel();
        base.setBackground(new Color(213, 255, 213));
        base.setLayout(null);
        base.setSize(1275, 550);

        //Add Cash on Hand
        cOHP = FilingBuy.getCOH;
        base.add(cOHP);

        //Add Assets Panel
        assetsP = FilingBuy.getAssets;
        base.add(assetsP);

        //Add Stock Panel
        stocksP = FilingBuy.getBuyPanel;
        base.add(stocksP);

        //Attempt to create BuyWidget
        if (FilingMain.getData() != null) {
            buyWidBase = FilingBuy.getWidBase;
            base.add(buyWidBase);
        }


        //GUIBuy return DO NOT DELETE
        return base;
    }

    public static void updateBuy() {
        //Remove components to update
        base.remove(cOHP);
        base.remove(assetsP);
        base.remove(stocksP);
        try {
            base.remove(buyWidBase);
        } catch (NullPointerException e) {
            System.out.println("Non existent Widget!");
        }
        System.out.println("GUI Buy Updated!");


        //Add Cash on Hand
        cOHP = FilingBuy.getCOH;
        base.add(cOHP);

        //Add Assets Panel
        assetsP = FilingBuy.getAssets;
        base.add(assetsP);

        //Add Stock Panel
        stocksP = FilingBuy.getBuyPanel;
        base.add(stocksP);


        //BuyWidget Panel
        if (FilingMain.getData() != null) {
            buyWidBase = FilingBuy.getWidBase;
            base.add(buyWidBase);
        }

        base.revalidate();
        base.repaint();
    }
}
