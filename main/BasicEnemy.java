package com.trial.main;

import java.awt.*;

public class BasicEnemy extends Character{

    public int buildUp = 0;
    public boolean attacking = false;
    Handler handler;
    public BasicEnemy(int x, int y,int h, int w, ID id, int jumpHeight,int speed, int health, Handler handler){
        super(x, y, h, w, id, jumpHeight, speed, health, handler);
    }

    public Rectangle getBBounds(){
        return new Rectangle(x, y, w, h);
    }
    public Rectangle getABounds(){
        return new Rectangle(x+32, y, 96, 64);
    }
    public void tick(){
        x += velX;
        y += velY;
        if (y > Game.HEIGHT/4*3){stopJump();}
        else{velY += 1.3;}
        inRange();
        if (attacking){
            if(buildUp > 0){
                buildUp--;
            }
            else{
                attack();
            }
        }
    }
    public void inRange(){
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getID() == ID.Player){
                if(getABounds().intersects(tempObject.getBBounds())&&!attacking){
                    readyAttack();
                }
                else{
                    moveTo(tempObject);
                }
            }
        }
    }
    public void readyAttack(){
        buildUp = 100;
        attacking = true;
    }
    public void moveTo(GameObject tempObject){
        velX = speed*(Integer.signum( tempObject.x - x));
        if(tempObject.y + tempObject.h < y){
            jumping();
        }
    }
    public void attack(){
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getID() == ID.Player){
                if(getABounds().intersects(tempObject.getBBounds())){
                    HUD.PlayerHealth -= 12;
                }
            }
        }
        attacking = false;
    }

    public void render(Graphics g){
        g.setColor(Color.yellow);
        g.fillRect(x, y, w, h);
    }
}
