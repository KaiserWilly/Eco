package client;

import server.engine.EcoEngine;

/**
 * Created by isenhartjd on 1/25/2016.
 */
public class filingStocks {
    static double total;
    static double average;

    //Method that generates average price across all stocks
        public static double getStockAverage() {
            System.out.println("Total Number Of Stocks: " + EcoEngine.numberOfStocks);
            for (int i = 0; i < EcoEngine.numberOfStocks; i++) {
                total += (double)EcoEngine.stockInfo[i][1];
            }

            average = (total / EcoEngine.numberOfStocks);
            average = (double) Math.round(average * 100) / 100;

            total = 0;

            System.out.println("The average price of the stock is: $" +average);

            return average;
        }
    //
}
