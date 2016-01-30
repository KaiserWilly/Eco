package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DecimalFormat;

/**
 * Created by james on 1/29/2016.
 */
public class BuyWidget extends JPanel implements FocusListener {
    static String stockName;
    static int wid, hei;
    static Font nameF = new Font("Tahoma", Font.BOLD, 20);

    public BuyWidget(String stockN, int width, int height) {
        stockName = stockN;
        wid = width;
        hei = height;
        addFocusListener(this);
        setSize(width, height);
//        setBackground(new Color(50, 85, 172));
        add(PanelContents());
        setLayout(null);
    }

    public static JPanel PanelContents() {
        JPanel base = new JPanel();
        base.setSize(wid, hei);
        base.setLayout(null);

        JLabel name = new JLabel(stockName);
        name.setSize(100, 30);
        name.setVerticalAlignment(SwingConstants.CENTER);
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setLocation(0, 0);
        name.setFont(nameF);
        base.add(name);

//        StockHistory.getStockHistory(stockName);
        DecimalFormat df = new DecimalFormat("#,###.##");
        double change = 3.7/*Double.parseDouble(df.format(StockHistory.percentChange))*/;
        JLabel perChange = new JLabel(/*Double.toString(change) + "%"*/ "3.4%");
        if (change >= 0) {
            perChange.setForeground(new Color(0, 0, 0));
        } else {
            perChange.setForeground(new Color(225, 149, 152));
        }
        perChange.setSize(100, 30);
        perChange.setVerticalAlignment(SwingConstants.CENTER);
        perChange.setHorizontalAlignment(SwingConstants.CENTER);
        perChange.setLocation(100, 0);
        perChange.setFont(nameF);
        base.add(perChange);

        JLabel price = new JLabel(String.valueOf(FilingStocks.getPrice(stockName)));
        price.setSize(100, 30);
        price.setVerticalAlignment(SwingConstants.CENTER);
        price.setHorizontalAlignment(SwingConstants.CENTER);
        price.setLocation(250, 0);
        price.setFont(nameF);
        base.add(price);
        return base;
    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {

    }
}
