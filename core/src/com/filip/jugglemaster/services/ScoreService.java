package com.filip.jugglemaster.services;

import com.badlogic.gdx.Preferences;

public class ScoreService
{

	private static final String RECORD = "com.filip.jugglemaster.prefs.record";
	private int points = 0;
	private int maxPoints = 0;
	private Preferences preferences;

	public ScoreService(Preferences preferences)
	{
		this.preferences = preferences;
		loadRecord();
	}


	private void loadRecord()
	{
		maxPoints = preferences.getInteger(RECORD);
	}

	public void addPoint()
	{
		points++;
		updateMaxPoints();
	}

	public void addPoints(int i)
	{
		points += i;
		updateMaxPoints();

	}

	private void updateMaxPoints()
	{
		if (points > maxPoints)
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


	//------
	public int getPoints()
	{
		return points;
	}

	public int getMaxPoints()
	{
		return maxPoints;
	}
}
