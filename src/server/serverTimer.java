package server;

import main.Values;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by james on 1/12/2016.
 */
public class serverTimer {
    static Timer timer;
    public static Object[][] dataArray;

    public static void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(task(), 10000, 2000); //Task, delay, update spped
    }

    public static TimerTask task() {
        return new TimerTask() {
            @Override
            public void run() {
                dataArray = server.engine.EcoEngine.getData();
                Values.secCount++;
                server.engine.EcoEngine.genereateData();
                serverFile.showTimeStamp("Data Update Sent; SEC: " + Values.secCount);
            }
        };
    }


}
