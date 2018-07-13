package com.filip.jugglemaster.services;

import com.badlogic.gdx.audio.Sound;
import com.filip.jugglemaster.assets.Assets;

public class SoundService
{
	private Sound kickSound;
	private Sound coinSound;

	public SoundService()
	{
		kickSound = Assets.manager.get(Assets.kick, Sound.class);
		coinSound = Assets.manager.get(Assets.ding, Sound.class);
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
		if (volume < 1f)
			sound.play(volume);
		else
			sound.play();
	}


}
