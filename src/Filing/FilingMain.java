package filing;

import main.Values;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.ConcurrentModificationException;

/**
 * Created by JD Isenhart on 9/14/2015.
 */
public class FilingMain {
    public static class AcceptFile extends javax.swing.filechooser.FileFilter {

        @Override
        public boolean accept(File f) {
            if (f.isDirectory()) {
                return true;
            }
            String extension = FilenameUtils.getExtension(f.getAbsolutePath());
            if (extension.equals("ADDCC")) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public String getDescription() {
            return null;
        }
    }

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
