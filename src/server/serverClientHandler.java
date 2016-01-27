package server;

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
            ObjectOutputStream out = new ObjectOutputStream(socketToClient.getOutputStream());
            int secCount = 0;
            System.out.println("New client connected!");
            while (true) {
                if (secCount < Values.secCount) {
                    secCount = Values.secCount;
//                    for (int i=0;i<ServerTimer.dataArray.length;i++){
//                        System.out.println(Arrays.toString(ServerTimer.dataArray[i]));
//                    }
                    EcoEngine.genereateData();
                    out.writeObject(EcoEngine.getData());
                    //System.out.println("Sending Data");
                    //out.writeObject(ServerTimer.dataArray);
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
