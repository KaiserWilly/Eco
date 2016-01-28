package client;

import java.net.Socket;

/**
 * Created by james on 1/12/2016.
 */
public class ClientNetwork {
    public static boolean testConnection(String IP) {
        //Tests The Connection Between Client and Server
        try {
            Socket socket = new Socket(IP, 1180);
            socket.close();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
