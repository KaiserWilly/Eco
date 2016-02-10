package client;

import main.Values;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

/**
 * Created 11/16/15
 * Software Development
 * TSA Conference, 2016
 * clientServerHandler: Class containing code interacting with server
 */
public class clientServerHandler extends Thread {
    String serverIP;

    static InputStream is;
    static ObjectInputStream in;

    static OutputStream os;
    static ObjectOutputStream oos;

    static Object[][] dataArray = null;

    static Object[][] rankingArray = null;

    public clientServerHandler(String IP) {
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
            clientMain.startGUI();
            Thread.sleep(100);

            is = clientSocket.getInputStream(); //Gets the client's input stream
            in = new ObjectInputStream(is); //Creates an Object Input Stream from the client's input stream

            os = clientSocket.getOutputStream();
            oos = new ObjectOutputStream(os);

            while (true) {
                dataArray = (Object[][]) in.readObject(); //Reads the Stock Information Array from the socket
                StockHistory.numberOfStocks = dataArray.length;

                oos.writeObject(GUIOverview.namePlayer);
                if (count == 0) {
                    StockHistory.createStockHistory();
                    Score.createArrays();
                }
                if (count > 1) {
                    StockHistory.getStockHistory((String) dataArray[0][0]);
                }
                Values.dataArray = dataArray; //Stores the Stock Info Array to be used later.

                double score = Score.getScore();
                oos.writeObject(score);

                count++;
                StockHistory.generateStockHistory();
                NetChangeOfAssets.getNetChange();
                Score.getPlayerStocks();
                Score.getAvgPlayerStockPrice(Score.getPlayerStocks());
                filingStocks.makePriceMap();
                StockHistory.updateComposite(filingStocks.getClientStockAverage(dataArray));
                Score.getCashOnHand();
                FilingBuy.createWidget();
                FilingBuy.createLabels();
                FilingBuy.createBuyPanel(GUIBuy.stockbuy);
                FilingSell.createWidget();
                FilingSell.createLabels();
                FilingSell.createSellPanel(GUISell.stockSell);
                FilingPlayer.playerTable();
                GUIFrame.PaneFrameMain.reloadTab(); //Refreshes the GUI

                rankingArray = (Object[][]) in.readObject();

                for (int i = 0; i < rankingArray.length; i++) {
                    System.out.println(Arrays.toString(rankingArray[i]));
                }

                System.out.println();


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}