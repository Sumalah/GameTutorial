package com.gametutorial.main;

import java.awt.*;

public class Player extends GameObject{

    Handler handler;

    public Player(float x, float y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        x = Game.clamp((int)x, 0, Game.WIDTH-37);
        y = Game.clamp((int)y, 0, Game.HEIGHT-62);

        colission();
    }

    private void colission() {
        for (int i = 0; i< handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.SmartEnemy){
                if(getBounds().intersects(tempObject.getBounds())){
                    //collision
                    HUD.HEALTH -= 2;
                }


            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect((int)x, (int)y, 32, 32);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 32, 32);
    }
}
