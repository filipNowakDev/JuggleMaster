package com.filip.jugglemaster.services;


import com.badlogic.gdx.Preferences;

public class OptionsService
{
	private static final String SOUND = "com.filip.jugglemaster.prefs.sound";
	private Preferences preferences;
	private boolean soundEnabled;


	public OptionsService(Preferences preferences)
	{
		this.preferences = preferences;
		initOptions();
		loadOptions();
	}

	private void initOptions()
	{
		if(!preferences.contains(SOUND))
		{
			preferences.putBoolean(SOUND, true);
			preferences.flush();

		}
	}

	private void loadOptions()
	{
		this.soundEnabled = preferences.getBoolean(SOUND);
	}

	public boolean isSoundEnabled()
	{
		return soundEnabled;
	}

	public void setSoundEnabled(boolean soundEnabled)
	{
		preferences.putBoolean(SOUND, soundEnabled);
		preferences.flush();
		this.soundEnabled = soundEnabled;
	}
}
