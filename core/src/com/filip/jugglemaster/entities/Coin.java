package com.filip.jugglemaster.entities;

import com.badlogic.gdx.Gdx;
import com.filip.jugglemaster.assets.Assets;
import com.filip.jugglemaster.services.SoundService;

public class Coin extends AnimatedActor
{

	private SoundService soundService;

	public Coin(int x, int y, SoundService soundService)
	{
		super(Assets.coin, 14, 1, Gdx.graphics.getWidth() / 13);
		this.soundService = soundService;
		setX(x);
		setY(y);
		setOrigin(getWidth() / 2, getHeight() / 2);
	}

	public void onCollision()
	{
		soundService.playCoinSound(1);
		Coin.this.remove();
	}
}
