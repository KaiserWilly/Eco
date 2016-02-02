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
            ServerSocket listeningSocket = new ServerSocket(1180); // Starts The Server
            ServerFile.showTimeStamp("Socket Created");
            server.engine.EcoEngine.initializeEngine(50); //Starts the Engine with 50 stocks
            ServerFile.showTimeStamp("Engine Initialized");
            ServerTimer.startTimer(); //Starts the timer
            ServerFile.showTimeStamp("Update Control Started, game beginning in 1 second");
            try {
                //Creates A Dialog Box To Show What IP Clients Need To Connect To
                JOptionPane.showMessageDialog(new JFrame(), "Have players connect to: "+ InetAddress.getLocalHost().getHostAddress()+" (Local Address) \n Server will not start until \'OK\' button is pressed.","Server Start", JOptionPane.NO_OPTION);
            } catch (UnknownHostException e1) {
                e1.printStackTrace();
            }


            while (true) {
                Socket socketToClient = listeningSocket.accept(); //Accepts the Client
                new ServerClientHandler(socketToClient, ID).start(); //Starts a thread of the server
                ID++; //Increases the number of clients tracked
            }
        } catch (BindException e) {
            ServerFile.showTimeStamp("ERROR: Port in use / Not able to bind to port. Terminating server");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
