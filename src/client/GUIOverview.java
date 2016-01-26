package client;

import Filing.FilingMain;
import Filing.FilingWidget;

import javax.swing.*;
import java.awt.*;

/**
 * Created by JD Isenhart on 9/15/2015.
 */
public class GUIOverview {
    static JPanel base, nameP, rankingMoneyP, compositeP, hotSP, badSP, playTopP, playBotP, rankingsP, nPTop5Widget, pTop5Widget,
            nPBot5Widget, pBot5Widget;
    static JLabel rankMonLab, compLab;
    static JScrollPane nPTop5WidgetP, pTop5WidgetP, nPBot5WidgetP, pBot5WidgetP;


    public JPanel OverviewPanel() {
        base = new JPanel();
        base.setBackground(Color.WHITE);

        //Name Panel
        Font sHeading = new Font("Trebuchet MS", Font.PLAIN, 20);
        nameP = new JPanel();
        nameP.setLayout(null);
        nameP.setPreferredSize(new Dimension(200, 50));
        nameP.setMaximumSize(new Dimension(200, 50));
        nameP.setBackground(new Color(198, 240, 198));
        JLabel name = new JLabel("<Insert Name>");
        name.setSize(200, 50);
        name.setLocation(0, 0);
        name.setFont(sHeading);
        nameP.add(name);
        base.add(nameP);

        //Ranking Panel
        Font mHeading = new Font("Trebuchet MS", Font.PLAIN, 16);
        rankingMoneyP = new JPanel();
        rankingMoneyP.setLayout(null);
        rankingMoneyP.setPreferredSize(new Dimension(300, 50));
        rankingMoneyP.setMaximumSize(new Dimension(300, 50));
        rankingMoneyP.setBackground(new Color(198, 240, 198));
        rankMonLab = new JLabel("Ranking: NA   Money: NA   Assets: NA");
        rankMonLab.setFont(mHeading);
        rankMonLab.setSize(300, 50);
        rankMonLab.setLocation(0, 0);
        rankingMoneyP.add(rankMonLab);
        base.add(rankingMoneyP);

        //Composite Panel
        Font cHeading = new Font("Trebuchet MS", Font.PLAIN, 40);
        compositeP = new JPanel();
        compositeP.setLayout(null);
        compositeP.setPreferredSize(new Dimension(1377, 300));
        compositeP.setMaximumSize(new Dimension(1377, 300));
        compositeP.setBackground(new Color(198, 240, 198));
        compLab = new JLabel("<Insert Composite Graph Here>");
        compLab.setFont(cHeading);
        compLab.setSize(1377, 300);
        compLab.setLocation(0, 0);
        compositeP.add(compLab);
        base.add(compositeP);

        //Top 5 Stocks Overall
        hotSP = new JPanel();
        hotSP.setLayout(null);
        hotSP.setPreferredSize(new Dimension(250, 300));
        hotSP.setMaximumSize(new Dimension(250, 300));
        hotSP.setBackground(new Color(198, 240, 198));
        nPTop5Widget = FilingWidget.nonPStockWidget(FilingOverview.calcTop5Stocks(FilingMain.getData()), 250, "Top 5 Stocks");
        nPTop5WidgetP = new JScrollPane(nPTop5Widget);
        nPTop5WidgetP.setSize(250, 300);
        nPTop5WidgetP.setLocation(0, 0);
        hotSP.add(nPTop5WidgetP);
        base.add(hotSP);

        //Worst 5 Stocks Overall
        badSP = new JPanel();
        badSP.setLayout(null);
        badSP.setPreferredSize(new Dimension(250, 300));
        badSP.setMaximumSize(new Dimension(250, 300));
        badSP.setBackground(new Color(198, 240, 198));
        nPBot5Widget = FilingWidget.nonPStockWidget(FilingOverview.calcWorst5Stocks(FilingMain.getData()), 250, "Worst 5 Stocks");
        nPBot5WidgetP = new JScrollPane(nPBot5Widget);
        nPBot5WidgetP.setMinimumSize(new Dimension(250, 300));
        nPBot5WidgetP.setPreferredSize(new Dimension(250, 300));
        nPBot5WidgetP.setLocation(0, 0);
        badSP.add(nPBot5WidgetP);
        base.add(badSP);

        //Player's top 5 Stocks
        playTopP = new JPanel();
        playTopP.setLayout(new GridBagLayout());
        playTopP.setPreferredSize(new Dimension(250, 300));
        playTopP.setMaximumSize(new Dimension(250, 300));
        playTopP.setBackground(new Color(198, 240, 198));
        pTop5Widget = FilingWidget.playStockWidget(FilingOverview.calcTop5Stocks(FilingMain.getData()), 250, "Your Top 5 Stocks");
        pTop5WidgetP = new JScrollPane(pTop5Widget);
        pTop5WidgetP.setMinimumSize(new Dimension(250, 300));
        pTop5WidgetP.setPreferredSize(new Dimension(250, 300));
        playTopP.add(pTop5WidgetP);
        base.add(playTopP);

        //Player's worst 5 stocks
        playBotP = ComponentsOverview.bot5StocksPanel();
        base.add(playBotP);

        rankingsP = ComponentsOverview.rankingWidgetPanel();
        base.add(rankingsP);


        GroupLayout layOverview = new GroupLayout(base);
        base.setLayout(layOverview);
        layOverview.setAutoCreateGaps(true);
        layOverview.setAutoCreateContainerGaps(true);
        layOverview.setHorizontalGroup(
                layOverview.createSequentialGroup()
                        .addGroup(layOverview.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layOverview.createSequentialGroup()
                                        .addComponent(nameP)
                                        .addComponent(rankingMoneyP)
                                )
                                .addComponent(compositeP)
                                .addGroup(layOverview.createSequentialGroup()
                                        .addComponent(rankingsP)
                                        .addComponent(playTopP)
                                        .addComponent(playBotP)
                                        .addComponent(hotSP)
                                        .addComponent(badSP)
                                )
                        )
        );
        layOverview.setVerticalGroup(
                layOverview.createSequentialGroup()
                        .addGroup(layOverview.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(nameP)
                                .addComponent(rankingMoneyP)
                        )
                        .addGroup(layOverview.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(compositeP)

                        )
                        .addGroup(layOverview.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(hotSP)
                                .addComponent(rankingsP)
                                .addComponent(playTopP)
                                .addComponent(playBotP)
                                .addComponent(badSP)
                        )
        );
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

        nameP = ComponentsOverview.namePanel();
        base.add(nameP);

        rankingMoneyP = ComponentsOverview.rankingMoneyPanel();
        base.add(rankingMoneyP);

        compositeP = ComponentsOverview.composite();
        base.add(compositeP);

        hotSP = ComponentsWidgets.top5StocksPanel();
        base.add(hotSP);

        badSP = ComponentsWidgets.bot5StocksPanel();
        base.add(badSP);

        playTopP = ComponentsOverview.top5StocksPanel();
        base.add(playTopP);

        playBotP = ComponentsOverview.bot5StocksPanel();
        base.add(playBotP);

        rankingsP = ComponentsOverview.rankingWidgetPanel();
        base.add(rankingsP);


        GroupLayout layOverview = new GroupLayout(base);
        base.setLayout(layOverview);
        layOverview.setAutoCreateGaps(true);
        layOverview.setAutoCreateContainerGaps(true);
        layOverview.setHorizontalGroup(
                layOverview.createSequentialGroup()
                        .addGroup(layOverview.createSequentialGroup()
                                .addComponent(nameP)
                                .addComponent(rankingMoneyP)
                        )
                        .addComponent(compositeP)
                        .addGroup(layOverview.createSequentialGroup()
                                .addComponent(rankingsP)
                                .addComponent(playTopP)
                                .addComponent(playBotP)
                                .addComponent(hotSP)
                                .addComponent(badSP)
                        )

        );
        layOverview.setVerticalGroup(
                layOverview.createSequentialGroup()
                        .addGroup(layOverview.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(nameP)
                                .addComponent(rankingMoneyP)
                        )
                        .addGroup(layOverview.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(compositeP)

                        )
                        .addGroup(layOverview.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(hotSP)
                                .addComponent(rankingsP)
                                .addComponent(playTopP)
                                .addComponent(playBotP)
                                .addComponent(badSP)
                        )
        );

        base.revalidate();
        base.repaint();

    }
}
