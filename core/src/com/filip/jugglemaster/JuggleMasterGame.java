package com.filip.jugglemaster;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.filip.jugglemaster.assets.Assets;
import com.filip.jugglemaster.screens.MainMenuScreen;
import com.filip.jugglemaster.screens.SplashScreen;
import com.filip.jugglemaster.services.ScoreService;
import com.filip.jugglemaster.services.SoundService;

public class JuggleMasterGame extends Game
{
	private static final String PREFS = "com.filip.jugglemaster.prefs";
	public static final String NAME = "Juggle Master";
	public static int WIDTH = 1000;
	public static int HEIGHT = 800;

	private boolean paused = false;

	private Preferences preferences;
	private ScoreService scoreService;
	private SoundService soundService;

	@Override
	public void create()
	{
		init();
		initScoreService();
		initAssets();
		initSoundService();
		this.setScreen(new MainMenuScreen(this));
	}

	private void initSoundService()
	{
		soundService = new SoundService();
	}

	private void initScoreService()
	{
		scoreService = new ScoreService(preferences);
	}


	private void initAssets()
	{
		Assets.load();
		Assets.manager.finishLoading();
	}

	private void init()
	{
		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();
		preferences = Gdx.app.getPreferences(PREFS);
		this.setScreen(new SplashScreen(this));
	}

	@Override
	public void dispose()
	{
		Assets.dispose();
	}

	@Override
	public void resume()
	{
		super.resume();
		Assets.load();
		Assets.manager.finishLoading();
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

	public ScoreService getScoreService()
	{
		return scoreService;
	}

	public SoundService getSoundService()
	{
		return soundService;
	}
}
