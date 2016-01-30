package client;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Created by Ryan Trost on 1/27/2016.
 */

public class Score {
    public static double score;
    public static double cashOnHand = 100000.00;
    public static double assets = 0;

    public static int numberOfStocks;

    public static int[] assetArray;
    public static double[] stockPrices;

    static String cashOnHandFormatted;
    static String assetsFormatted;

    static DecimalFormat formatter = new DecimalFormat("###,###,###.##", DecimalFormatSymbols.getInstance(Locale.getDefault()));
    //asdf

    public static void createArrays() {
        numberOfStocks = ClientServerHandler.dataArray.length;
        assetArray = new int[numberOfStocks];
        stockPrices = new double[numberOfStocks];
    }
    public static double getScore() {
        score = cashOnHand + calcuateAssetsValue();
        System.out.println("Score: $" + score);
        return score;
    }

    public static double getCashOnHand() {
        //cashOnHand = cashOnHand + ((#stocks bought or sold) * (buy or sell value))

        cashOnHandFormatted = formatter.format(cashOnHand);
        return cashOnHand;
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

        assetsFormatted = formatter.format(assets);

        NetChangeOfAssets.newAssets = assets;
        return assets;
    }
}
