package de.Neb;


import de.Neb.render.renderer;

public abstract class engine {
    /// Mact es einfach so das geUpdatet werden kann so schnell wie die Fps
    ///
    ///Es ist so das in der Main Klasse (NebEngine) diese argumente gefühlt werden.
    public abstract void update(NebEngine ne, Float dt);
    ///Macht es einfach so das gerendert werden kann.
    ///
    /// Es ist so das in der Main Klasse (NebEngine) diese argumente gefühlt werden.
    public abstract void render(NebEngine ne, renderer r);


}