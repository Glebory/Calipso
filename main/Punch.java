package com.trial.main;

public class Punch extends Attack{
    final int DAMAGE = 5;
    int damage = DAMAGE;
    int buildUp = 100;
    Handler handler;
    public Punch(int x, int y,int h, int w, ID id,int speed, int damage, boolean left, Handler handler){
        super(x, y, h, w, id, speed, damage, left, handler);
    }

    public void tick(){
        x += velX;
        y += velY;
        buildUp--;
        if (buildUp<51) velX = velX*-1;
    }

}
