package client;

import main.Values;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created 11/16/15
 * Software Development
 * TSA Conference, 2016
 * ClientServerHandler: Class containing code interacting with server
 */
public class ClientServerHandler extends Thread {
    String serverIP;

    static InputStream is;
    static ObjectInputStream in;

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
                    StockHistory.getStockHistory((String) dataArray[0][0]);
                }
                Values.dataArray = dataArray; //Stores the Stock Info Array to be used later.
                Score.getScore();
                count++;
                StockHistory.generateStockHistory();
                NetChangeOfAssets.getNetChange();
                Score.getPlayerStocks();
                Score.getAvgPlayerStockPrice(Score.getPlayerStocks());
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