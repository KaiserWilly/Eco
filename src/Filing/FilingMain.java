package filing;

import main.Values;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.ConcurrentModificationException;

/**
 * Created by JD Isenhart on 9/14/2015.
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
