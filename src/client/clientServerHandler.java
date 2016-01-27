package client;

import main.Values;

import java.io.*;
import java.net.Socket;
import java.util.ConcurrentModificationException;

/**
 * Created by james on 1/13/2016.
 */
public class ClientServerHandler extends Thread {
    int count = 0;
    String serverIP;

    static InputStream is;
    static ObjectInputStream in;

    static Object[][] dataArray = null;

    public ClientServerHandler(String IP) {
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
            ClientMain.startGUI();
            Thread.sleep(100);

            is = clientSocket.getInputStream();
//            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            in = new ObjectInputStream(is);

            while (true) {
                dataArray = (Object[][]) in.readObject();
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