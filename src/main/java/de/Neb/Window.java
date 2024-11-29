package de.Neb;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Window {
    private final JFrame frame;
    private static BufferedImage image = null;
    private static Canvas canvas = null;
    private static BufferStrategy bs;
    private static Graphics g;

    public Window(NebEngine gc) {
        frame = new JFrame(gc.getTitle());
        image = new BufferedImage(gc.getWidth(), gc.getHeight(), BufferedImage.TYPE_INT_RGB);
        canvas = new Canvas();

        Dimension s = new Dimension((int) (gc.getWidth() * gc.getScale()), (int) (gc.getHeight() * gc.getScale()));
        canvas.setPreferredSize(s);
        canvas.setMinimumSize(s);
        canvas.setMaximumSize(s);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(canvas, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        canvas.createBufferStrategy(2);
        bs = canvas.getBufferStrategy();
        g = bs.getDrawGraphics();
    }

    public static void update() {
        g.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
        bs.show();
    }


    public static Graphics getG() {
        if (bs != null) {
            return bs.getDrawGraphics();
        }
        return null;
    }
    public static BufferedImage getImage() {
        return image;
    }

    public static Canvas getCanvas() {
        return canvas;
    }
}
