package de.Neb.Engine;

import de.Neb.NebEngine;
import de.Neb.engine;
import de.Neb.render.renderer;

public class game {

    public static void main(String args[]){
        NebEngine e = new NebEngine(new rendergame());
        e.setHeight(1000);
        e.setWidth(1000);
        e.start();
    }
}
