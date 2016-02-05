package com.gametutorial.main;

import java.util.Random;

public class Spawn {

    private Handler handler;
    private HUD hud;
    private Random r;
    private int scoreKeep = 0;

    public Spawn(Handler handler, HUD hud){
        this.handler = handler;
        this.hud = hud;
        r = new Random();
    }

    public void tick(){
        scoreKeep++;

        if(scoreKeep >= 400){
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);
            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
        }
    }
}
