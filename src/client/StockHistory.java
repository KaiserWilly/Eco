package client;

import server.engine.EcoEngine;

import java.util.ArrayList;

/**
 * Created by trostrn on 1/27/2016.
 */
public class StockHistory {
    ArrayList<ArrayList<Object>> stockHistoryArrayList = new ArrayList<>();

    Object[][] stockHistoryArray = new Object[EcoEngine.numberOfStocks][60];
    int numberOfStocks = EcoEngine.numberOfStocks;

    public ArrayList<ArrayList<Object>> getStockHistory() {
        if (stockHistoryArrayList.size() < 60) {
            for (int i = 0; i < numberOfStocks; i++) {
                ArrayList<Object> newRow = new ArrayList<>();
                newRow.add(EcoEngine.getData()[i][1]);
                stockHistoryArrayList.add(i, newRow);
            }

        } else if (stockHistoryArrayList.size() > 60) {
            for (int i = 0; i < numberOfStocks; i++) {
                ArrayList<Object> newRow = new ArrayList<>();
                newRow.remove(0);
                newRow.add(EcoEngine.getData()[i][1]);
                stockHistoryArrayList.set(i, newRow);
            }
        }

        return stockHistoryArrayList;
    }
}
