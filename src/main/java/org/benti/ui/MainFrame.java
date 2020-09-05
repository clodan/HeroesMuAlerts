package org.benti.ui;

import org.benti.ui.panels.MainPanel;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainFrame extends JFrame {

    private static final String TITLE = "Heroes-Mu Alert";
    private static final int WINDOW_HEIGHT = 430;
    private static final int WINDOW_WIDTH = 350;
    private static JFrame FRAME;

    public MainFrame() {
        super(TITLE);
        FRAME = this;
        initializeWindow();
    }

    private void initializeWindow() {
        this.setResizable(false);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        try {
            InputStream is = MainFrame.class.getResourceAsStream("/img/bell.png");
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int nRead;
            byte[] data = new byte[16384];
            while ((nRead = is.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }
            Image icon = toolkit.createImage(buffer.toByteArray());
            this.setIconImage(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setMinimumSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        this.setLocation(x, y);
        this.getContentPane().add(new MainPanel());
    }

    public static JFrame getFrame() {
        return FRAME;
    }

}
