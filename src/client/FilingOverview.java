package client;

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

}
