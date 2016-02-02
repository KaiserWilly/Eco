package server;

import javax.swing.*;
import java.net.*;

/**
 * Created 12/27/15
 * Software Development
 * TSA Conference, 2016
 * ServerMain: Class containing code that starts the server
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
