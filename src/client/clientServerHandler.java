package client;

import main.Values;

import java.io.*;
import java.net.Socket;

/**
 * Created by james on 1/13/2016.
 */
public class ClientServerHandler extends Thread {
    String serverIP;

    static InputStream is;
    static ObjectInputStream in;
    static OutputStream outputStream;
    static ObjectOutputStream objectOutputStream;

    static Object[][] dataArray = null;

    public ClientServerHandler(String IP) {
        serverIP = IP;
    }

    static int count = 0;

    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            // Connects Client To Server
            Socket clientSocket = new Socket(serverIP, 1180);
            System.out.println("Permanent Connection Made!");
            StockHistory.createCompositeHistory();
            ClientMain.startGUI();

            //Score.generateAssetsArray();

            Thread.sleep(100);

            is = clientSocket.getInputStream(); //Gets the client's input stream
            in = new ObjectInputStream(is); //Creates an Object Input Stream from the client's input stream


            while (true) {
                dataArray = (Object[][]) in.readObject(); //Reads the Stock Information Array from the socket
                StockHistory.numberOfStocks = dataArray.length;
                if (count == 0) {
                    StockHistory.createStockHistory();
                    Score.createArrays();
                }

                if (count > 1) {
                    //Twest
                    StockHistory.getStockHistory((String) dataArray[0][0]);
                }

                Values.dataArray = dataArray; //Stores the Stock Info Array to be used later.
                Score.getScore();
                count++;
                StockHistory.generateStockHistory();
                NetChangeOfAssets.getNetChange();
                Score.getPlayerStocks();
                FilingStocks.makePriceMap();
                StockHistory.updateComposite(FilingStocks.getClientStockAverage(dataArray));
                Score.getCashOnHand();
                FilingBuy.createWidget();
                FilingBuy.createLabels();
                FilingBuy.createBuyPanel(GUIBuy.stockbuy);
                FilingSell.createWidget();
                FilingSell.createLabels();
                FilingSell.createSellPanel(GUISell.stockSell);
                FilingPlayer.playerTable();
                GUIFrame.PaneFrameMain.reloadTab(); //Refreshes the GUI


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}