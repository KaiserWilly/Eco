package client;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created 12/24/15
 * Software Development
 * TSA Conference, 2016
 * Score: Class containing code that tracks and manages stock
 * prices, averages, and names
 */

public class Score {
    public static double score;
    public static double cashOnHand = 100000.00;
    public static double assets = 0;
    public static int numberOfStocks;
    public static int[] assetArray = new int[0];
    public static double[] stockPrices;
    public static Object[][] playerStocks;
    static int stockLocation;
    static String cashOnHandFormatted;
    static String assetsFormatted;
    static int count = 0;
    static ArrayList<Double> avgPriceList = new ArrayList<>();
    static double[] avgPriceArray;
    static double avgPrice;
    static DecimalFormat formatter = new DecimalFormat("###,###,###.##", DecimalFormatSymbols.getInstance(Locale.getDefault()));

    public static void createArrays() {
        numberOfStocks = ClientServerHandler.dataArray.length;
        assetArray = new int[numberOfStocks];
        stockPrices = new double[numberOfStocks];
    }

    public static double[] getAvgPlayerStockPrice(Object[][] playerData) {
        avgPrice = 0;
        for (int i = 0; i < playerData.length; i++) {
            double price = (double) playerData[i][1];
            avgPrice += price;
            System.out.println(avgPrice);
        }

        avgPrice = (avgPrice / playerData.length);
        System.out.println(avgPrice);

        if (avgPriceList.size() < 30 && avgPrice != 0) {
            avgPriceList.add(avgPrice);
        } else {
            avgPriceList.remove(0);
            avgPriceList.set(28, avgPrice);
        }
        avgPriceArray = new double[avgPriceList.size()];
        for (int i = 0; i < avgPriceList.size(); i++) {
            avgPriceArray[i] = avgPriceList.get(i);
        }

        return avgPriceArray;
    }

    public static double getScore() {
        score = cashOnHand + calcuateAssetsValue();
        return score;
    }

    public static double getCashOnHand() {
        //cashOnHand = cashOnHand + ((#stocks bought or sold) * (buy or sell value))

        cashOnHandFormatted = formatter.format(cashOnHand);
        return cashOnHand;
    }

    public static double[] getStockPrices() {
        for (int i = 0; i < numberOfStocks; i++) {
            stockPrices[i] = (double) ClientServerHandler.dataArray[i][1];
        }

        return stockPrices;
    }

    public static Object[][] getPlayerStocks() {
        count = 0;
        for (int i = 0; i < assetArray.length; i++) {
            if (assetArray[i] != 0) {
                count++;
            }
        }
        playerStocks = new Object[count][2];

        count = 0;

        for (int i = 0; i < assetArray.length; i++) {
            if (assetArray[i] != 0) {
                playerStocks[count][0] = ClientServerHandler.dataArray[i][0];
                playerStocks[count][1] = ClientServerHandler.dataArray[i][1];
                count++;
            }
        }
        return playerStocks;
    }

    public static int getStockLocation(String stockName) {
        for (int i = 0; i < ClientServerHandler.dataArray.length; i++) {
            String name = (String) ClientServerHandler.dataArray[i][0];
            if (stockName.equals(name)) {
                stockLocation = i;
            }
        }
        return stockLocation;
    }

    public static void buyOrSellAssets(String stockName, int numberOfBuy) {
        for (int i = 0; i < ClientServerHandler.dataArray.length; i++) {
            String name = (String) ClientServerHandler.dataArray[i][0];
            if (stockName.equals(name)) {
                stockLocation = i;
            }
        }

        if ((assetArray[stockLocation] + numberOfBuy < 0)) {
            System.out.println("You cant sell stocks you dont have");
        } else if ((cashOnHand - (stockPrices[stockLocation] * numberOfBuy)) < 0) {
            System.out.println("You dont have enough cash to buy those stocks");
        } else {
            assetArray[stockLocation] = assetArray[stockLocation] + numberOfBuy;
            cashOnHand = cashOnHand - (stockPrices[stockLocation] * numberOfBuy);
        }
    }

    public static int[] getAssets() {
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
