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
            serverFile.showTimeStamp("Starting Server");
            serverFile.showTimeStamp("Creating Listening Socket on Port 1180");
            ServerSocket listeningSocket = new ServerSocket(1180);
            serverFile.showTimeStamp("Socket Created");
            server.engine.EcoEngine.initializeEngine(50);
            serverFile.showTimeStamp("Engine Initialized");
            ServerTimer.startTimer();
            serverFile.showTimeStamp("Update Control Started, game beginning in 10 seconds");

            while (true) {
                Socket socketToClient = listeningSocket.accept();
                new ServerClientHandler(socketToClient, ID);
                ID++;
            }
        } catch (BindException e) {
            serverFile.showTimeStamp("ERROR: Port in use / Not able to bind to port. Terminating server");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
