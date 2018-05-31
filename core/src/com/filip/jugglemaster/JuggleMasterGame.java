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
	public static final int HEIGHT = 800;
	private boolean paused = false;
	private int points = 0;

	@Override
	public void create()
	{
		this.setScreen(new SplashScreen(this));
	}


	@Override
	public void dispose()
	{
	}


	public void addPoint()
	{
		points++;
	}
	public void resetPoints()
	{
		points = 0;
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

	public int getPoints()
	{
		return points;
	}

}
