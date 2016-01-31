package client;

import server.engine.EcoEngine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * Created by trostrn on 1/27/2016.
 */
public class StockHistory {

    public static ArrayList<ArrayList<Object>> stockHistoryArrayList = new ArrayList<>();
    public static double[] compositeStockHistory = new double[30];

    public static Object[] stockHistory;
    //public static double[] stockHistoryDouble;

    public static int numberOfStocks;

    public static double percentChange;

    public static void createCompositeHistory() {
        Arrays.fill(compositeStockHistory, 0);
    }

    public static void updateComposite(double d) {
        for (int i = 1; i <= 29; i++) {
            compositeStockHistory[i-1] = compositeStockHistory[i];
        }
        compositeStockHistory[29] = d;

    }

    public static double[] getCompositeHistory() {
        return compositeStockHistory;
    }

    public static void createStockHistory() {
        for (int i = 0; i < 50; i++) {
            ArrayList<Object> newRow = new ArrayList<>();
            newRow.add(0, ClientServerHandler.dataArray[i][0]);
            stockHistoryArrayList.add(i, newRow);
        }
    }

    public static double[] getStockHistory(String stockName) {
        for (int i = 0; i < 50; i++) {
            if (stockHistoryArrayList.get(i).get(0).toString().equals(stockName)) {
                System.out.println(stockHistoryArrayList.get(i).get(0).toString());
                System.out.println(Arrays.toString(stockHistoryArrayList.get(i).toArray()));
                stockHistory = stockHistoryArrayList.get(i).toArray();
            }
        }

        double[] stockHistoryDouble = new double[stockHistory.length - 1];

        for (int i = 1; i < stockHistory.length; i++) {
            stockHistoryDouble[i - 1] = (double)stockHistory[i];
        }

        getStockPercentChange(stockHistoryDouble);
        return stockHistoryDouble;
    }

    public static double getStockPercentChange(double[] data) {
        System.out.println(Arrays.toString(data));
        percentChange = ((data[data.length - 1] - data[0]) /  data[0]) * 100;
        System.out.println(percentChange);
        return percentChange;
    }

    public static void generateStockHistory() {
        if (stockHistoryArrayList.get(1).size() < 30) {
            for (int i = 0; i < numberOfStocks; i++) {
                stockHistoryArrayList.get(i).add(ClientServerHandler.dataArray[i][1]);
            }

        } else if (stockHistoryArrayList.get(1).size() > 30) {
            for (int i = 0; i < numberOfStocks; i++) {
                stockHistoryArrayList.get(i).remove(0);
                stockHistoryArrayList.get(i).set(30, ClientServerHandler.dataArray[i][1]);
            }
        }
    }
}
