package com.trial.main;

import java.awt.*;
import java.util.LinkedList;

public class Handler {
    LinkedList<GameObject> object = new LinkedList<GameObject>();
    LinkedList<Character> character = new LinkedList<Character>();
    public void tick(){
        for(int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);
            tempObject.tick();
        }
    }
    public void render(Graphics g){
        for(int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);

            tempObject.render(g);
        }
    }

    public void addObject(GameObject object){
        this.object.add(object);

    }

    public void addCharacter(Character character){
        this.character.add(character);
    }

    public void removeObject(GameObject object){
        this.object.remove(object);
    }
    public void removeChar(Character character){
        this.character.remove(character);
    }

}
