package Actors;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;

import framework.Actor;
import framework.ActorID;

public class Block extends Actor{
	public static final int WIDTH_FACTOR = 1;
	public static final int HEIGHT_FACTOR = 1;
		
	
	public Block(float x, float y, ActorID id) {
		super(x,y,id,WIDTH_FACTOR,HEIGHT_FACTOR);
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.WHITE);
		g2d.fillRect((int)this.x, (int)this.y, 32, 32);
	}

	@Override
	public void update() {
		//Blocks aren't currently updating
		
	}
	
	
}
