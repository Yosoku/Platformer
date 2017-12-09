package framework;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Actor {
	protected ActorID id;
	protected float width = 32,height = 32;
	protected float x, y;
	protected float velX = 0, velY = 0;

	public Actor(float x, float y,ActorID id,int WIDTH_FACTOR,int HEIGHT_FACTOR) {
		this.id = id;
		this.x = x;
		this.y = y;
		width*=WIDTH_FACTOR;
		height*= HEIGHT_FACTOR;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public abstract void render(Graphics g);

	public abstract void update();

	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public float getVelX() {
		return velX;
	}
	public void setVelX(float velX) {
		this.velX = velX;
	}
	public float getVelY() {
		return velY;
	}
	public void setVelY(float velY) {
		this.velY = velY;
	}
	public ActorID getID(){
		return this.id;
	}
	
	public Rectangle getCollisionBounds()
	{
		return new Rectangle((int)this.x,(int)this.y,(int)this.getWidth()+1,(int)this.getHeight()+1);
	}
	
}
