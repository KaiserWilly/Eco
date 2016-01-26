package client;

import javax.swing.*;
import java.util.ConcurrentModificationException;

/**
 * Created by james on 1/12/2016.
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
                    GUIFrame.PaneFrameMain.createGUI(); //Can't get it to recognize the reference
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
