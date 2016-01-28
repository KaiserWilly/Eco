package client;

import server.engine.EcoEngine;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by trostrn on 1/27/2016.
 */
public class StockHistory {

    public static ArrayList<ArrayList<Object>> stockHistoryArrayList = new ArrayList<>();
    public static double[] compositeStockHistory = new double[30];

    public static Object[] stockHistory;

    public static int numberOfStocks = EcoEngine.numberOfStocks;

    public static void createCompositeHistory() {
        for (int i = 0; i < 30; i++) {
            compositeStockHistory[i] = 0;
        }
    }

    public static void updateComposite(double d) {
        for (int i = 29; i > 1; i--) {
            compositeStockHistory[i - 1] = compositeStockHistory[i];
        }
        compositeStockHistory[29] = d;

    }

    public static double[] getCompositeHistory() {
        return compositeStockHistory;
    }

    public void createStockHistory() {
        for (int i = 0; i < numberOfStocks; i++) {
            ArrayList<Object> newRow = new ArrayList<>();
            newRow.add(0, EcoEngine.getData()[i][0]);
            stockHistoryArrayList.add(i, newRow);
        }
    }

    public static Object[] getStockHistory(String stockName) {
        for (int i = 0; i < numberOfStocks; i++) {
            if (stockHistoryArrayList.get(i).get(0).toString().equals(stockName)) {
                Object[] stockHistory = stockHistoryArrayList.get(i).toArray();
            }
        }
        return stockHistory;
    }

    public void generateStockHistory() {
        if (stockHistoryArrayList.size() < 60) {
            for (int i = 0; i < numberOfStocks; i++) {
                stockHistoryArrayList.get(i).add(EcoEngine.getData()[i][1]);
            }

        } else if (stockHistoryArrayList.size() > 60) {
            for (int i = 0; i < numberOfStocks; i++) {
                stockHistoryArrayList.get(i).remove(0);
                stockHistoryArrayList.get(i).set(60, EcoEngine.getData()[i][1]);
            }
        }
    }
}
