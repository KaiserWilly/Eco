package client;

import filing.FilingMain;
import filing.FilingWidget;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.geom.Arc2D;

/**
 * Created by james on 1/26/2016.
 */
public class GUIPlayer {

    static JPanel base, playCompP, rankingMoneyP, playerT;
    Font cHeading = new Font("Trebuchet MS", Font.PLAIN, 40);

    public JPanel guiStocks() {
        base = new JPanel();
        base.setBackground(new Color(213, 255, 213));
        base.setLayout(null);
        base.setSize(1275, 550);

        //Assets Desc.
        Font mHeading = new Font("Trebuchet MS", Font.PLAIN, 16);
        rankingMoneyP = new JPanel();
        rankingMoneyP.setLayout(null);
        rankingMoneyP.setSize(400, 50);
        rankingMoneyP.setLocation(25, 25);
        rankingMoneyP.setBackground(new Color(198, 240, 198));
        JLabel rankMonLab = new JLabel("Money: $" + Score.cashOnHandFormatted + "  Assets: $" + Score.assetsFormatted);
        rankMonLab.setFont(mHeading);
        rankMonLab.setSize(400, 50);
        rankMonLab.setHorizontalAlignment(SwingConstants.CENTER);
        rankMonLab.setVerticalAlignment(SwingConstants.CENTER);
        rankMonLab.setLocation(0, 0);
        rankingMoneyP.add(rankMonLab);
        base.add(rankingMoneyP);

        //Player Composite Panel
        playCompP = new JPanel();
        playCompP.setLayout(null);
        playCompP.setSize(1225, 250);
        playCompP.setLocation(50, 100);
        playCompP.setBackground(new Color(198, 240, 198));
        playCompP.add(new ChartOverview(StockHistory.getCompositeHistory()));
        base.add(playCompP);

        //Player Stock Table
        playerT = FilingPlayer.playerTable;
        base.add(playerT);


        return base;
    }

    public static void updateGUIStocks() {
        base.remove(playCompP);
        base.remove(rankingMoneyP);
        base.remove(playerT);
        //Assets Desc.
        Font mHeading = new Font("Trebuchet MS", Font.PLAIN, 16);
        rankingMoneyP = new JPanel();
        rankingMoneyP.setLayout(null);
        rankingMoneyP.setSize(400, 50);
        rankingMoneyP.setLocation(25, 25);
        rankingMoneyP.setBackground(new Color(198, 240, 198));
        JLabel rankMonLab = new JLabel("Money: $" + Score.cashOnHandFormatted + "  Assets: $" + Score.assetsFormatted);
        rankMonLab.setFont(mHeading);
        rankMonLab.setSize(400, 50);
        rankMonLab.setHorizontalAlignment(SwingConstants.CENTER);
        rankMonLab.setVerticalAlignment(SwingConstants.CENTER);
        rankMonLab.setLocation(0, 0);
        rankingMoneyP.add(rankMonLab);
        base.add(rankingMoneyP);

        //Player Composite Panel
        playCompP = new JPanel();
        playCompP.setLayout(null);
        playCompP.setSize(1225, 250);
        playCompP.setLocation(50, 100);
        playCompP.setBackground(new Color(198, 240, 198));
        playCompP.add(new ChartOverview(StockHistory.getCompositeHistory()));
        base.add(playCompP);

        //Player Stock Table
        playerT = FilingPlayer.playerTable;
        base.add(playerT);

        base.revalidate();
        base.repaint();
    }
}
