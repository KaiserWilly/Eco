package client;

import java.util.Arrays;

/**
 * Created by Ryan Trost on 1/27/2016.
 */

public class Score {
    public static double score;
    public static double cashOnHand;
    public static double assets;

    public static int numberOfStocks = ClientServerHandler.dataArray.length;

    public static int[] assetArray = new int[numberOfStocks];
    public static double[] stockPrices = new double[numberOfStocks];

    public static double getScore() {
        score = cashOnHand + calcuateAssetsValue();
        return score;
    }

    public static void generateAssetsArray() {
        Arrays.fill(assetArray, 0);
    }

    public static double[] getStockPrices () {
        for (int i = 0; i < numberOfStocks; i++) {
            stockPrices[i] = (double)ClientServerHandler.dataArray[i][1];
        }

        return stockPrices;
    }

    public static int[] getAssets () {
        for (int i = 0; i < numberOfStocks; i++) {
            assetArray[i] = 1; //Client Stocks
        }

        return assetArray;
    }

    private static double calcuateAssetsValue() {
        assets = 0;

        getStockPrices();
        getAssets();

        for (int i = 0; i < numberOfStocks; i++) {
            assets += stockPrices[i] * assetArray[i];
        }

        assets = (double) Math.round(assets * 100) / 100;

        return assets;
    }
}
