package com.filip.jugglemaster.services;

import com.badlogic.gdx.audio.Sound;
import com.filip.jugglemaster.assets.Assets;
import com.filip.jugglemaster.screens.OptionsScreen;

public class SoundService
{
	private Sound kickSound;
	private Sound coinSound;
	private OptionsService optionsService;

	public SoundService(OptionsService optionsService)
	{
		kickSound = Assets.manager.get(Assets.kick, Sound.class);
		coinSound = Assets.manager.get(Assets.ding, Sound.class);
		this.optionsService = optionsService;
	}

	public void playKickSound(float volume)
	{
		playSound(kickSound, volume);
	}

	public void playCoinSound(float volume)
	{
		playSound(coinSound, volume);
	}

	private void playSound(Sound sound, float volume)
	{
		if(optionsService.isSoundEnabled())
		{
			if (volume < 1f)
				sound.play(volume);
			else
				sound.play();
		}
	}


}
