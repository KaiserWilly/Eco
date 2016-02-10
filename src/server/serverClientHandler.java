package server;

import client.FilingOverview;
import jdk.internal.util.xml.impl.Input;
import main.Values;
import server.engine.EcoEngine;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.Arrays;

/**
 * Created 12/27/15
 * Software Development
 * TSA Conference, 2016
 * serverClientHandler: Class containing code that interacts with the client
 */
public class serverClientHandler extends Thread {
    int ID;

    //Variables For ObjectOutputStream
    OutputStream outputStream;
    ObjectOutputStream out;

    InputStream inputStream;
    ObjectInputStream objectInputStream;

    Object[] userInfo = new Object[2];

    serverClientHandler(Socket socket, int id) throws IOException {
        outputStream = socket.getOutputStream();
        out = new ObjectOutputStream(outputStream);

        inputStream = socket.getInputStream();
        objectInputStream = new ObjectInputStream(inputStream);

        FilingOverview.allUserInfo.add(ID, userInfo);

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

                    userInfo[0] = objectInputStream.readObject();
                    userInfo[1] = objectInputStream.readObject();

                    FilingOverview.allUserInfo.set(ID, userInfo);
                    //Object[][] test = FilingOverview.getTop5Players(FilingOverview.allUserInfo);

                    out.writeObject(FilingOverview.getTop5Players(FilingOverview.allUserInfo));
                    out.reset();

                }
                Thread.sleep(1000); //Sleeps the server
            }
        } catch (SocketException e) {
            serverFile.showTimeStamp("Socket Error on Socket ID: " + ID);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
