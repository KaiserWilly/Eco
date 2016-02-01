package client;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Created by james on 1/31/2016.
 */
public class FilingPlayer {

    public static JPanel playerTable = new JPanel();

    public static Object[][] getPlayerTableData() {
        Object[][] playerData = new Object[Score.getPlayerStocks().length][4];
        Object[][] cliData = Score.getPlayerStocks();
        DecimalFormat formatter = new DecimalFormat("###,###,###.##", DecimalFormatSymbols.getInstance(Locale.getDefault()));
        for (int i = 0; i < playerData.length; i++) {
            playerData[i][0] = cliData[i][0]; ///Name
            playerData[i][1] = Score.assetArray[Score.getStockLocation(String.valueOf(playerData[i][0]))]; //Qty.
            StockHistory.getStockHistory(String.valueOf(playerData[i][0]));
            playerData[i][2] = formatter.format(StockHistory.percentChange); //Percent Change
            playerData[i][3] = cliData[i][1]; // Value

        }
        return playerData;
    }

    public static String[] getPlayerTableHeadings() {
        return new String[]{"Stock", "Qty.", "% Change over 60s", "Value"};
    }

    public static void playerTable() {
        JPanel tableBase = new JPanel();
        tableBase.setSize(1225, 175);
        tableBase.setBackground(new Color(213, 255, 213));
        tableBase.setLocation(50, 350);
        DefaultTableModel statisticsTableModel = new DefaultTableModel(FilingPlayer.getPlayerTableData(), FilingPlayer.getPlayerTableHeadings()) {
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return Double.class;
                    case 2:
                        return Double.class;
                    case 3:
                        return Double.class;
                    case 4:
                        return Double.class;
                    case 5:
                        return Integer.class;
                    default:
                        return String.class;
                }
            }
        };
        JTable mainStatsTable = new JTable(statisticsTableModel);
        DefaultTableCellRenderer CenterRenderer = new DefaultTableCellRenderer();
        CenterRenderer.setHorizontalAlignment(JLabel.CENTER);
        mainStatsTable.getColumnModel().getColumn(0).setCellRenderer(CenterRenderer);
        mainStatsTable.getColumnModel().getColumn(1).setCellRenderer(CenterRenderer);
        mainStatsTable.getColumnModel().getColumn(2).setCellRenderer(CenterRenderer);
        mainStatsTable.getColumnModel().getColumn(3).setCellRenderer(CenterRenderer);
        mainStatsTable.setBackground(Color.WHITE);
        mainStatsTable.setRowHeight(15);
        JScrollPane dataPanePS = new JScrollPane(mainStatsTable);
        dataPanePS.setPreferredSize(new Dimension(1225, 175));
        tableBase.add(dataPanePS);
        GroupLayout layFrame = new GroupLayout(tableBase);
        tableBase.setLayout(layFrame);
        layFrame.setAutoCreateGaps(true);
        layFrame.setAutoCreateContainerGaps(true);
        layFrame.setHorizontalGroup(
                layFrame.createSequentialGroup()
                        .addComponent(dataPanePS)
        );
        layFrame.setVerticalGroup(
                layFrame.createSequentialGroup()
                        .addComponent(dataPanePS)
        );
        playerTable = tableBase;
    }

}
