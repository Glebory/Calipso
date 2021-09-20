/**Player class with player functionality for player one and two
 * @author Glebory
 * @version 0.1a
 * @since 2021-09-16
 */
package com.trial.main;

import java.awt.*;


public class Player extends Character{
    /**
     * This method constructs the player object
     * @param x location of player hit box upper left corner on x axis
     * @param y location of player hit box upper left corner on y axis
     * @param h length of hit box
     * @param w width of hit box
     * @param id a unique id given to each game objects
     * @param jumpHeight initial velocity of in y axis
     * @param speed velocity usually for x axis
     * @param health player object's health
     * @param handler the handler object for the whole game
     */
    private int buildUp = 200;
    private Handler handler;
    public Player(int x, int y,int h, int w, ID id, int jumpHeight,int speed, int health, Handler handler){
        super(x, y, h, w, id, jumpHeight, speed, health, handler);
        this.handler = handler;
    }

    /**
     * This method gets called in the main game loop, all changes to position
     * and collision happen here.
     */
    public void tick(){
        x += velX;
        y += velY;
        if (y > Game.HEIGHT/4*3){stopJump();}
        else{velY += 1.3;}
        if (attack) {
            buildUp--;
            if (buildUp < 1) stopPunch();}

        collision();
    }

    /**
     * This method creates a rectangle object in the player object's shape.
     * @return rectangle object with same dimensions as player hitbox
     */
    public Rectangle getBBounds(){
        return new Rectangle(x, y, w, h);
    }
    public void render(Graphics g){
        if(id == ID.Player) g.setColor(Color.yellow);
        else g.setColor(Color.orange);
        g.drawRect(x, y, w, h);
    }
}
