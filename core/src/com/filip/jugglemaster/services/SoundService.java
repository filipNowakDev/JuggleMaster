package com.filip.jugglemaster.services;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.filip.jugglemaster.assets.Assets;

public class SoundService
{
	private Sound kickSound;
	private Sound coinSound;
	private Music music;
	private OptionsService optionsService;

	public SoundService(OptionsService optionsService)
	{
		kickSound = Assets.manager.get(Assets.kick, Sound.class);
		coinSound = Assets.manager.get(Assets.ding, Sound.class);
		music = Assets.manager.get(Assets.music, Music.class);
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

	public void playMusic()
	{
		if(optionsService.isMusicEnabled())
		{
			music.setLooping(true);
			music.setVolume(0.5f);
			music.play();
			music.setLooping(true);
		}
	}

	public void stopMusic()
	{
		if(music.isPlaying())
			music.pause();
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
