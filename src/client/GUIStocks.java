package client;

import filing.FilingMain;
import filing.FilingWidget;

import javax.swing.*;
import java.awt.*;

/**
 * Created by james on 1/26/2016.
 */
public class GUIStocks {

    JPanel base,playCompP,playStockP,unused1,unused2,unused3,unused4;
    JLabel playCompLab,playStockLab;
    Font cHeading = new Font("Trebuchet MS", Font.PLAIN, 40);

    public JPanel guiStocks() {
        base = new JPanel();
        base.setBackground(new Color(213, 255, 213));
        base.setLayout(null);
        base.setSize(1275, 550);

        //Player Composite Panel
        playCompP = new JPanel();
        playCompP.setLayout(null);
        playCompP.setSize(1225, 200);
        playCompP.setLocation(50, 25);
        playCompP.setBackground(new Color(198, 240, 198));
        playCompLab = new JLabel("<Insert player's Composite Graph Here>");
        playCompLab.setFont(cHeading);
        playCompLab.setSize(1200, 200);
        playCompLab.setHorizontalAlignment(SwingConstants.CENTER);
        playCompLab.setVerticalAlignment(SwingConstants.CENTER);
        playCompLab.setLocation(0, 0);
        playCompP.add(playCompLab);
        base.add(playCompP);

        //Unused Widget 1
        unused1 = new JPanel();
        unused1.setLayout(null);
        unused1.setSize(287, 100);
        unused1.setLocation(50,250);
        unused1.setBackground(new Color(198, 240, 198));
//        nPTop5Widget = FilingWidget.nonPStockWidget(FilingOverview.calcTop5Stocks(FilingMain.getData()), 220, "Top 5 Stocks");
//        nPTop5WidgetP = new JScrollPane(nPTop5Widget);
//        nPTop5WidgetP.setSize(220, 200);
//        nPTop5WidgetP.setLocation(0, 0);
//        hotSP.add(nPTop5WidgetP);
        base.add(unused1);

        //Unused Widget 2
        unused2 = new JPanel();
        unused2.setLayout(null);
        unused2.setSize(287, 100);
        unused2.setLocation(362,250);
        unused2.setBackground(new Color(198, 240, 198));
//        nPTop5Widget = FilingWidget.nonPStockWidget(FilingOverview.calcTop5Stocks(FilingMain.getData()), 220, "Top 5 Stocks");
//        nPTop5WidgetP = new JScrollPane(nPTop5Widget);
//        nPTop5WidgetP.setSize(220, 200);
//        nPTop5WidgetP.setLocation(0, 0);
//        hotSP.add(nPTop5WidgetP);
        base.add(unused2);

        //Unused Widget 3
        unused3 = new JPanel();
        unused3.setLayout(null);
        unused3.setSize(287, 100);
        unused3.setLocation(674, 250);
        unused3.setBackground(new Color(198, 240, 198));
//        nPTop5Widget = FilingWidget.nonPStockWidget(FilingOverview.calcTop5Stocks(FilingMain.getData()), 220, "Top 5 Stocks");
//        nPTop5WidgetP = new JScrollPane(nPTop5Widget);
//        nPTop5WidgetP.setSize(220, 200);
//        nPTop5WidgetP.setLocation(0, 0);
//        hotSP.add(nPTop5WidgetP);
        base.add(unused3);

        //Unused Widget 4
        unused4 = new JPanel();
        unused4.setLayout(null);
        unused4.setSize(287, 100);
        unused4.setLocation(986, 250);
        unused4.setBackground(new Color(198, 240, 198));
//        nPTop5Widget = FilingWidget.nonPStockWidget(FilingOverview.calcTop5Stocks(FilingMain.getData()), 220, "Top 5 Stocks");
//        nPTop5WidgetP = new JScrollPane(nPTop5Widget);
//        nPTop5WidgetP.setSize(220, 200);
//        nPTop5WidgetP.setLocation(0, 0);
//        hotSP.add(nPTop5WidgetP);
        base.add(unused4);

        //Player Stock Panel
        playStockP = new JPanel();
        playStockP.setLayout(null);
        playStockP.setSize(1225, 150);
        playStockP.setLocation(50, 375);
        playStockP.setBackground(new Color(198, 240, 198));
        playStockLab = new JLabel("<Insert player's Stock Composite Here>");
        playStockLab.setFont(cHeading);
        playStockLab.setSize(1200, 150);
        playStockLab.setHorizontalAlignment(SwingConstants.CENTER);
        playStockLab.setVerticalAlignment(SwingConstants.CENTER);
        playStockLab.setLocation(0, 0);
        playStockP.add(playStockLab);
        base.add(playStockP);











        return base;
    }
    public static  void updateGUIStocks(){

    }
}
