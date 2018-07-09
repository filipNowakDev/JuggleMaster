package com.filip.jugglemaster.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class Coin extends AnimatedActor
{

	private Sound ding;
	public Coin(int x, int y)
	{
		super("coin-sheet-scaled.png", 14, 1);
		ding = Gdx.audio.newSound(Gdx.files.internal("ding.mp3"));
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
