package server;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created 12/28/15
 * Software Development
 * TSA Conference, 2016
 * ServerFile: Class containing code that stamps each console output
 */
public class ServerFile {
    public static void showTimeStamp(String command){
        //Creates A Time Stamp, Used For Debugging Purposes

        Calendar now = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("[dd/MM HH:mm:ss]: ");
        String result = df.format(now.getTime())+command;
        System.out.println(result);
    }
}
