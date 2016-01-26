package server;

import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

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

            while (true) {
                Socket socketToClient = listeningSocket.accept();
                new ServerClientHandler(socketToClient, ID);
                ID++;
            }
        } catch (BindException e) {
            ServerFile.showTimeStamp("ERROR: Port in use / Not able to bind to port. Terminating server");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
