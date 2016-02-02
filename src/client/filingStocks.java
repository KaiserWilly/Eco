package client;

import filing.FilingMain;
import server.engine.EcoEngine;

import java.util.HashMap;
import java.util.Map;

/**
 * Created 11/23/15
 * Software Development
 * TSA Conference, 2016
 * FilingStocks: Class containing code managing client-side stock info
 */
public class FilingStocks {
    static double total;
    static double average;
    static Map priceMap = new HashMap<>();

    public static double getClientStockAverage(Object[][] data) {
        for (int i = 0; i < data.length; i++) {
            total += (double) data[i][1];
        }

        average = (total / data.length);
        average = (double) Math.round(average * 100) / 100;
        total = 0;
        return average;
    }

    // getting the maximum value
    public static int getMaxValue(double[] array) {
        double maxVal = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxVal) {
                maxVal = array[i];

            }
        }
        return (int) Math.ceil(maxVal);
    }

    // getting the miniumum value
    public static int getMinValue(double[] array) {
        double minVal = 1000;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < minVal && array[i] != 0) {
                minVal = array[i];

            }
        }
        return (int) Math.floor(minVal);
    }

    public static double getPrice(String stock) {
        return (double) priceMap.get(stock);
    }

    public static void makePriceMap() {
        Object[][] data = FilingMain.getData();
        priceMap = new HashMap<>();
        for (int i = 0; i < data.length; i++) {
            priceMap.put(data[i][0], data[i][1]);
        }
    }
}
