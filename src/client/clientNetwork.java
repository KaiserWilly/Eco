package client;

import java.net.Socket;

/**
 * Created by james on 1/12/2016.
 */
public class clientNetwork {
    public static boolean testConnection(String IP) {
        try {
            Socket socket = new Socket(IP, 1180);
            socket.close();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
