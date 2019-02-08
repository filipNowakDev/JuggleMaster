package com.filip.jugglemaster.services;

import com.badlogic.gdx.Preferences;
import com.filip.jugglemaster.assets.Assets;


public class BallService
{
	private String currentBall;
	private Preferences preferences;
	private static final String BALL = "com.filip.jugglemaster.prefs.current_ball";

	public BallService(Preferences preferences)
	{
		initPreferences(preferences);
		initBall();
	}

	private void initBall()
	{
		if (!preferences.contains(BALL))
			this.currentBall = Assets.ball;
		else
			this.currentBall = preferences.getString(BALL);
	}

	private void initPreferences(Preferences preferences)
	{
		this.preferences = preferences;
	}

	public String getCurrentBall()
	{
		return currentBall;
	}

	public void setCurrentBall(String currentBall)
	{
		this.currentBall = currentBall;
		preferences.putString(BALL, currentBall);
		preferences.flush();
	}
}
