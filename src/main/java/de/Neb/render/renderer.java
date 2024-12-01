package de.Neb.render;

import de.Neb.Input;
import de.Neb.NebEngine;
import de.Neb.Window;

import java.awt.image.DataBufferInt;

import static de.Neb.NebEngine.getClearColor;


public class renderer {
    private final int pW, pH;
    private final int[] p;
    private final Input input;

    public renderer(NebEngine gc) {
        this.pW = gc.getWidth();
        this.pH = gc.getHeight();
        this.p = ((DataBufferInt) Window.getImage().getRaster().getDataBuffer()).getData();
        this.input = new Input(gc);
    }

    //Setzt alle pixel auf Schwarz.
    public void clear() {
        for (int i = 0; i < p.length; i++) {
            p[i] = getClearColor();
        }
    }

    //Macht an einen punkt ein pixel
    public void setPixel(int x, int y, int value) {
        //Schaut ob der pixel out of bounds ist
        if ((x < 0 || x >= pW || y < 0 || y >= pH) || value == 0xffff00ff) {
            return;
        }
        p[x + y * pW] = value;
    }

    public void fillRect(int offX, int offY, int x2, int y2, int color) {
        int startX = Math.min(offX, x2);
        int endX = Math.max(offX, x2);
        int startY = Math.min(offY, y2);
        int endY = Math.max(offY, y2);

        for (int y = startY; y < endY; y++) {
            for (int x = startX; x < endX; x++) {
                setPixel(x, y, color);
            }
        }
    }

    public void drawBoarder(int x, int y, int width, int height, int lineThickness,int color){

        fillRect(x, y, x + width, y + lineThickness, color);
        // Untere Linie
        fillRect(x, y + height - lineThickness, x + width, y + height, color);
        // Linke Linie
        fillRect(x, y, x + lineThickness, y + height, color);
        // Rechte Linie
        fillRect(x + width - lineThickness, y, x + width, y + height, color);
    }

}
