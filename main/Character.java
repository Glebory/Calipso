package com.trial.main;

public abstract class Character extends GameObject{
    protected int jumpHeight, health;
    protected boolean jump = false;
    protected boolean attack = false;
    private boolean left;
    GameObject currentAttack;
    public Character(int x, int y,int h, int w, ID id,int speed, int jumpHeight, int health, Handler handler) {
        super(x, y, h, w, id, speed,handler);
        this.jumpHeight = jumpHeight;

        this.health = health;
    }
    public void setJump(boolean jump){
        this.jump = jump;
    }
    public boolean getJump(){
        return jump;
    }
    public void setLeft() {
        left = true;
    }
    public void setRight(){
        left = false;
    }
    public boolean getAttack(){
        return attack;
    }
    public void punching(){
        int px = w/2;
        if (!left) {px = px*-1;}
        currentAttack = new Punch(x+px, y+(h/4), h*1/5, w*3/2, ID.Attack, speed+2, 5, left, handler);
        handler.addObject(currentAttack);
        attack = true;
    }
    public void stopPunch(){
        handler.removeObject(currentAttack);
    }
    public void collision(){
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getID() == ID.Attack){
                Attack atta = (Attack)tempObject;
                health = health - atta.damage;
            }

        }
    }
    public void jumping(){
        velY = jumpHeight;
        setJump(true);
    }
    public void stopJump(){
        velY = 0;
        y = Game.HEIGHT/4*3;
        jump = false;
    }
}
