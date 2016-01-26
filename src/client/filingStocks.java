package client;

import server.engine.EcoEngine;

/**
 * Created by isenhartjd on 1/25/2016.
 */
public class filingStocks {
    static int total;
    static double average;
    //Method that generates average across all stocks
        public static double getStockAverage() {
            for (int i = 0; i < EcoEngine.numberOfStocks; i++) {
                total += (int)EcoEngine.stockInfo[i][0];
            }

            average = (total / EcoEngine.numberOfStocks);

            total = 0;

            System.out.println("The average price of the stock is:" +average);

            return average;
        }
    //
}
