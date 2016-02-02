package server;

import main.Values;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created 12/29/15
 * Software Development
 * TSA Conference, 2016
 * ServerTimer: Class containing code that paces the market and data updates to the clients.
 */
public class ServerTimer {
    static Timer timer;
    public static Object[][] dataArray;

    public static void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(task(), 500, 2000); //Task, delay, update speed
    }

    public static TimerTask task() {
        return new TimerTask() {
            @Override
            public void run() {
                dataArray = server.engine.EcoEngine.getData();
                Values.secCount++;
                server.engine.EcoEngine.genereateData();
            }
        };
    }


}
