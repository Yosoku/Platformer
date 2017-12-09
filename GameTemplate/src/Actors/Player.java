package Actors;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import framework.Actor;
import framework.ActorID;

public class Player extends Actor{
	public static final int HEIGHT_FACTOR = 2;
	public static final int WIDTH_FACTOR = 1;
	public Player(float x, float y, ActorID id) {
		super(x, y,id,WIDTH_FACTOR,HEIGHT_FACTOR);
		
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g; 
		g2d.setColor(Color.blue);
		g2d.fillRect((int)x,(int) y,(int) this.getWidth(), (int)this.getHeight());
		g2d.setColor(Color.red);
		g2d.draw(getCollisionBounds());
		
	}

	@Override
	public void update() {
		x = x + velX;
		y = y + velY;
	}
	
	

}
