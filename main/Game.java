package com.trial.main;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.Serial;

public class Game extends Canvas implements Runnable{

    @Serial
    private static final long serialVersionUID = 1283277483743847548L;

    public static final int WIDTH = 1080, HEIGHT = WIDTH/12*9;
    private Thread thread;
    private boolean running = false;
    private Image img = Toolkit.getDefaultToolkit().createImage("one_piece.jpg");
    private Handler handler;
    private HUD hud;
    /*private Background background;*/

    public Game(){
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
        new Window(WIDTH, HEIGHT, "Work in progress", this);
        hud = new HUD();
        /*background = new Background();*/
        handler.addObject( new Player(WIDTH/4, HEIGHT/4*3,128,32, ID.Player, -13,1, 100, handler));
        /*handler.addObject( new BasicEnemy(WIDTH/4*3, HEIGHT/4*3,64,32, ID.Enemy, -15,5, handler));*/
        handler.addObject( new Player(WIDTH/4, HEIGHT/4*3,128, 32, ID.Player2, -15,1, 100, handler));
    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        try {
            thread.join();
            running = false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void run(){
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOFTicks = 60.0;
        double ns = 1000000000 / amountOFTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: "+ frames);
                frames = 0;
            }
        }
        stop();
    }
    private void tick(){
        handler.tick();
        hud.tick();
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0,0,WIDTH, HEIGHT);
        /*background.paint(g);*/

        handler.render(g);
        hud.render(g);
        g.dispose();
        bs.show();
    }
    public static void main(String[] args) {
        new Game();
    }
}
