package client;

import filing.FilingMain;
import filing.FilingWidget;

import javax.swing.*;
import java.awt.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by JD Isenhart on 9/15/2015.
 */
public class GUIOverview {
    static JPanel base, nameP, rankingMoneyP, compositeP, hotSP, badSP, playTopP, playBotP, rankingsP, nPTop5Widget, pTop5Widget,
            nPBot5Widget, pBot5Widget, rankWidget;
    static JLabel rankMonLab, rankPlayL, compLab;
    static JScrollPane nPTop5WidgetP, pTop5WidgetP, nPBot5WidgetP, pBot5WidgetP, rankWidgetP;

    static int test = 0;


    public JPanel OverviewPanel() {
        base = new JPanel();
        base.setBackground(new Color(213, 255, 213));
        base.setLayout(null);
        base.setSize(1275, 550);

        //Name Panel
        Font sHeading = new Font("Trebuchet MS", Font.PLAIN, 20);
        nameP = new JPanel();
        nameP.setLayout(null);
        nameP.setSize(200, 50);
        nameP.setLocation(50, 25);
        nameP.setBackground(new Color(198, 240, 198));
        JLabel name = null;
        try {
            name = new JLabel(InetAddress.getLocalHost().getHostName());
        } catch (UnknownHostException e) {
            name = new JLabel("<Name not found>");
        }
        name.setSize(200, 50);
        name.setLocation(0, 0);
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setVerticalAlignment(SwingConstants.CENTER);
        name.setFont(sHeading);
        nameP.add(name);
        base.add(nameP);

//Ranking Panel
        Font mHeading = new Font("Trebuchet MS", Font.PLAIN, 16);
        rankingMoneyP = new JPanel();
        rankingMoneyP.setLayout(null);
        rankingMoneyP.setSize(400, 50);
        rankingMoneyP.setLocation(275, 25);
        rankingMoneyP.setBackground(new Color(198, 240, 198));
        rankMonLab = new JLabel("Ranking: NA   Money: NA   Assets: NA");
        rankMonLab.setFont(mHeading);
        rankMonLab.setSize(300, 50);
        rankMonLab.setHorizontalAlignment(SwingConstants.CENTER);
        rankMonLab.setVerticalAlignment(SwingConstants.CENTER);
        rankMonLab.setLocation(0, 0);
        rankingMoneyP.add(rankMonLab);
        base.add(rankingMoneyP);

        //Composite Panel
        compositeP = new JPanel();
        compositeP.setLayout(null);
        compositeP.setSize(1225, 250);
        compositeP.setLocation(50, 100);
        compositeP.setBackground(new Color(198, 240, 198));
        compositeP.add(new ChartOverview(StockHistory.getCompositeHistory()));
        base.add(compositeP);

        //Top 5 Stocks Overall
        hotSP = new JPanel();
        hotSP.setLayout(null);
        hotSP.setSize(225, 175);
        hotSP.setLocation(50, 375);
        hotSP.setBackground(new Color(198, 240, 198));
        nPTop5Widget = FilingWidget.nonPStockWidget(FilingOverview.calcTop5Stocks(FilingMain.getData()), 225, "Top 5 Stocks");
        nPTop5WidgetP = new JScrollPane(nPTop5Widget);
        nPTop5WidgetP.setSize(225, 175);
        nPTop5WidgetP.setLocation(0, 0);
        hotSP.add(nPTop5WidgetP);
        base.add(hotSP);


        //Player's top 5 Stocks
        playTopP = new JPanel();
        playTopP.setLayout(null);
        playTopP.setSize(225, 175);
        playTopP.setLocation(300, 375);
        playTopP.setBackground(new Color(198, 240, 198));
        pTop5Widget = FilingWidget.playStockWidget(FilingOverview.calcTop5Stocks(FilingMain.getData()), 225, "Your Top 5 Stocks");
        pTop5WidgetP = new JScrollPane(pTop5Widget);
        pTop5WidgetP.setSize(225, 175);
        pTop5WidgetP.setLocation(0, 0);
        playTopP.add(pTop5WidgetP);
        base.add(playTopP);


        //Worst 5 Stocks Overall
        badSP = new JPanel();
        badSP.setLayout(null);
        badSP.setSize(225, 175);
        badSP.setLocation(550, 375);
        badSP.setBackground(new Color(198, 240, 198));
        nPBot5Widget = FilingWidget.nonPStockWidget(FilingOverview.calcWorst5Stocks(FilingMain.getData()), 225, "Worst 5 Stocks");
        nPBot5WidgetP = new JScrollPane(nPBot5Widget);
        nPBot5WidgetP.setSize(225, 175);
        nPBot5WidgetP.setLocation(0, 0);
        badSP.add(nPBot5WidgetP);
        base.add(badSP);

        //Player's worst 5 stocks
        playBotP = new JPanel();
        playBotP.setLayout(null);
        playBotP.setSize(225, 175);
        playBotP.setLocation(800, 375);
        playBotP.setBackground(new Color(198, 240, 198));
        pBot5Widget = FilingWidget.playStockWidget(FilingOverview.calcWorst5Stocks(FilingMain.getData()), 225, "Your Worst 5 Stocks");
        pBot5WidgetP = new JScrollPane(pBot5Widget);
        pBot5WidgetP.setSize(225, 175);
        pBot5WidgetP.setLocation(0, 0);
        playBotP.add(pBot5WidgetP);
        base.add(playBotP);

        //Ranking Panel
        rankingsP = new JPanel();
        rankingsP.setLayout(null);
        rankingsP.setSize(225, 175);
        rankingsP.setLocation(1050, 375);
        rankingsP.setBackground(new Color(198, 240, 198));
        Object[][] rankings = new Object[][]{
                {"Daniel", "23,300"},
                {"JD", "22,600"},
                {"Toast", "19,900"},
                {"Will", "16,300"},
                {"Brody", "16,000"}
        };
        rankWidget = FilingWidget.makeRankingWidget(rankings, 225);
        rankWidgetP = new JScrollPane(rankWidget);
        rankWidgetP.setSize(225, 175);
        rankWidgetP.setLocation(0, 0);
        rankingsP.add(rankWidgetP);
        base.add(rankingsP);

        return base;
    }

    public static void updateOverview() {
        base.remove(hotSP);
        base.remove(badSP);
        base.remove(compositeP);
        base.remove(rankingMoneyP);
        base.remove(playTopP);
        base.remove(playBotP);
        base.remove(rankingsP);

        //Ranking Panel
        Font mHeading = new Font("Trebuchet MS", Font.PLAIN, 16);
        rankingMoneyP = new JPanel();
        rankingMoneyP.setLayout(null);
        rankingMoneyP.setSize(300, 50);
        rankingMoneyP.setLocation(275, 25);
        rankingMoneyP.setBackground(new Color(198, 240, 198));
        rankMonLab = new JLabel("Ranking: NA   Money: $" + Score.getCashOnHand()+ "  Assets: $" + Score.assetsFormatted);
        rankMonLab.setFont(mHeading);
        rankMonLab.setSize(300, 50);
        rankMonLab.setHorizontalAlignment(SwingConstants.CENTER);
        rankMonLab.setVerticalAlignment(SwingConstants.CENTER);
        rankMonLab.setLocation(0, 0);
        rankingMoneyP.add(rankMonLab);
        base.add(rankingMoneyP);

        //Composite Panel
        compositeP = new JPanel();
        compositeP.setLayout(null);
        compositeP.setSize(1225, 250);
        compositeP.setLocation(50, 100);
        compositeP.setBackground(new Color(198, 240, 198));
        compositeP.add(new ChartOverview(StockHistory.getCompositeHistory()));
        base.add(compositeP);

        //Top 5 Stocks Overall
        hotSP = new JPanel();
        hotSP.setLayout(null);
        hotSP.setSize(225, 175);
        hotSP.setLocation(50, 375);
        hotSP.setBackground(new Color(198, 240, 198));
        nPTop5Widget = FilingWidget.nonPStockWidget(FilingOverview.calcTop5Stocks(FilingMain.getData()), 225, "Top 5 Stocks");
        nPTop5WidgetP = new JScrollPane(nPTop5Widget);
        nPTop5WidgetP.setSize(225, 175);
        nPTop5WidgetP.setLocation(0, 0);
        hotSP.add(nPTop5WidgetP);
        base.add(hotSP);


        //Player's top 5 Stocks
        playTopP = new JPanel();
        playTopP.setLayout(null);
        playTopP.setSize(225, 175);
        playTopP.setLocation(300, 375);
        playTopP.setBackground(new Color(198, 240, 198));
        pTop5Widget = FilingWidget.playStockWidget(FilingOverview.calcTop5Stocks(FilingMain.getData()), 225, "Your Top 5 Stocks");
        pTop5WidgetP = new JScrollPane(pTop5Widget);
        pTop5WidgetP.setSize(225, 175);
        pTop5WidgetP.setLocation(0, 0);
        playTopP.add(pTop5WidgetP);
        base.add(playTopP);


        //Worst 5 Stocks Overall
        badSP = new JPanel();
        badSP.setLayout(null);
        badSP.setSize(225, 175);
        badSP.setLocation(550, 375);
        badSP.setBackground(new Color(198, 240, 198));
        nPBot5Widget = FilingWidget.nonPStockWidget(FilingOverview.calcWorst5Stocks(FilingMain.getData()), 225, "Worst 5 Stocks");
        nPBot5WidgetP = new JScrollPane(nPBot5Widget);
        nPBot5WidgetP.setSize(225, 175);
        nPBot5WidgetP.setLocation(0, 0);
        badSP.add(nPBot5WidgetP);
        base.add(badSP);

        //Player's worst 5 stocks
        playBotP = new JPanel();
        playBotP.setLayout(null);
        playBotP.setSize(225, 175);
        playBotP.setLocation(800, 375);
        playBotP.setBackground(new Color(198, 240, 198));
        pBot5Widget = FilingWidget.playStockWidget(FilingOverview.calcWorst5Stocks(FilingMain.getData()), 225, "Your Worst 5 Stocks");
        pBot5WidgetP = new JScrollPane(pBot5Widget);
        pBot5WidgetP.setSize(225, 175);
        pBot5WidgetP.setLocation(0, 0);
        playBotP.add(pBot5WidgetP);
        base.add(playBotP);

        //Ranking Panel
        rankingsP = new JPanel();
        rankingsP.setLayout(null);
        rankingsP.setSize(225, 175);
        rankingsP.setLocation(1050, 375);
        rankingsP.setBackground(new Color(198, 240, 198));
        Object[][] rankings = new Object[][]{
                {"Daniel", "23,300"},
                {"JD", "22,600"},
                {"Toast", test},
                {"Will", "16,300"},
                {"Brody", "16,000"}
        };

        test++;

        rankWidget = FilingWidget.makeRankingWidget(rankings, 300);
        rankWidgetP = new JScrollPane(rankWidget);
        rankWidgetP.setSize(225, 175);
        rankWidgetP.setLocation(0, 0);
        rankingsP.add(rankWidgetP);
        base.add(rankingsP);


        base.revalidate();
        base.repaint();

        //System.out.println("GUI.Overview Updated!");

    }
}
