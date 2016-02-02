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
    static DecimalFormat formatter = new DecimalFormat("###,###,###.##", DecimalFormatSymbols.getInstance(Locale.getDefault())); //Formats Strings to have commas and dollar signs

    public static void createArrays() {
        numberOfStocks = ClientServerHandler.dataArray.length; //Gets the number of stocks as an easy to access variable
        assetArray = new int[numberOfStocks]; //Creates an array that keeps track of the number of each stock you have
        stockPrices = new double[numberOfStocks]; //Creates an array that keeps track of the price of each stock
    }

    public static double[] getAvgPlayerStockPrice(Object[][] playerData) {
        //Calculates the average price all stocks
        avgPrice = 0;
        for (int i = 0; i < playerData.length; i++) {
            double price = (double) playerData[i][1];
            avgPrice += price;
        }

        avgPrice = (avgPrice / playerData.length);

        //Gets an array of the average stock price that can be put into a graph
        if (avgPriceList.size() < 30 && avgPrice != 0) { //If the game hasn't been running for 60s, adds the stock price to the back of the array
            avgPriceList.add(avgPrice);
        } else { //The game has been running for more than 60s, removes the first Average Price, and adds the latest price
            avgPriceList.remove(0);
            avgPriceList.set(28, avgPrice);
        }

        //Creates a double array of the Average Price
        avgPriceArray = new double[avgPriceList.size()];

        for (int i = 0; i < avgPriceList.size(); i++) {
            avgPriceArray[i] = avgPriceList.get(i);
        }

        return avgPriceArray;
    }

    public static double getScore() {
        //Returns the players current score
        score = cashOnHand + calcuateAssetsValue();
        return score;
    }

    public static double getCashOnHand() {
        //Returns the player's cash on hand and also formats it for use in the gui
        cashOnHandFormatted = formatter.format(cashOnHand);
        return cashOnHand;
    }

    public static double[] getStockPrices() {
        //Fills the stock prices array with the current stock prices
        for (int i = 0; i < numberOfStocks; i++) {
            stockPrices[i] = (double) ClientServerHandler.dataArray[i][1];
        }

        return stockPrices;
    }

    public static Object[][] getPlayerStocks() {
        //Finds the number of stocks the player owns
        count = 0;
        for (int i = 0; i < assetArray.length; i++) {
            if (assetArray[i] != 0) {
                count++;
            }
        }

        //Creates an array of the stocks the player owns
        playerStocks = new Object[count][2];

        count = 0;

        for (int i = 0; i < assetArray.length; i++) {
            if (assetArray[i] != 0) {
                playerStocks[count][0] = ClientServerHandler.dataArray[i][0]; //Sets the names of the stocks the player owns
                playerStocks[count][1] = ClientServerHandler.dataArray[i][1]; //Sets the price of the stocks the player owns
                count++;
            }
        }
        return playerStocks;
    }

    public static int getStockLocation(String stockName) {
        //Finds the location of a specific stock name within the stock data array
        for (int i = 0; i < ClientServerHandler.dataArray.length; i++) {
            String name = (String) ClientServerHandler.dataArray[i][0];
            if (stockName.equals(name)) {
                stockLocation = i;
            }
        }
        return stockLocation;
    }

    public static void buyOrSellAssets(String stockName, int numberOfBuy) {
        //Changes the amount of stocks the player owns (
        for (int i = 0; i < ClientServerHandler.dataArray.length; i++) {
            String name = (String) ClientServerHandler.dataArray[i][0];
            if (stockName.equals(name)) {
                stockLocation = i;
            }
        }

        if ((assetArray[stockLocation] + numberOfBuy < 0)) {
            //Do Nothing (Cannot sell stocks you don't have)
        } else if ((cashOnHand - (stockPrices[stockLocation] * numberOfBuy)) < 0) {
            //Do Nothing (Cannot but stocks you don't have the cash for
        } else {
            assetArray[stockLocation] = assetArray[stockLocation] + numberOfBuy; //Adds to the number (negative numberOfBuy means selling stocks) of stocks you have
            cashOnHand = cashOnHand - (stockPrices[stockLocation] * numberOfBuy); //Updates your cash on hand
        }
    }

    public static int[] getAssets() {
        //Returns the asset array
        return assetArray;
    }

    public static double calcuateAssetsValue() {
        //Gets the value of the player's assets
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
