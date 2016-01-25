package client;

import Filing.FilingMain;

import javax.swing.*;
import java.awt.*;

/**
 * Created by JD Isenhart on 9/15/2015.
 */
public class GUIOverview {
    static JPanel base, nameP, rankingMoneyP, compositeP, hotSP, badSP, playTopP, playBotP, rankingsP, playStatsP;


    public JPanel OverviewPanel() {
        base = new JPanel();
        base.setBackground(Color.WHITE);

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

        playStatsP = ComponentsOverview.playStats();
        base.add(playStatsP);


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
                                        .addComponent(playStatsP)
                                        .addComponent(rankingsP)
                                        .addComponent(playTopP)
                                        .addComponent(playBotP)
                                )
                        )
                        .addGroup(layOverview.createParallelGroup(GroupLayout.Alignment.CENTER)
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
                                .addComponent(hotSP)

                        )
                        .addGroup(layOverview.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(playStatsP)
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

        hotSP = ComponentsWidgets.top5StocksPanel();
        base.add(hotSP);

        badSP = ComponentsWidgets.bot5StocksPanel();
        base.add(badSP);

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
                                        .addComponent(playStatsP)
                                        .addComponent(rankingsP)
                                        .addComponent(playTopP)
                                        .addComponent(playBotP)
                                )
                        )
                        .addGroup(layOverview.createParallelGroup(GroupLayout.Alignment.CENTER)
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
                                .addComponent(hotSP)

                        )
                        .addGroup(layOverview.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(playStatsP)
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
