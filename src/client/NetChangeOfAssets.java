package client;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Created by Ryan Trost on 1/28/2016.
 */
public class NetChangeOfAssets {
    static double netChange;
    static String netChangeFormateed;

    static double oldAssets = 0;
    static double newAssets = 0;

    static DecimalFormat formatter = new DecimalFormat("###,###,###.##", DecimalFormatSymbols.getInstance(Locale.getDefault()));

    public static double getNetChange() {
        netChange = newAssets - oldAssets;

        netChangeFormateed = formatter.format(netChange);

        return netChange;
    }
}
