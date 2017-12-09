package framework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	private Controller controller;
	
	public KeyInput(Controller controller)
	{
		this.controller = controller;
	}
	
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		for(Actor actor : controller.getActors())
		{
			if(actor.getID() == ActorID.Player)
			{
				switch(key)
				{
					case KeyEvent.VK_D:
						actor.setVelX(5);
						break;
					case KeyEvent.VK_A:
						actor.setVelX(-5);	
						break;
					case KeyEvent.VK_W:
						actor.setVelY(-5);
						break;
					case KeyEvent.VK_S:
						actor.setVelY(5);
						break;
						
				}
			}
		}
	}
	
	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();
		for(Actor actor : controller.getActors())
		{
			if(actor.getID() == ActorID.Player)
			{
				switch(key)
				{
					case KeyEvent.VK_D:
						actor.setVelX(0);
						break;
					case KeyEvent.VK_A:
						actor.setVelX(0);
						break;
					case KeyEvent.VK_W:
						actor.setVelY(0);
						break;
					case KeyEvent.VK_S:
						actor.setVelY(0);
						break;
				}
			}
		}
			
	}
}
