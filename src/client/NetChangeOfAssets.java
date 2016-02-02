package client;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Created 12/27/15
 * Software Development
 * TSA Conference, 2016
 * GUIMenu: Class containing code that formats incoming net change values
 */
public class NetChangeOfAssets {
    static double netChange;
    static String netChangeFormatted;
    static double oldAssets = 0;
    static double newAssets = 0;

    static DecimalFormat formatter = new DecimalFormat("###,###,###.##", DecimalFormatSymbols.getInstance(Locale.getDefault()));

    public static double getNetChange() {
        netChange = newAssets - oldAssets;
        netChangeFormatted = formatter.format(netChange);
        return netChange;
    }
}
