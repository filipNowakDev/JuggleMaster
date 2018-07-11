package com.filip.jugglemaster.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Timer;
import com.filip.jugglemaster.JuggleMasterGame;

public class SplashScreen extends AbstractScreen
{
	private Texture splashImage;

	public SplashScreen(final JuggleMasterGame game)
	{
		super(game);
/*
		Timer.schedule(new Timer.Task(){
			@Override
			public void run()
			{
				game.setScreen(new GameplayScreen(game));
			}
		}, 1);
*/
	}

	@Override
	protected void init()
	{
		splashImage = new Texture("images/Splashscaled.jpg");
	}

	@Override
	public void render(float delta)
	{
		super.render(delta);
		batch.begin();
		batch.draw(splashImage, 0, 0);
		batch.end();
	}
}
