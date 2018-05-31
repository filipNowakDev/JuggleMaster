package com.filip.jugglemaster.screens;

import com.badlogic.gdx.graphics.Texture;
import com.filip.jugglemaster.JuggleMasterGame;

public class SplashScreen extends AbstractScreen
{
	private Texture splashImage;

	public SplashScreen(JuggleMasterGame game)
	{
		super(game);
		init();
	}

	private void init()
	{
		//TODO Asset Manager
		splashImage = new Texture("footballpitchscaled.jpg");
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
