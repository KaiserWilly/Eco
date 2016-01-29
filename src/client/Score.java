package client;

import java.util.Arrays;

/**
 * Created by Ryan Trost on 1/27/2016.
 */

public class Score {
    public static double score;
    public static double cashOnHand = 10000.00;
    public static double assets = 0;

    public static int numberOfStocks;

    public static int[] assetArray;
    public static double[] stockPrices;

    public static void createArrays() {
        numberOfStocks = ClientServerHandler.dataArray.length;
        assetArray = new int[numberOfStocks];
        stockPrices = new double[numberOfStocks];
    }
    public static double getScore() {
        score = cashOnHand + calcuateAssetsValue();
        return score;
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

    public static double calcuateAssetsValue() {
        NetChangeOfAssets.oldAssets = assets;
        assets = 0;

        getStockPrices();
        getAssets();

        for (int i = 0; i < numberOfStocks; i++) {
            assets += stockPrices[i] * assetArray[i];
        }

        assets = (double) Math.round(assets * 100) / 100;

        NetChangeOfAssets.newAssets = assets;
        return assets;
    }
}
