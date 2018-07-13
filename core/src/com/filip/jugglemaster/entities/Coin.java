package com.filip.jugglemaster.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.filip.jugglemaster.assets.Assets;

public class Coin extends AnimatedActor
{

	private Sound ding;
	public Coin(int x, int y)
	{
		super(Assets.coin, 14, 1, Gdx.graphics.getWidth()/13);
		ding = Assets.manager.get(Assets.ding, Sound.class);
		setX(x);
		setY(y);
		setOrigin(getWidth()/2, getHeight()/2);
	}

	public void onCollision()
	{
		ding.play();
		Coin.this.remove();
	}
}
