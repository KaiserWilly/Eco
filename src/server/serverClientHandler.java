package server;

import main.Values;
import server.engine.EcoEngine;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created 12/27/15
 * Software Development
 * TSA Conference, 2016
 * ServerClientHandler: Class containing code that interacts with the client
 */
public class ServerClientHandler extends Thread {
    int ID;

    //Variables For ObjectOutputStream
    OutputStream outputStream;
    ObjectOutputStream out;

    ServerClientHandler(Socket socket, int id) throws IOException {
        outputStream = socket.getOutputStream();
        out = new ObjectOutputStream(outputStream);

        ID = id;
    }

    public void run() {
        try {
            int secCount = 0;
            System.out.println("New client connected!");

            while (true) {
                if (secCount < Values.secCount) {
                    secCount = Values.secCount;

                    out.writeObject(EcoEngine.getData()); //Writes The Stock Data To The Client
                    out.reset(); //Resets the Output Stream to clear to data inside

                }
                Thread.sleep(1000); //Sleeps the server
            }
        } catch (SocketException e) {
            ServerFile.showTimeStamp("Socket Error on Socket ID: "+ID);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
