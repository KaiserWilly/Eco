package client;

import filing.FilingMain;
import server.engine.EcoEngine;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

/**
 * Created by isenhartjd on 1/25/2016.
 */
public class FilingStocks {
    static double total;
    static double average;
    static Map priceMap = new HashMap<>();

    //Method that generates average price across all stocks
    public static double getServerStockAverage() {
        for (int i = 0; i < EcoEngine.numberOfStocks; i++) {
            total += (double) EcoEngine.getData()[i][1];
        }

        average = (total / EcoEngine.numberOfStocks);
        average = (double) Math.round(average * 100) / 100;

        total = 0;
        return average;
    }

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
            priceMap.put((String) data[i][0], (double) data[i][1]);
        }
    }
}
