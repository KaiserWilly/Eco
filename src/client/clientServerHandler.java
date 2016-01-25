package client;

import main.Values;

import java.io.*;
import java.net.BindException;
import java.net.Socket;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.HashMap;

/**
 * Created by james on 1/13/2016.
 */
public class clientServerHandler extends Thread {
    int count = 0;
    String serverIP;

    public clientServerHandler(String IP) {
        serverIP = IP;
    }

    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Socket clientSocket = new Socket(serverIP, 1180);
            System.out.println("Permanent Connection Made!");
            InputStream is = clientSocket.getInputStream();
//            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
            Thread.sleep(100);
            clientMain.startGUI();

            while (true) {

                Object[][] dataArray = (Object[][]) in.readObject();
                boolean dataUp = false;
                while (!dataUp) {
                    try {
                        Values.dataArray = dataArray;
                        dataUp = true;
//                        for (int i = 0; i < dataArray.length; i++) { // Print out each row of data in array for testing
//                            System.out.println(Arrays.toString(dataArray[i]));
//                        }
                    } catch (ConcurrentModificationException e) {
                        System.out.println("Can't Write Data");
                    }
                }

                GUIFrame.PaneFrameMain.reloadTab();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}