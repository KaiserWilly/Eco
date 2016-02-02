package client;

import javax.swing.*;
import java.util.ConcurrentModificationException;

/**
 * Created 11/12/15
 * Software Development
 * TSA Conference, 2016
 * ClientMain: Class containing code routing start up methods
 */
public class ClientMain {

    public static void startClient(String serverIP) {
        Thread clientN = new ClientServerHandler(serverIP);
        clientN.start();
    }

    public static void startGUI() {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUIFrame.PaneFrameMain.createGUI();
                } catch (IllegalStateException e) {
                    System.out.println("IllegalStateException: GUIFrame.startGUI()");
                } catch (ConcurrentModificationException e) {
                    System.out.println("ConcurrentModificationException: GUIFrame.startGUI()");
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


}
