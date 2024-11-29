package de.Neb;

import java.awt.event.*;

public class Input implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {
    private final boolean[] keys = new boolean[256];
    private final boolean[] keysLast = new boolean[256];
    private final boolean[] buttons = new boolean[5];
    private final boolean[] buttonLast = new boolean[5];
    private int mouseX, mouseY, scroll;

    public Input(NebEngine gc) {
        Window.getCanvas().addKeyListener(this);
        Window.getCanvas().addMouseListener(this);
        Window.getCanvas().addMouseMotionListener(this);
        Window.getCanvas().addMouseWheelListener(this);
    }

    public void update() {
        System.arraycopy(keys, 0, keysLast, 0, keys.length);
        System.arraycopy(buttons, 0, buttonLast, 0, buttons.length);
    }

    public boolean isKey(int keyCode) {
        return keys[keyCode];
    }

    public boolean isKeyUp(int keyCode) {
        return !keys[keyCode] && keysLast[keyCode];
    }

    public boolean isKeyDown(int keyCode) {
        return keys[keyCode] && !keysLast[keyCode];
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        buttons[e.getButton()] = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        buttons[e.getButton()] = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        scroll = e.getWheelRotation();
    }
}
