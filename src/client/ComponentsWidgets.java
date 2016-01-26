package client;

import filing.FilingMain;
import filing.FilingWidget;

import javax.swing.*;
import java.awt.*;

/**
 * Created by james on 1/24/2016.
 */
public class ComponentsWidgets {
    public static JPanel top5StocksPanel() {
        Font sHeading = new Font("Trebuchet MS", Font.PLAIN, 16);
        JPanel base = new JPanel();
        base.setLayout(null);
        base.setPreferredSize(new Dimension(250, 300));
        base.setMaximumSize(new Dimension(250, 300));
        base.setBackground(new Color(198, 240, 198));

        JPanel widget = FilingWidget.nonPStockWidget(FilingOverview.calcTop5Stocks(FilingMain.getData()), 250, "Top 5 Stocks");
        JScrollPane widgetPane = new JScrollPane(widget);
        widgetPane.setSize(250,300);
        widgetPane.setLocation(0,0);
        base.add(widgetPane);

        return base;
    }

    public static JPanel bot5StocksPanel() {
        Font sHeading = new Font("Trebuchet MS", Font.PLAIN, 16);
        JPanel base = new JPanel();
        base.setLayout(null);
        base.setPreferredSize(new Dimension(250, 300));
        base.setMaximumSize(new Dimension(250, 300));
        base.setBackground(new Color(198, 240, 198));

        JPanel widget = FilingWidget.nonPStockWidget(FilingOverview.calcWorst5Stocks(FilingMain.getData()), 250, "Worst 5 Stocks");
        JScrollPane widgetPane = new JScrollPane(widget);
        widgetPane.setMinimumSize(new Dimension(250, 300));
        widgetPane.setPreferredSize(new Dimension(250, 300));
        widgetPane.setLocation(0,0);
        base.add(widgetPane);

        return base;
    }
}
