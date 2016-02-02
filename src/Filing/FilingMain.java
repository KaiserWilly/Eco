package filing;

import main.Values;

import java.util.ConcurrentModificationException;

/**
 * Created 10/29/15
 * Software Development
 * TSA Conference, 2016
 * FilingMain: Class containing code that fetches data updated by server
 */
public class FilingMain {

    public static Object[][] getData() {
        while (true) {
            try {
            return Values.dataArray;
            } catch (ConcurrentModificationException e) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
