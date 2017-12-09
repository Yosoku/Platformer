package framework;

import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Controller {
	private List<Actor> actors;
	
	public Controller()
	{
		actors = new ArrayList<>();
      //actors = new LinkedList<>();
	}

	public void update()
	{
		for(Actor actor : actors)
		{
			actor.update();
		}
	}
	
	public void render(Graphics g)
	{
		for(Actor actor : actors)
		{
			actor.render(g);
		}
	}
	public List<Actor> getActors() {
		return actors;
	}

	public void addActor(Actor actor)
	{
		this.actors.add(actor);
	}
	
	public void removeActor(Actor actor)
	{
		this.actors.remove(actor);
	}



}
