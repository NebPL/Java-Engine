package de.Neb.Engine;

import de.Neb.NebEngine;
import de.Neb.Window;
import de.Neb.engine;
import de.Neb.renderer;

import java.awt.*;

/// This is just a Test.
///
/// This is just a Example.
public class renderl extends engine {

    ///Updates 60Fps your how fast you set it up
    @Override
    public void update(NebEngine ne, Float dt) {
    }

/// This updates also 60FPS
    @Override
    public void render(NebEngine ne, renderer r) {
        r.drawBoarder(10,10,100,100,1,0xFFFFFF);
    }
}
