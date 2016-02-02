package client;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created 12/30/15
 * Software Development
 * TSA Conference, 2016
 * StockHistory: Class containing code that manages Stocks over time,
 * generating data to send to graphs and tables.
 */
public class StockHistory {

    public static ArrayList<ArrayList<Object>> stockHistoryArrayList = new ArrayList<>();
    public static double[] compositeStockHistory = new double[30];

    public static Object[] stockHistory;

    public static int numberOfStocks;

    public static double percentChange;

    public static void createCompositeHistory() {
        //Fills the Composite Stock History with all zeros. This prevents a null pointer exception
        Arrays.fill(compositeStockHistory, 0);
    }

    public static void updateComposite(double d) {
        //Updates the stock history for the composite graph
        for (int i = 1; i <= 29; i++) {
            compositeStockHistory[i-1] = compositeStockHistory[i];
        }
        compositeStockHistory[29] = d;

    }

    public static double[] getCompositeHistory() {
        //Returns the composite stock history for easy access
        return compositeStockHistory;
    }

    public static void createStockHistory() {
        //Creates a two dimensional ArrayList that will stock history for all stocks
        for (int i = 0; i < numberOfStocks; i++) {
            ArrayList<Object> newRow = new ArrayList<>();
            newRow.add(0, ClientServerHandler.dataArray[i][0]);
            stockHistoryArrayList.add(i, newRow);
        }
    }

    public static double[] getStockHistory(String stockName) {
        //Gets the history of a stock by Stock Name
        for (int i = 0; i < numberOfStocks; i++) {
            if (stockHistoryArrayList.get(i).get(0).toString().equals(stockName)) {
                stockHistory = stockHistoryArrayList.get(i).toArray();
            }
        }

        double[] stockHistoryDouble = new double[stockHistory.length - 1];

        //Creates the double array from the Object array of stock history
        for (int i = 1; i < stockHistory.length; i++) {
            stockHistoryDouble[i - 1] = (double)stockHistory[i];
        }

        //Gets the percent change the stock has changed over the last 60 seconds
        getStockPercentChange(stockHistoryDouble);

        return stockHistoryDouble;
    }

    public static double getStockPercentChange(double[] data) {
        //Calculates the percent change of the stock over the past 60 sec (Or however long the code has been running)
        percentChange = ((data[data.length - 1] - data[0]) /  data[0]) * 100;
        return percentChange;
    }

    public static void generateStockHistory() {
        //Adds the value of the stock to its stock history
        if (stockHistoryArrayList.get(1).size() < 30) {
            //If the stock hasn't been running for 60s, adds the price to the very back of the array
            for (int i = 0; i < numberOfStocks; i++) {
                stockHistoryArrayList.get(i).add(ClientServerHandler.dataArray[i][1]);
            }

        } else if (stockHistoryArrayList.get(1).size() >= 30) { //The stock has been running for more than 60s, deletes the first price, and adds the latest price to the back
            for (int i = 0; i < numberOfStocks; i++) {
                stockHistoryArrayList.get(i).remove(1);
                stockHistoryArrayList.get(i).set(28, ClientServerHandler.dataArray[i][1]);
            }
        }
    }
}
