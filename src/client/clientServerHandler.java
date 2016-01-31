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
                Score.createArrays();
                Values.dataArray = dataArray; //Stores the Stock Info Array to be used later.
                Score.getScore();
                FilingStocks.makePriceMap();
                StockHistory.updateComposite(FilingStocks.getClientStockAverage(dataArray));
                Score.getCashOnHand();
                FilingBuy.createWidget();
                FilingBuy.createLabels();
                FilingBuy.createBuyPanel(GUIBuy.stockbuy);
                FilingSell.createWidget();
                FilingSell.createLabels();
                FilingSell.createSellPanel(GUISell.stockSell);
                GUIFrame.PaneFrameMain.reloadTab(); //Refreshes the GUI
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}