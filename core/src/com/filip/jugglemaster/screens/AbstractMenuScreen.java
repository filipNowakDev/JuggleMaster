package com.filip.jugglemaster.screens;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.filip.jugglemaster.JuggleMasterGame;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMenuScreen extends AbstractScreen
{

	private List<Actor> itemList;

	public AbstractMenuScreen(JuggleMasterGame game)
	{
		super(game);
		itemList = new ArrayList<Actor>();
	}

	public void addToBottom(Actor actor)
	{
		itemList.add(actor);
		stage.addActor(actor);
		updatePositions();
	}

	private void updatePositions()
	{
		for(int i = 0; i < itemList.size(); i++)
		{
			Actor actor = itemList.get(i);
			actor.setPosition(stage.getWidth() / 2 - actor.getWidth() / 2, ((itemList.size() - i) * stage.getHeight() / (itemList.size() + 1)) - actor.getHeight() / 2);
		}
	}


}
