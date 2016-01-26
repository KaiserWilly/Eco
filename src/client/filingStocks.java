package client;

import server.engine.EcoEngine;

/**
 * Created by isenhartjd on 1/25/2016.
 */
public class FilingStocks {
    static double total;
    static double average;

    //Method that generates average price across all stocks
        public static double getStockAverage() {
            for (int i = 0; i < EcoEngine.numberOfStocks; i++) {
                total += (double)EcoEngine.stockInfo[i][1];
            }

            average = (total / EcoEngine.numberOfStocks);
            average = (double) Math.round(average * 100) / 100;

            total = 0;
            return average;
        }
    //
}
