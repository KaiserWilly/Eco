package client;

import filing.FilingMain;

import javax.swing.*;
import java.awt.*;

/**
 * Created 12/01/15
 * Software Development
 * TSA Conference, 2016
 * GUISell: Class containing code that renders Sell tab in GUI
 */
public class GUISell {
    static JPanel base, cOHP, assetsP, stocksP, sellWidBase;
    public static String stockSell = null;

    public JPanel sellPanel() {
        base = new JPanel();
        base.setBackground(new Color(213, 255, 213));
        base.setLayout(null);
        base.setSize(1275, 550);

        //Cash on Hand
        cOHP = FilingSell.getCOH;
        base.add(cOHP);

        //Assets
        assetsP = FilingSell.getAssets;
        base.add(assetsP);

        //Buy Panel
        stocksP = FilingSell.getBuyPanel;
        base.add(stocksP);

        //Attempt to get SellWidget
        if (FilingMain.getData() != null) {
            sellWidBase = FilingSell.getWidBase;
            base.add(sellWidBase);
        }


        //GUIBuy return DO NOT DELETE
        return base;
    }

    public static void updateSell() {
        base.remove(cOHP);
        base.remove(assetsP);
        base.remove(stocksP);
        try {
            base.remove(sellWidBase);
        } catch (NullPointerException e) {
            System.out.println("Non existent Widget!");
        }
        System.out.println("GUI Buy Updated!");

        //Cash on Hand
        cOHP = FilingSell.getCOH;
        base.add(cOHP);

        //Assets
        assetsP = FilingSell.getAssets;
        base.add(assetsP);

        //Buy Panel
        stocksP = FilingSell.getBuyPanel;
        base.add(stocksP);


        //BuyWidget Panel
        if (FilingMain.getData() != null) {
            sellWidBase = FilingSell.getWidBase;
            base.add(sellWidBase);
        }

        base.revalidate();
        base.repaint();
    }
}
