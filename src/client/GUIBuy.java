package client;

import javax.swing.*;
import java.awt.*;

/**
 * Created by james on 1/26/2016.
 */
public class GUIBuy {

    static JPanel base, cOHP, assetsP, stocksP;
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
        cOHP.setLocation(50, 25);
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
        assetsP.setSize(300, 50);
        assetsP.setLocation(275, 25);
        assetsP.setBackground(new Color(198, 240, 198));
        assetsLab = new JLabel("Assets: $" + Score.assetsFormatted + "   Net Change: $ " + NetChangeOfAssets.getNetChange());
        assetsLab.setFont(mHeading);
        assetsLab.setSize(300, 50);
        assetsLab.setHorizontalAlignment(SwingConstants.CENTER);
        assetsLab.setVerticalAlignment(SwingConstants.CENTER);
        assetsLab.setLocation(0, 0);
        assetsP.add(assetsLab);
        base.add(assetsP);

        //Composite Panel
        Font cHeading = new Font("Trebuchet MS", Font.PLAIN, 40);
        stocksP = new JPanel();
        stocksP.setLayout(null);
        stocksP.setSize(1225, 425);
        stocksP.setLocation(50, 100);
        stocksP.setBackground(new Color(198, 240, 198));
        stocksLab = new JLabel("<Insert Stock Widget Here>");
        stocksLab.setFont(cHeading);
        stocksLab.setSize(1225, 425);
        stocksLab.setHorizontalAlignment(SwingConstants.CENTER);
        stocksLab.setVerticalAlignment(SwingConstants.CENTER);
        stocksLab.setLocation(0, 0);
        stocksP.add(stocksLab);
        base.add(stocksP);

        return base;
    }
    public static void updateBuy() {
        base.remove(cOHP);
        base.remove(assetsP);

        cOHP = new JPanel();
        cOHP.setLayout(null);
        cOHP.setSize(200, 50);
        cOHP.setLocation(50, 25);
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
        Font mHeading = new Font("Trebuchet MS", Font.PLAIN, 16);
        assetsP = new JPanel();
        assetsP.setLayout(null);
        assetsP.setSize(300, 50);
        assetsP.setLocation(275, 25);
        assetsP.setBackground(new Color(198, 240, 198));
        assetsLab = new JLabel("Assets: $" + Score.assetsFormatted + "   Net Change: $ " + NetChangeOfAssets.getNetChange());
        assetsLab.setFont(mHeading);
        assetsLab.setSize(300, 50);
        assetsLab.setHorizontalAlignment(SwingConstants.CENTER);
        assetsLab.setVerticalAlignment(SwingConstants.CENTER);
        assetsLab.setLocation(0, 0);
        assetsP.add(assetsLab);
        base.add(assetsP);

        base.revalidate();
        base.repaint();
    }

}
