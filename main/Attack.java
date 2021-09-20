package com.trial.main;

import java.awt.*;

public class Attack extends GameObject{
    protected int damage;
    public Attack(int x, int y,int h, int w, ID id,int speed, int damage, boolean left, Handler handler){
            super(x, y, h, w, id, speed,handler);
            this.damage = damage;
            if (left){
            speed = speed*-1;}
            velX = speed;

    }
    public Rectangle getBBounds(){
        return new Rectangle(x, y, w, h);
    }
    public void tick() {}

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.drawRect(x, y, w, h);
    }
}
