package main;

import client.GUIMenu;

import javax.swing.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by james on 1/12/2016.
 */
public class EcoMain {
    public static void main(String[] args) throws UnknownHostException {
        System.out.println("Current IP: "+ InetAddress.getLocalHost().getHostAddress());
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUIMenu.PaneFrameMain.createGUI();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
