package com.filip.jugglemaster.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Scaling;
import com.filip.jugglemaster.JuggleMasterGame;
import com.filip.jugglemaster.assets.Assets;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMenuScreen extends AbstractScreen
{

	private List<Actor> itemList;

	public AbstractMenuScreen(JuggleMasterGame game)
	{
		super(game);

	}

	@Override
	protected void init()
	{
		itemList = new ArrayList<Actor>();
		initBackground();
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

	private void initBackground()
	{
		Image backgroundImage = new Image(Assets.manager.get(Assets.background, Texture.class));
		backgroundImage.setScaling(Scaling.fill);
		backgroundImage.setPosition(Gdx.graphics.getWidth() / 2 - backgroundImage.getWidth() / 2,
				Gdx.graphics.getHeight() / 2 - backgroundImage.getHeight() / 2);
		stage.addActor(backgroundImage);
	}

}
