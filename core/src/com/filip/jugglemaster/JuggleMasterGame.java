package com.filip.jugglemaster;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.filip.jugglemaster.screens.SplashScreen;

public class JuggleMasterGame extends Game
{
	private static final String  PREFS = "com.filip.jugglemaster.prefs";
	private static final String  RECORD = "com.filip.jugglemaster.prefs.record";


	public static final String NAME = "Juggle Master";
	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;
	private boolean paused = false;
	private int points = 0;
	private int maxPoints = 0;
	private Preferences preferences;

	@Override
	public void create()
	{
		init();
		this.setScreen(new SplashScreen(this));
	}

	private void init()
	{
		preferences = Gdx.app.getPreferences(PREFS);
		loadRecord();
	}

	private void loadRecord()
	{
		maxPoints = preferences.getInteger(RECORD);
	}


	@Override
	public void dispose()
	{
	}


	public void addPoint()
	{
		points++;
		updateMaxPoins();
	}

	public void addPoints(int i)
	{
		points += i;
		updateMaxPoins();

	}

	private void updateMaxPoins()
	{
		if(points > maxPoints)
		{
			maxPoints = points;
			preferences.putInteger(RECORD, maxPoints);
			preferences.flush();
		}
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

	public int getMaxPoints()
	{
		return maxPoints;
	}


}
