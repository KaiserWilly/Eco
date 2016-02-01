package server;

import client.StockHistory;
import server.engine.EcoEngine;

import javax.swing.*;
import java.net.*;

/**
 * Created by james on 1/12/2016.
 */
public class ServerMain {
    public static void startServer() {
        int ID =1;
        try {
            ServerFile.showTimeStamp("Starting Server");
            ServerFile.showTimeStamp("Creating Listening Socket on Port 1180");
            ServerSocket listeningSocket = new ServerSocket(1180);
            ServerFile.showTimeStamp("Socket Created");
            server.engine.EcoEngine.initializeEngine(50);
            ServerFile.showTimeStamp("Engine Initialized");
            ServerTimer.startTimer();
            ServerFile.showTimeStamp("Update Control Started, game beginning in 10 seconds");
            try {
                JOptionPane.showMessageDialog(new JFrame(), "Have players connect to: "+ InetAddress.getLocalHost().getHostAddress()+" (Local Address) \n Server will not start until \'OK\' button is pressed.","Server Start", JOptionPane.NO_OPTION);
            } catch (UnknownHostException e1) {
                e1.printStackTrace();
            }


            while (true) {
                Socket socketToClient = listeningSocket.accept();
                new ServerClientHandler(socketToClient, ID).start();
                ID++;
            }
        } catch (BindException e) {
            ServerFile.showTimeStamp("ERROR: Port in use / Not able to bind to port. Terminating server");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
