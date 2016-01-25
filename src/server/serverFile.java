package server;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by james on 1/12/2016.
 */
public class serverFile {
    public static void showTimeStamp(String command){
        Calendar now = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("[dd/MM HH:mm:ss]: ");
        String result = df.format(now.getTime())+command;
        System.out.println(result);
    }
}
