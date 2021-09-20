package com.trial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;

    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if (tempObject instanceof Character) {
                Character character = (Character)tempObject;
                if (tempObject.getID() == ID.Player) {
                    if (key == KeyEvent.VK_W && !character.getJump()) tempObject.setVelY(tempObject.speed); character.setJump(true);
                    if (key == KeyEvent.VK_A) tempObject.setVelX(tempObject.speed); character.setLeft();
                    /*if (key == KeyEvent.VK_S) tempObject.setVelY(5);*/
                    if (key == KeyEvent.VK_D) tempObject.setVelX(tempObject.speed * -1); character.setRight();
                    if (key == KeyEvent.VK_E && !character.getAttack()) character.punching();
                }
                if (tempObject.getID() == ID.Player2) {
                    if (key == KeyEvent.VK_UP) tempObject.setVelY(tempObject.speed);
                    if (key == KeyEvent.VK_LEFT) tempObject.setVelX(tempObject.speed);
                    /*if (key == KeyEvent.VK_DOWN) tempObject.setVelY(5);*/
                    if (key == KeyEvent.VK_RIGHT) tempObject.setVelX(tempObject.speed * -1);
                }
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getID() == ID.Player) {
                /*if (key == KeyEvent.VK_W) tempObject.setVelY(0);*/
                if (key == KeyEvent.VK_A) tempObject.setVelX(0);
                /*if (key == KeyEvent.VK_S) tempObject.setVelY(0);*/
                if (key == KeyEvent.VK_D) tempObject.setVelX(0);
            }
            if (tempObject.getID() == ID.Player2) {
                /*if (key == KeyEvent.VK_UP) tempObject.setVelY(0);*/
                if (key == KeyEvent.VK_RIGHT) tempObject.setVelX(0);
                /*if (key == KeyEvent.VK_DOWN) tempObject.setVelY(0);*/
                if (key == KeyEvent.VK_LEFT) tempObject.setVelX(0);
            }
        }
    }
}
