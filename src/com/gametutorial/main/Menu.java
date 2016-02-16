package com.gametutorial.main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter{

    private Game game;
    private Handler handler;
    private Random r = new Random();

    public Menu(Game game, Handler handler){
        this.handler = handler;
        this.game = game;
    }

    public void mouseReleased(MouseEvent e){

    }

    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();

        if(mouseOver(mx, my, 210, 150, 200, 64)){
            game.gameState = Game.STATE.Game;
            handler.addObject(new Player(100, 100, ID.Player, handler));
            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
            handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
        }

        if(mouseOver(mx, my, 210, 350, 200, 64)){
            System.exit(1);
        }
    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        if(mx > x && mx < x + width){
            if(my > y && my < y + height){
                return true;
            }
        }
        return false;
    }

    public void tick(){

    }

    public void render(Graphics g){
        Font fnt = new Font("arial", 1, 50);
        Font fnt2 = new Font("arial", 1, 30);

        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("Menu", 240, 70);

        g.setFont(fnt2);
        g.drawRect(210, 150, 200, 64);
        g.drawString("Play", 270, 190);

        g.drawRect(210, 250, 200, 64);
        g.drawString("Help", 270, 290);

        g.drawRect(210, 350, 200, 64);
        g.drawString("Quit", 270, 390);
    }
}
