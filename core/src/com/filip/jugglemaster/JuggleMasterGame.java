package com.filip.jugglemaster;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.filip.jugglemaster.screens.SplashScreen;

public class JuggleMasterGame extends Game
{
	public static final String NAME = "Juggle Master";
	public static final int WIDTH = 480;
	public static final int HEIGHT = 700;
	private boolean paused;

	@Override
	public void create()
	{
		this.setScreen(new SplashScreen(this));
	}


	@Override
	public void dispose()
	{
	}

	//------------------------------------------------
	public boolean isPaused()
	{
		return paused;
	}

	public void setPaused(boolean paused)
	{
		this.paused = paused;
	}
}
