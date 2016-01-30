package client;

import server.engine.EcoEngine;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by james on 1/13/2016.
 */
public class FilingOverview {
    public static Object[][] calcTop5Stocks(Object[][] dataArray) {
        Object[][] placeA = new Object[][]{
                {"NONE", 0},
                {"NONE", 0},
                {"NONE", 0},
                {"NONE", 0},
                {"NONE", 0},
        };
        if (dataArray == null ) return placeA;

        for (int i = 0; i < dataArray.length; i++) {
            String stockName = String.valueOf(dataArray[i][0]);
            double value = Double.parseDouble(String.valueOf(dataArray[i][1]));
            if (value >= Double.parseDouble(String.valueOf(placeA[0][1]))) {
                placeA[4][0] = placeA[3][0];
                placeA[4][1] = placeA[3][1];
                placeA[3][0] = placeA[2][0];
                placeA[3][1] = placeA[2][1];
                placeA[2][0] = placeA[1][0];
                placeA[2][1] = placeA[1][1];
                placeA[1][0] = placeA[0][0];
                placeA[1][1] = placeA[0][1];
                placeA[0][0] = stockName;
                placeA[0][1] = value;
            } else if (value >= Double.parseDouble(String.valueOf(placeA[1][1]))) {
                placeA[4][0] = placeA[3][0];
                placeA[4][1] = placeA[3][1];
                placeA[3][0] = placeA[2][0];
                placeA[3][1] = placeA[2][1];
                placeA[2][0] = placeA[1][0];
                placeA[2][1] = placeA[1][1];
                placeA[1][0] = stockName;
                placeA[1][1] = value;
            } else if (value >= Double.parseDouble(String.valueOf(placeA[2][1]))) {
                placeA[4][0] = placeA[3][0];
                placeA[4][1] = placeA[3][1];
                placeA[3][0] = placeA[2][0];
                placeA[3][1] = placeA[2][1];
                placeA[2][0] = stockName;
                placeA[2][1] = value;
            } else if (value >= Double.parseDouble(String.valueOf(placeA[3][1]))) {
                placeA[4][0] = placeA[3][0];
                placeA[4][1] = placeA[3][1];
                placeA[3][0] = stockName;
                placeA[3][1] = value;
            } else if (value >= Double.parseDouble(String.valueOf(placeA[4][1]))) {
                placeA[4][0] = stockName;
                placeA[4][1] = value;
            }

        }
        return placeA;
    }

    public static Object[][] calcWorst5Stocks(Object[][] dataArray) {
        Object[][] placeA = new Object[][]{
                {"NONE", 50},
                {"NONE", 50},
                {"NONE", 50},
                {"NONE", 50},
                {"NONE", 50},
        };
        if (dataArray == null) return placeA;

        for (int i = 0; i < dataArray.length; i++) {
            String stockName = String.valueOf(dataArray[i][0]);
            double value = Double.parseDouble(String.valueOf(dataArray[i][1]));
            if (value <= Double.parseDouble(String.valueOf(placeA[0][1]))) {
                placeA[4][0] = placeA[3][0];
                placeA[4][1] = placeA[3][1];
                placeA[3][0] = placeA[2][0];
                placeA[3][1] = placeA[2][1];
                placeA[2][0] = placeA[1][0];
                placeA[2][1] = placeA[1][1];
                placeA[1][0] = placeA[0][0];
                placeA[1][1] = placeA[0][1];
                placeA[0][0] = stockName;
                placeA[0][1] = value;
            } else if (value <= Double.parseDouble(String.valueOf(placeA[1][1]))) {
                placeA[4][0] = placeA[3][0];
                placeA[4][1] = placeA[3][1];
                placeA[3][0] = placeA[2][0];
                placeA[3][1] = placeA[2][1];
                placeA[2][0] = placeA[1][0];
                placeA[2][1] = placeA[1][1];
                placeA[1][0] = stockName;
                placeA[1][1] = value;
            } else if (value <= Double.parseDouble(String.valueOf(placeA[2][1]))) {
                placeA[4][0] = placeA[3][0];
                placeA[4][1] = placeA[3][1];
                placeA[3][0] = placeA[2][0];
                placeA[3][1] = placeA[2][1];
                placeA[2][0] = stockName;
                placeA[2][1] = value;
            } else if (value <= Double.parseDouble(String.valueOf(placeA[3][1]))) {
                placeA[4][0] = placeA[3][0];
                placeA[4][1] = placeA[3][1];
                placeA[3][0] = stockName;
                placeA[3][1] = value;
            } else if (value <= Double.parseDouble(String.valueOf(placeA[4][1]))) {
                placeA[4][0] = stockName;
                placeA[4][1] = value;
            }

        }
        return placeA;
    }

    public static Object[][] getRankings() {
        Object[][] rankings = new Object[][]{
                {"NONE", 50},
                {"NONE", 50},
                {"NONE", 50},
                {"NONE", 50},
                {"NONE", 50},
        };
        try {
            for (int i = 0; i < EcoEngine.clientScores.size(); i++) {
                rankings[i][0] = EcoEngine.clientScores.get(i)[0];
                rankings[i][1] = EcoEngine.clientScores.get(i)[1];
            }
        } catch (Exception e) {
            rankings = new Object[][]{
                    {"NONE", 50},
                    {"NONE", 50},
                    {"NONE", 50},
                    {"NONE", 50},
                    {"NONE", 50},
            };
        }

        for (int i = 0; i < EcoEngine.clientScores.size(); i++) {
            String username = (String) EcoEngine.clientScores.get(i)[0];
            double score = (double) EcoEngine.clientScores.get(i)[1];
            if (score >= Double.parseDouble(String.valueOf(rankings[0][1]))) {
                rankings[4][0] = rankings[3][0];
                rankings[4][1] = rankings[3][1];
                rankings[3][0] = rankings[2][0];
                rankings[3][1] = rankings[2][1];
                rankings[2][0] = rankings[1][0];
                rankings[2][1] = rankings[1][1];
                rankings[1][0] = rankings[0][0];
                rankings[1][1] = rankings[0][1];
                rankings[0][0] = username;
                rankings[0][1] = score;
            } else if (score >= Double.parseDouble(String.valueOf(rankings[1][1]))) {
                rankings[4][0] = rankings[3][0];
                rankings[4][1] = rankings[3][1];
                rankings[3][0] = rankings[2][0];
                rankings[3][1] = rankings[2][1];
                rankings[2][0] = rankings[1][0];
                rankings[2][1] = rankings[1][1];
                rankings[1][0] = username;
                rankings[1][1] = score;
            } else if (score >= Double.parseDouble(String.valueOf(rankings[2][1]))) {
                rankings[4][0] = rankings[3][0];
                rankings[4][1] = rankings[3][1];
                rankings[3][0] = rankings[2][0];
                rankings[3][1] = rankings[2][1];
                rankings[2][0] = username;
                rankings[2][1] = score;
            } else if (score >= Double.parseDouble(String.valueOf(rankings[3][1]))) {
                rankings[4][0] = rankings[3][0];
                rankings[4][1] = rankings[3][1];
                rankings[3][0] = username;
                rankings[3][1] = score;
            } else if (score >= Double.parseDouble(String.valueOf(rankings[4][1]))) {
                rankings[4][0] = username;
                rankings[4][1] = score;
            }
            System.out.println(Arrays.toString(rankings[i]));
        }
        return rankings;
    }
}
