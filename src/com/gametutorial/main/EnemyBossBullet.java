package com.gametutorial.main;

import java.awt.*;
import java.util.Random;

public class EnemyBossBullet extends GameObject{
    private Handler handler;
    private Random r = new Random();

    public EnemyBossBullet(float x, float y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velX = (r.nextInt(10)-5);
        velY = 5;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

//        if(y <= 0 || y>= Game.HEIGHT - 45){
//            velY *= -1;
//        }
//        if(x <= 0 || x>= Game.WIDTH - 16){
//            velX *= -1;
//        }

        if(y >= Game.HEIGHT) handler.removeObject(this);

        handler.addObject(new Trail(x, y, ID.Trail, Color.white, 16, 16, 0.02f, handler));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect((int)x, (int)y, 16, 16);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16, 16);
    }
}
