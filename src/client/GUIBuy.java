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
    public static String stockbuy = null;

    public JPanel buyPanel() {
        base = new JPanel();
        base.setBackground(new Color(213, 255, 213));
        base.setLayout(null);
        base.setSize(1275, 550);

        cOHP = FilingBuy.getCOH;
        base.add(cOHP);

        assetsP = FilingBuy.getAssets;
        base.add(assetsP);

        if (FilingMain.getData() != null) {
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

        cOHP = FilingBuy.getCOH;
        base.add(cOHP);

        assetsP = FilingBuy.getAssets;
        base.add(assetsP);

        //BuyWidget Panel
        if (FilingMain.getData() != null) {
            buyWidBase = FilingBuy.getWidBase;
            base.add(buyWidBase);
        }

        base.revalidate();
        base.repaint();
    }
}
