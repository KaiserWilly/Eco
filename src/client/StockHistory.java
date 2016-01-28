package client;

import server.engine.EcoEngine;

import java.util.ArrayList;

/**
 * Created by trostrn on 1/27/2016.
 */
public class StockHistory {

    public static ArrayList<ArrayList<Object>> stockHistoryArrayList = new ArrayList<>();

    public static Object[] stockHistory;

    public static int numberOfStocks = EcoEngine.numberOfStocks;

    public static void createStockHistory() {
        for (int i = 0; i < numberOfStocks; i++) {
            ArrayList<Object> newRow = new ArrayList<>();
            newRow.add(0, EcoEngine.getData()[i][0]);
            stockHistoryArrayList.add(i, newRow);
        }
    }

    public static Object[] getStockHistory(String stockName) {
        for (int i = 0; i < numberOfStocks; i++) {
            if (stockHistoryArrayList.get(i).get(0).toString().equals(stockName)) {
                stockHistory = stockHistoryArrayList.get(i).toArray();
            }
        }
        return stockHistory;
    }

    public static void generateStockHistory() {
        if (stockHistoryArrayList.get(1).size() < 30) {
            for (int i = 0; i < numberOfStocks; i++) {
                stockHistoryArrayList.get(i).add(EcoEngine.getData()[i][1]);
            }

        } else if (stockHistoryArrayList.get(1).size() > 30) {
            for (int i = 0; i < numberOfStocks; i++) {
                stockHistoryArrayList.get(i).remove(1);
                stockHistoryArrayList.get(i).set(30, EcoEngine.getData()[i][1]);
            }
        }
    }
}
