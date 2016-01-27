package client; /**
 * Created by JD Isenhart on 9/15/2015.
 */


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by J.D. Isenhart on 4/5/2015
 * 5:56 PM
 */
public class GUIFrame {
    public static int dimX = 1366, dimY = 700;
    public static JPanel pStatistics, cStatistics, base;
    public static JFrame mainFrame;
    public static JTabbedPane tPane;
    public static JLabel panelIcon;
    public static GroupLayout layFrame;
    public static GUIOverview overview = new GUIOverview();
    public static GUIStocks stocks = new GUIStocks();
    public static GUIBuy buy = new GUIBuy();
    static int times = 0;


    public static class PaneFrameMain implements ChangeListener {


        public static void createGUI() throws IOException {
            GUIMenu icon = new GUIMenu();
            mainFrame = new JFrame("Echo v" + main.Values.VERSION);
            mainFrame.setMinimumSize(new Dimension(600, 400));
            mainFrame.setJMenuBar(null);
            mainFrame.setMaximumSize(new Dimension(1366, 700));
//            mainFrame.addComponentListener(new frameResizedListener() {
//            });
            JFrame.setDefaultLookAndFeelDecorated(false);
            PaneFrameMain index = new PaneFrameMain();
            mainFrame.setIconImage(icon.getFrameIcon());
            mainFrame.getContentPane().add(index.paneContent());
            mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            mainFrame.pack();
            mainFrame.setLocationRelativeTo(null);
            mainFrame.setVisible(true);
        }


        public JPanel paneContent() throws IOException {
            base = new JPanel();
            base.setPreferredSize(new Dimension(dimX, dimY));
            base.setMinimumSize(new Dimension(dimX, dimY));
            base.setBackground(new Color(198, 240, 198));
            tPane = new JTabbedPane();
            tPane.addTab("Game Overview", null, overview.OverviewPanel(), "Overview of the Game");
            tPane.addTab("Your Stocks", null, stocks.guiStocks(), "Overview of stock performance");
            tPane.addTab("Buy", null, buy.buyPanel(), "Buy Stocks");
            tPane.addTab("Sell", null, new JPanel(), "Sell Stocks");
//            tPane.addChangeListener(this);
            base.add(tPane);

            BufferedImage pb = null;
            try {
                pb = ImageIO.read(getClass().getResource("/rsc/EcoBanner.png"));
                panelIcon = new JLabel(new ImageIcon(pb));
                panelIcon.setHorizontalAlignment(SwingConstants.CENTER);
                panelIcon.setVerticalAlignment(SwingConstants.CENTER);
                base.add(panelIcon);
            } catch (IOException e) {
                System.out.println("Can't load image");
            } catch (IllegalArgumentException u) {
                System.out.println("We can't find the picture! C");
            }
            assert pb != null;


            layFrame = new GroupLayout(base);
            base.setLayout(layFrame);
            layFrame.setAutoCreateGaps(true);
            layFrame.setAutoCreateContainerGaps(true);
            layFrame.setHorizontalGroup(
                    layFrame.createSequentialGroup()
                            .addGroup(layFrame.createParallelGroup(GroupLayout.Alignment.CENTER)
                                    .addComponent(tPane)
                                    .addComponent(panelIcon)
                            )

            );
            layFrame.setVerticalGroup(
                    layFrame.createSequentialGroup()

                            .addComponent(tPane)
                            .addComponent(panelIcon)
            );
            return base;
        }

        @Override
        public void stateChanged(ChangeEvent e) {
            reloadTab();
        }

        public static void reloadTab() {
            int tabIndex = -1;
            try {
                tabIndex = tPane.getSelectedIndex();
            } catch (NullPointerException e) {

            }
//            System.out.println("Selected Tab: " + tabIndex);
            switch (tabIndex) {
                case 0:
//                    System.out.println(" (Game Overview)");
                    GUIOverview.updateOverview();
                    break;
                case 1:
                    System.out.println(" (Player Stocks)");
//                    mainFrame.setJMenuBar(comStats.getTheMenuBar());
                    mainFrame.revalidate();
                    mainFrame.repaint();
                    GUIStocks.updateGUIStocks();
                    break;
                case 2:
                    System.out.println(" (Buy)");
//                    mainFrame.setJMenuBar(partyStats.pMenuBar());
                    mainFrame.revalidate();
                    mainFrame.repaint();
                    GUIBuy.updateBuy();
                    break;
                case 3:
                    System.out.println(" (Sell)");
//                    mainFrame.setJMenuBar(loot.lootMenuBar());
                    mainFrame.revalidate();
                    mainFrame.repaint();
//                    loot.updateStats();
                    break;
                default:
//                    mainFrame.setJMenuBar(null);
                    mainFrame.revalidate();
                    mainFrame.repaint();
            }
        }

        public static void updateUI() {
            reloadTab();

        }
    }

    public static class frameResizedListener implements ComponentListener {
        @Override
        public void componentResized(ComponentEvent e) {
//            System.out.println("Frame Resized; " + times + "times");
            times++;
            main.Values.frameDimension = mainFrame.getSize();
//            System.out.println("Frame Dimensions: " + main.Values.frameDimension);
        }

        @Override
        public void componentMoved(ComponentEvent e) {

        }

        @Override
        public void componentShown(ComponentEvent e) {

        }

        @Override
        public void componentHidden(ComponentEvent e) {

        }
    }


}

