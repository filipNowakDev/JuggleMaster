package com.filip.jugglemaster.services;


import com.badlogic.gdx.Preferences;

public class OptionsService
{
	private Preferences preferences;
	private static final String SOUND = "com.filip.jugglemaster.prefs.sound";
	private static final String MUSIC = "com.filip.jugglemaster.prefs.music";

	private boolean soundEnabled;
	private boolean musicEnabled;


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

		if(!preferences.contains(MUSIC))
		{
			preferences.putBoolean(MUSIC, true);
			preferences.flush();

		}
	}

	private void loadOptions()
	{
		this.soundEnabled = preferences.getBoolean(SOUND);
		this.musicEnabled = preferences.getBoolean(MUSIC);
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

	public boolean isMusicEnabled()
	{
		return musicEnabled;
	}

	public void setMusicEnabled(boolean musicEnabled)
	{
		preferences.putBoolean(MUSIC, musicEnabled);
		preferences.flush();
		this.musicEnabled = musicEnabled;
	}
}
