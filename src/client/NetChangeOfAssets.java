package client;

/**
 * Created by Ryan Trost on 1/28/2016.
 */
public class NetChangeOfAssets {
    static double netChange;

    static double oldAssets = 0;
    static double newAssets = 0;

    public static double getNetChange() {
        netChange = newAssets - oldAssets;

        netChange = (double) Math.round(netChange * 100) / 100;

        return netChange;
    }
}
