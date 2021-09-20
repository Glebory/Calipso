package com.trial.main;

import java.awt.*;

public class HUD {
    public static int PlayerHealth = 100;
    public int OppHealth = 100;
    public int POWER = 6;
    public void tick(){

    }
    public void render(Graphics g){
        g.setColor(Color.GRAY);
        g.fillRect(15, 15, 400, 12);
        g.fillRect(Game.WIDTH-419, 15, 400, 12);
        if (PlayerHealth < 33){g.setColor(new Color(255,255,0));}
        else {g.setColor(new Color(50,205,50));}
        g.fillRect(19, 19, PlayerHealth*4-8, 4);
        if (OppHealth < 33){g.setColor(new Color(255,255,0));}
        else {g.setColor(new Color(50,205,50));}
        g.fillRect(Game.WIDTH-415, 19, OppHealth*4-8, 4);
    }
}
