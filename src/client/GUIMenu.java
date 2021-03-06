package client;


import main.Values;
import server.serverMain;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created 10/29/15
 * Software Development
 * TSA Conference, 2016
 * GUIMenu: Class containing code that starts server and client programs
 */
public class GUIMenu {

    public static JFrame frame;
    public static JPanel base;
    public static JButton startServer, joinGame;
    public static JLabel panelIcon;

    public Image getFrameIcon() {
        BufferedImage fIcon;
        try {
            fIcon = ImageIO.read(getClass().getResource("/rsc/EcoFIcon.png"));
        } catch (Exception e) {
            System.err.println("Can't load Frame Icon");
            return null;
        }
        return fIcon;
    }

    public static class PaneFrameMain implements ActionListener {
        public static void createGUI() throws IOException {

            //Create and render GUI
            GUIMenu icon = new GUIMenu();
            frame = new JFrame(Values.HEADER);
            frame.setMinimumSize(new Dimension(400, 600));
            frame.setMaximumSize(new Dimension(400, 600));
            JFrame.setDefaultLookAndFeelDecorated(false);
            PaneFrameMain index = new PaneFrameMain();
            frame.getContentPane().add(index.paneContent());
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setBackground(new Color(145, 255, 108));
            frame.setIconImage(icon.getFrameIcon());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }

        public JPanel paneContent() throws IOException {
            base = new JPanel();
            base.setBackground(new Color(198, 240, 198));
            base.setLayout(null);
            base.setSize(400, 600);

            //Add Logo
            BufferedImage pb = null;
            try {
                pb = ImageIO.read(getClass().getResource("/rsc/EcoBanner.png"));
                panelIcon = new JLabel(new ImageIcon(pb));
                panelIcon.setLocation(50, 50);
                panelIcon.setSize(300, 150);
                panelIcon.setHorizontalAlignment(SwingConstants.CENTER);
                panelIcon.setVerticalAlignment(SwingConstants.CENTER);
                base.add(panelIcon);
            } catch (IOException e) {
                System.out.println("Can't load image");
            } catch (IllegalArgumentException u) {
                System.out.println("We can't find the picture! C");
            }
            assert pb != null;

            //Start Client Button
            joinGame = new JButton("Join Game");
            joinGame.addActionListener(this);
            joinGame.setSize(200, 50);
            joinGame.setLocation(100, 225);
            joinGame.setSelected(false);
            joinGame.setBorder(BorderFactory.createLineBorder(new Color(92, 92, 92), 2));
            base.add(joinGame);

            //Start Server button
            startServer = new JButton("Start Server");
            startServer.addActionListener(this);
            startServer.setSize(200, 50);
            startServer.setLocation(100, 325);
            startServer.setSelected(false);
            startServer.setBorder(BorderFactory.createLineBorder(new Color(92, 92, 92), 2));
            base.add(startServer);

            return base;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // If Client Start button is pushed
            if (e.getSource() == joinGame) {
                String IP = null;
                boolean ipValid = false;
                while (!ipValid) {
                    IP = (String) JOptionPane.showInputDialog(joinGame, "Enter the IP address of the Server:", "Join Game", JOptionPane.PLAIN_MESSAGE, null, null, null);
                    System.out.println(IP);
                    if (IP == null) break;
                    ipValid = true;
                }
                if (ipValid) {
                    GUIOverview.namePlayer = (String) JOptionPane.showInputDialog(joinGame, "Enter your username:", "Join Game", JOptionPane.PLAIN_MESSAGE, null, null, null);
                    if (GUIOverview.namePlayer == null) {
                        GUIOverview.namePlayer = "Lazy SOB";
                    }
                    System.out.println("It connected!");
                    frame.setVisible(false); //you can't see me!
                    frame.dispose(); //Destroy the JFrame object
                    clientMain.startClient(IP);
                }
                // If Server Start button is pushed
            } else if (e.getSource() == startServer) {
                frame.setVisible(false); //you can't see me!
                frame.dispose(); //Destroy the JFrame object
                serverMain.startServer();
            }

        }
    }
}

