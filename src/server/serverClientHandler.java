package server;

import client.StockHistory;
import main.Values;
import server.engine.EcoEngine;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by james on 1/12/2016.
 */
public class ServerClientHandler extends Thread {
    private Socket socketToClient;
    int ID;

    public ServerClientHandler(Socket socket, int id) {
        socketToClient = socket;
        ID = id;
        start();
    }

    public void run() {
        try {
            OutputStream outputStream = socketToClient.getOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(outputStream);
            int secCount = 0;
            System.out.println("New client connected!");
            while (true) {
                if (secCount < Values.secCount) {
                    secCount = Values.secCount;

                    StockHistory.generateStockHistory();
                    out.writeObject(EcoEngine.getData());
                    out.reset();
                }
                Thread.sleep(1000);
            }
        } catch (SocketException e) {
            ServerFile.showTimeStamp("Socket Error on Socket ID: "+ID);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
