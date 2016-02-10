package client;

import server.engine.EcoEngine;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created 11/12/15
 * Software Development
 * TSA Conference, 2016
 * FilingOverview: Class containing code that creates Overview "top 5" panels
 */
public class FilingOverview {
    public static ArrayList<Object[]> allUserInfo = new ArrayList<>();

    public static Object[][] getTop5Players(ArrayList<Object[]> userArray) {
        Object[][] placeA = new Object[][]{
                {"NONE", 0},
                {"NONE", 0},
                {"NONE", 0},
                {"NONE", 0},
                {"NONE", 0},
        };

        if (userArray == null) return placeA;

        for (int i = 0; i < userArray.size(); i++) {

            String userName = String.valueOf(userArray.get(i)[0]);
            double score = Double.parseDouble(String.valueOf(userArray.get(i)[1]));

            //First Place
            if (score >= Double.parseDouble(String.valueOf(placeA[0][1]))) {
                placeA[4][0] = placeA[3][0];
                placeA[4][1] = placeA[3][1];
                placeA[3][0] = placeA[2][0];
                placeA[3][1] = placeA[2][1];
                placeA[2][0] = placeA[1][0];
                placeA[2][1] = placeA[1][1];
                placeA[1][0] = placeA[0][0];
                placeA[1][1] = placeA[0][1];
                placeA[0][0] = userName;
                placeA[0][1] = score;
                //Second Place
            } else if (score >= Double.parseDouble(String.valueOf(placeA[1][1]))) {
                placeA[4][0] = placeA[3][0];
                placeA[4][1] = placeA[3][1];
                placeA[3][0] = placeA[2][0];
                placeA[3][1] = placeA[2][1];
                placeA[2][0] = placeA[1][0];
                placeA[2][1] = placeA[1][1];
                placeA[1][0] = userName;
                placeA[1][1] = score;
                //Third Place
            } else if (score >= Double.parseDouble(String.valueOf(placeA[2][1]))) {
                placeA[4][0] = placeA[3][0];
                placeA[4][1] = placeA[3][1];
                placeA[3][0] = placeA[2][0];
                placeA[3][1] = placeA[2][1];
                placeA[2][0] = userName;
                placeA[2][1] = score;
                //Fourth Place
            } else if (score >= Double.parseDouble(String.valueOf(placeA[3][1]))) {
                placeA[4][0] = placeA[3][0];
                placeA[4][1] = placeA[3][1];
                placeA[3][0] = userName;
                placeA[3][1] = score;
                //Fifth Place
            } else if (score >= Double.parseDouble(String.valueOf(placeA[4][1]))) {
                placeA[4][0] = userName;
                placeA[4][1] = score;
            }

        }

        return placeA;
    }

    public static Object[][] calcTop5Stocks(Object[][] dataArray) {
        Object[][] placeA = new Object[][]{
                {"NONE", 0},
                {"NONE", 0},
                {"NONE", 0},
                {"NONE", 0},
                {"NONE", 0},
        };
        if (dataArray == null) return placeA;

        for (int i = 0; i < dataArray.length; i++) {
            String stockName = String.valueOf(dataArray[i][0]);
            double value = Double.parseDouble(String.valueOf(dataArray[i][1]));
            //First Place
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
                //Second Place
            } else if (value >= Double.parseDouble(String.valueOf(placeA[1][1]))) {
                placeA[4][0] = placeA[3][0];
                placeA[4][1] = placeA[3][1];
                placeA[3][0] = placeA[2][0];
                placeA[3][1] = placeA[2][1];
                placeA[2][0] = placeA[1][0];
                placeA[2][1] = placeA[1][1];
                placeA[1][0] = stockName;
                placeA[1][1] = value;
                //Third Place
            } else if (value >= Double.parseDouble(String.valueOf(placeA[2][1]))) {
                placeA[4][0] = placeA[3][0];
                placeA[4][1] = placeA[3][1];
                placeA[3][0] = placeA[2][0];
                placeA[3][1] = placeA[2][1];
                placeA[2][0] = stockName;
                placeA[2][1] = value;
                //Fourth Place
            } else if (value >= Double.parseDouble(String.valueOf(placeA[3][1]))) {
                placeA[4][0] = placeA[3][0];
                placeA[4][1] = placeA[3][1];
                placeA[3][0] = stockName;
                placeA[3][1] = value;
                //Fifth Place
            } else if (value >= Double.parseDouble(String.valueOf(placeA[4][1]))) {
                placeA[4][0] = stockName;
                placeA[4][1] = value;
            }

        }
        return placeA;
    }

    public static Object[][] calcWorst5Stocks(Object[][] dataArray) {
        Object[][] placeA = new Object[][]{
                {"NONE", 5000},
                {"NONE", 5000},
                {"NONE", 5000},
                {"NONE", 5000},
                {"NONE", 5000},
        };
        if (dataArray == null) return placeA;

        for (int i = 0; i < dataArray.length; i++) {
            String stockName = String.valueOf(dataArray[i][0]);
            double value = Double.parseDouble(String.valueOf(dataArray[i][1]));
            //First Place
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
                //Second Place
            } else if (value <= Double.parseDouble(String.valueOf(placeA[1][1]))) {
                placeA[4][0] = placeA[3][0];
                placeA[4][1] = placeA[3][1];
                placeA[3][0] = placeA[2][0];
                placeA[3][1] = placeA[2][1];
                placeA[2][0] = placeA[1][0];
                placeA[2][1] = placeA[1][1];
                placeA[1][0] = stockName;
                placeA[1][1] = value;
                //Third Place
            } else if (value <= Double.parseDouble(String.valueOf(placeA[2][1]))) {
                placeA[4][0] = placeA[3][0];
                placeA[4][1] = placeA[3][1];
                placeA[3][0] = placeA[2][0];
                placeA[3][1] = placeA[2][1];
                placeA[2][0] = stockName;
                placeA[2][1] = value;
                //Fourth Place
            } else if (value <= Double.parseDouble(String.valueOf(placeA[3][1]))) {
                placeA[4][0] = placeA[3][0];
                placeA[4][1] = placeA[3][1];
                placeA[3][0] = stockName;
                placeA[3][1] = value;
                //Fifth Place
            } else if (value <= Double.parseDouble(String.valueOf(placeA[4][1]))) {
                placeA[4][0] = stockName;
                placeA[4][1] = value;
            }

        }
        return placeA;
    }

}
