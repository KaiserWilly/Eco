package client;

import Filing.FilingMain;
import Filing.FilingWidget;

import javax.swing.*;
import java.awt.*;

/**
 * Created by james on 1/23/2016.
 */
public class ComponentsOverview {
    static GridBagConstraints c = new GridBagConstraints();

    public static JPanel composite() {
        c.fill = GridBagConstraints.CENTER;
        Font sHeading = new Font("Trebuchet MS", Font.PLAIN, 40);
        JPanel base = new JPanel();
        base.setPreferredSize(new Dimension(1018, 300));
        base.setMaximumSize(new Dimension(1018, 300));
        base.setBackground(new Color(198, 240, 198));

        JLabel name = new JLabel("<Insert Composite Graph Here>");
        name.setFont(sHeading);
        base.add(name, c);

        return base;
    }

    public static JPanel rankingWidgetPanel() {
        c.fill = GridBagConstraints.CENTER;
        Font sHeading = new Font("Trebuchet MS", Font.PLAIN, 16);
        JPanel base = new JPanel();
        base.setLayout(new GridBagLayout());
        base.setPreferredSize(new Dimension(250, 300));
        base.setMaximumSize(new Dimension(250, 300));
        base.setBackground(new Color(198, 240, 198));

        Object[][] rankings = new Object[][]{
                {"JD", "23,300"},
                {"Daniel", "22,600"},
                {"Brody", "19,900"},
                {"Will", "16,300"}

        };
        JPanel widget = FilingWidget.makeRankingWidget(rankings, 300);
        JScrollPane widgetPane = new JScrollPane(widget);
        widgetPane.setMinimumSize(new Dimension(250, 300));
        widgetPane.setPreferredSize(new Dimension(250, 300));
        base.add(widgetPane, c);

        return base;

    }

    public static JPanel namePanel() {

        Font sHeading = new Font("Trebuchet MS", Font.PLAIN, 20);
        JPanel base = new JPanel();
        base.setLayout(new GridBagLayout());
        base.setPreferredSize(new Dimension(200, 50));
        base.setMaximumSize(new Dimension(200, 50));
        base.setBackground(new Color(198, 240, 198));

        JLabel name = new JLabel("<Insert Name>");
        name.setFont(sHeading);
        base.add(name);

        GroupLayout baseLayout = new GroupLayout(base);
        base.setLayout(baseLayout);
        baseLayout.setAutoCreateGaps(true);
        baseLayout.setAutoCreateContainerGaps(true);
        baseLayout.setHorizontalGroup(
                baseLayout.createSequentialGroup()
                        .addComponent(name)
        );
        baseLayout.setVerticalGroup(
                baseLayout.createSequentialGroup()
                        .addComponent(name)
        );

        return base;

    }

    public static JPanel rankingMoneyPanel() {
        c.fill = GridBagConstraints.CENTER;
        Font sHeading = new Font("Trebuchet MS", Font.PLAIN, 16);
        JPanel base = new JPanel();
        base.setLayout(new GridBagLayout());
        base.setPreferredSize(new Dimension(300, 50));
        base.setMaximumSize(new Dimension(300, 50));
        base.setBackground(new Color(198, 240, 198));

        JLabel name = new JLabel("Ranking: NA   Money: NA   Assets: NA");
        name.setFont(sHeading);
        base.add(name, c);

        return base;

    }

    public static JPanel top5StocksPanel() {
        c.fill = GridBagConstraints.CENTER;
        Font sHeading = new Font("Trebuchet MS", Font.PLAIN, 16);
        JPanel base = new JPanel();
        base.setLayout(new GridBagLayout());
        base.setPreferredSize(new Dimension(250, 300));
        base.setMaximumSize(new Dimension(250, 300));
        base.setBackground(new Color(198, 240, 198));

        JPanel widget = FilingWidget.playStockWidget(FilingOverview.calcTop5Stocks(FilingMain.getData()), 250, "Your Top 5 Stocks");
        JScrollPane widgetPane = new JScrollPane(widget);
        widgetPane.setMinimumSize(new Dimension(250, 300));
        widgetPane.setPreferredSize(new Dimension(250, 300));
        base.add(widgetPane, c);

        return base;
    }

    public static JPanel bot5StocksPanel() {
        c.fill = GridBagConstraints.CENTER;
        Font sHeading = new Font("Trebuchet MS", Font.PLAIN, 16);
        JPanel base = new JPanel();
        base.setLayout(new GridBagLayout());
        base.setPreferredSize(new Dimension(250, 300));
        base.setMaximumSize(new Dimension(250, 300));
        base.setBackground(new Color(198, 240, 198));

        JPanel widget = FilingWidget.playStockWidget(FilingOverview.calcWorst5Stocks(FilingMain.getData()), 250, "Your Worst 5 Stocks");
        JScrollPane widgetPane = new JScrollPane(widget);
        widgetPane.setMinimumSize(new Dimension(250, 300));
        widgetPane.setPreferredSize(new Dimension(250, 300));
        base.add(widgetPane, c);

        return base;
    }

    public static JPanel playStats() {
        c.fill = GridBagConstraints.CENTER;
        Font sHeading = new Font("Trebuchet MS", Font.PLAIN, 20);
        JPanel base = new JPanel();
        base.setLayout(new GridBagLayout());
        base.setPreferredSize(new Dimension(250, 300));
        base.setMaximumSize(new Dimension(250, 300));
        base.setBackground(new Color(198, 240, 198));

        JLabel name = new JLabel("<Insert player stats here>");
        name.setFont(sHeading);
        base.add(name, c);

        return base;
    }
}
