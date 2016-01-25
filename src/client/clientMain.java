package client;

import javax.swing.*;

/**
 * Created by james on 1/12/2016.
 */
public class clientMain {

    public static void startClient(String serverIP) {
        Thread clientN = new clientServerHandler(serverIP);
        clientN.start();
    }

    public static void startGUI() {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUIFrame.PaneFrameMain.createGUI(); //Can't get it to recognize the reference
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


}
