package server;

import client.FilingOverview;
import client.StockHistory;
import main.Values;
import server.engine.EcoEngine;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.Arrays;

/**
 * Created by james on 1/12/2016.
 */
public class ServerClientHandler extends Thread {
    int ID;

    InputStream is;
    DataInputStream in;

    OutputStream outputStream;
    ObjectOutputStream out;

    ServerClientHandler(Socket socket, int id) throws IOException {
        is = socket.getInputStream();
        in = new DataInputStream(is);

        outputStream = socket.getOutputStream();
        out = new ObjectOutputStream(outputStream);

        ID = id;
    }

    public void run() {
        try {
            int secCount = 0;
            System.out.println("New client connected!" + ID);

            //Object[] userInfo = new Object[2];

            //String username = in.readUTF();
            //userInfo[0] = username;
            //EcoEngine.clientScores.add(ID - 1, userInfo);

            while (true) {
                if (secCount < Values.secCount) {
                    secCount = Values.secCount;

                    out.writeObject(EcoEngine.getData());
                    out.reset();

                    //double score = in.readDouble();
                    //userInfo[1] = score;

                   // EcoEngine.clientScores.set(ID - 1, userInfo);

                    String stockName = (String)EcoEngine.stockInfo[0][0];
                    //StockHistory.getStockHistory(stockName);

                    //FilingOverview.getRankings();
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
