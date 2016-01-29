package client;

import server.engine.EcoEngine;

/**
 * Created by isenhartjd on 1/25/2016.
 */
public class FilingStocks {
    static double total;
    static double average;

    //Method that generates average price across all stocks
        public static double getServerStockAverage() {
            for (int i = 0; i < EcoEngine.numberOfStocks; i++) {
                total += (double)EcoEngine.getData()[i][1];
            }

            average = (total / EcoEngine.numberOfStocks);
            average = (double) Math.round(average * 100) / 100;

            total = 0;
            return average;
        }
    public static double getClientStockAverage(Object[][] data) {
        for (int i = 0; i < data.length; i++) {
            total += (double)data[i][1];
        }

        average = (total / data.length);
        average = (double) Math.round(average * 100) / 100;
        total = 0;
        return average;
    }
    //
}
