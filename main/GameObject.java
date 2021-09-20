package com.trial.main;

import java.awt.*;

public abstract class GameObject {

    protected int x,y,h,w,velX,velY,speed;
    protected ID id;
    protected Handler handler;
    public GameObject(int x, int y,int h, int w, ID id, int speed, Handler handler){
        this.x = x;
        this.y = y;
        this.h = h;
        this.w = w;
        this.id = id;
        this.speed = speed;
        this.handler = handler;
    }
    public Rectangle getBBounds(){
        return new Rectangle(x, y, w, h);
    }
    public abstract void tick();
    public abstract void render(Graphics g);

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public void setH(int h){
        this.h = h;
    }
    public void setW(int w){
        this.w = w;
    }
    public int getH(){
        return h;
    }
    public int getW(){
        return w;
    }

    public void setID(ID id){
        this.id = id;
    }
    public ID getID(){
        return id;
    }


    public void setSpeed(int speed){this.speed = speed;}
    public int getSpeed(){return speed;}

    public void setVelX(int velX){
        this.velX = velX;
    }
    public void setVelY(int velY){
        this.velY = velY;
    }
    public int getVelX(){
        return velX;
    }
    public int getVelY(){
        return velY;
    }


}
