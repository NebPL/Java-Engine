package de.Neb;

import de.Neb.render.renderer;

/**
 * Main Engine Fiele
 */
public class NebEngine implements Runnable {

    //Inits some Variables
    private double fpsLimit = 60.0;
    private final engine game;
    private Window window;
    private renderer renderer;
    private Input input;
    private Thread thread;
    private boolean running;
    private int width = 800;
    private int height = 800;
    private float scale = 1f;
    private String title = "Game";
    public double GameVersion = 1.0;
    public static int clearColor = 0x000000;

    public static int getClearColor(){
        return clearColor;
    }

    public double getGameVersion(){
        return GameVersion;
    }

    //When you init the engine you can put your engine and it will update automatic.
    public NebEngine(engine game) {this.game = game;}

    public void setFpsLimit(double fpsLimit) {
        this.fpsLimit = fpsLimit <= 0 ? 60.0 : fpsLimit;
    }

    public double getFpsLimit() {
        return fpsLimit;
    }

    private double getUpdateCap() {
        return 1.0 / fpsLimit;
    }

    //Makes stuff on start
    public void start() {
        window = new Window(this);
        input = new Input(this);
        renderer = new renderer(this);
        thread = new Thread(this);
        thread.start();
    }

    //Makes stuff on stop
    public void stop() {
        running = false;
    }

    //Is the main loop
    @Override
    public void run() {
        running = true;

        boolean render;
        double firstTime;
        double lastTime = System.nanoTime() / 1_000_000_000.0;
        double passedTime;
        double unprocessedTime = 0.0;

        double frameTime = 0.0;
        int frames = 0;
        int fps = 0;

        //Main loop
        while (running) {
            render = false;
            //ka was das macht. Habe ja die Engine Kopiert :D.
            //Aber sonst so wie geht es? Steh mahl auf
            //Bei mir gerade ist es 21:43 am Donnerstag am 28 Nov.
            //Ich bin gespannt ob ich die Aufnahmeprüfung schaffe.
            firstTime = System.nanoTime() / 1_000_000_000.0;
            passedTime = firstTime - lastTime;
            lastTime = firstTime;

            unprocessedTime += passedTime;
            frameTime += passedTime;

            //Fps loop
            while (unprocessedTime >= getUpdateCap()) {
                unprocessedTime -= getUpdateCap();

                // Update logik
                if (game != null) {
                    game.update(this, (float) getUpdateCap());
                }
                if (input != null) {
                    input.update();
                }

                render = true;

                if (frameTime >= 1.0) {
                    frameTime = 0.0;
                    fps = frames;
                    frames = 0;
                }
            }
            //render
            if (render) {
                if (renderer != null) {
                    renderer.clear();

                    if (game != null) {
                        game.render(this, renderer);
                    }
                    if (window != null) {
                        window.update();
                    }
                    frames++;
                }
            } else {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        dispose();
    }

    private void dispose() {
        // Ressourcen freigeben
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
