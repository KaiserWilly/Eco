package client;

import filing.FilingMain;

import javax.swing.*;
import java.awt.*;

/**
 * Created by james on 1/26/2016.
 */
public class GUISell {
    static JPanel base, cOHP, assetsP, stocksP, sellWidBase;
    static JLabel cOHLab, assetsLab, stocksLab;
    static Font mHeading = new Font("Trebuchet MS", Font.PLAIN, 16);
    public static String stockSell = null;

    public JPanel sellPanel() {
        base = new JPanel();
        base.setBackground(new Color(213, 255, 213));
        base.setLayout(null);
        base.setSize(1275, 550);

        cOHP = FilingSell.getCOH;
        base.add(cOHP);

        assetsP = FilingSell.getAssets;
        base.add(assetsP);

        stocksP = FilingSell.getBuyPanel;
        base.add(stocksP);

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

        cOHP = FilingSell.getCOH;
        base.add(cOHP);

        assetsP = FilingSell.getAssets;
        base.add(assetsP);

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
