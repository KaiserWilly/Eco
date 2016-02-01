package client;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
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
        for (int i = 0; i < playerData.length; i++) {
            avgPrice += (double) playerData[i][1];
        }

        avgPrice = (avgPrice / playerData.length);

        avgPriceList.add(avgPrice);

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

    public static double[] getStockPrices () {
        for (int i = 0; i < numberOfStocks; i++) {
            stockPrices[i] = (double)ClientServerHandler.dataArray[i][1];
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

        try {
            for (int i = 0; i < playerStocks.length; i++) {
                System.out.println(Arrays.toString(playerStocks[i]));
            }
        } catch (Exception e) {

        }
        return playerStocks;
    }

    public static int getStockLocation(String stockName) {
        for (int i = 0; i < ClientServerHandler.dataArray.length; i++) {
            String name = (String)ClientServerHandler.dataArray[i][0];
            if (stockName.equals(name)) {
                stockLocation = i;
            }
        }
        return stockLocation;
    }

    public static void buyOrSellAssets(String stockName, int numberOfBuy) {
        for (int i = 0; i < ClientServerHandler.dataArray.length; i++) {
            String name = (String)ClientServerHandler.dataArray[i][0];
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

    public static int[] getAssets () {
        return assetArray;
    }

    public static double calcuateAssetsValue() {
        NetChangeOfAssets.oldAssets = assets;
        assets = 0;

        getStockPrices();
        getAssets();

        //System.out.println(Arrays.toString(assetArray));

        for (int i = 0; i < numberOfStocks; i++) {
            assets += stockPrices[i] * assetArray[i];
        }

        assetsFormatted = formatter.format(assets);

        NetChangeOfAssets.newAssets = assets;

        //System.out.println("Assets: " + assets);
        return assets;
    }
}
