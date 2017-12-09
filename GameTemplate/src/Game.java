import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import Actors.Block;
import Actors.Player;
import framework.ActorID;
import framework.Controller;
import framework.KeyInput;

@SuppressWarnings("serial")
public class Game extends Canvas implements Runnable{
	
	
	BufferedImage level = null;
	private boolean running = false;
	private Thread thread;
	Controller controller;
	public synchronized void start()
	{
		if(running)
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	
	private synchronized void stop()
	{
		if(!running)
			return;
		
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void init() {
		controller = new Controller();
		
		BufferedImageLoader loader = new BufferedImageLoader("level.png");
		level = loader.loadBufferedImage();
		loadImageLevel(level);
		this.addKeyListener(new KeyInput(controller));
	}
	@Override
	public void run() {
		init();
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000/amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running)
		{
			long now = System.nanoTime();
			delta = delta + (now - lastTime)/ns;
			lastTime = now;
			while(delta>=1)
			{
				update();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer >1000)
			{
				timer = timer + 1000;
				System.out.println("FPS: " + frames + " "+ "Ticks: " + updates);
				frames = 0;
				updates = 0;				
			}
			
		}
		stop();
		
	}


	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		////////////
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		controller.render(g);														//Modify only the part between comments
		
		////////////
		g.dispose();
		bs.show();
		
	}
	private void update() {
		controller.update();
		
	}
	
	
	private void loadImageLevel(BufferedImage image)
	{
		int width = image.getWidth();
		int height = image.getHeight();
	
		
		//Looping every pixel of @param image
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Color pixel = new Color(image.getRGB(i, j));
				if(pixel.equals(Color.white)) {
					controller.addActor(new Block(i*32,j*32,ActorID.Block));
				}
				if (pixel.equals(Color.blue)) {
					controller.addActor(new Player(i*32,j*32,ActorID.Player));
				}
					if(pixel == Color.yellow) {}
					//translate this to coins or sth
				if(pixel == Color.red) {}
					//translate this to enemy
				
			}
		}
	}
	public static void main(String[] args)
	{
		new Window(1120,960,new Game(),"Makis");
	}

}












