package de.Neb.Engine;

import de.Neb.NebEngine;
import de.Neb.Window;
import de.Neb.engine;
import de.Neb.renderer;

public class game extends engine {
    @Override
    public void update(NebEngine ne, Float dt) {
        System.out.println("Test");
    }

    @Override
    public void render(NebEngine ne, renderer r) {

    }

    public static void main(String args[]){



        NebEngine e = new NebEngine(new renderl());
        e.setHeight(1000);
        e.setWidth(1000);
        e.start();


    }
}
