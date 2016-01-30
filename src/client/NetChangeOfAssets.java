package client;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Created by Ryan Trost on 1/28/2016.
 */
public class NetChangeOfAssets {
    static double netChange;

    static double oldAssets = 0;
    static double newAssets = 0;

    public static double getNetChange() {
        DecimalFormat formatter = new DecimalFormat("#,###", DecimalFormatSymbols.getInstance(Locale.getDefault()));
        for (int i = 0; i < XPTabData.length; i++) {
            XPTabData[i][1] = formatter.format(Integer.parseInt(String.valueOf(XPTabData[i][1])));
        }
        netChange = newAssets - oldAssets;

        netChange = (double) Math.round(netChange * 100) / 100;

        return netChange;
    }
}
