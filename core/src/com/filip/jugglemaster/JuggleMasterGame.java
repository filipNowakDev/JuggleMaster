package com.filip.jugglemaster;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.filip.jugglemaster.assets.Assets;
import com.filip.jugglemaster.screens.GameplayScreen;
import com.filip.jugglemaster.screens.SplashScreen;
import com.filip.jugglemaster.services.ScoreService;

public class JuggleMasterGame extends Game
{
	private static final String  PREFS = "com.filip.jugglemaster.prefs";



	public static final String NAME = "Juggle Master";
	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;

	private boolean paused = false;

	private Preferences preferences;
	private ScoreService scoreService;

	@Override
	public void create()
	{
		init();
		initScoreService();
		initAssets();
		this.setScreen(new GameplayScreen(this));
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
}
