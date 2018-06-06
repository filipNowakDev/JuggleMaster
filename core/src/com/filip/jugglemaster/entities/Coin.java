package com.filip.jugglemaster.entities;

public class Coin extends AnimatedActor
{
	public Coin(int x, int y)
	{
		super("coin-sheet-scaled.png", 14, 1);
		setX(x);
		setY(y);
		setOrigin(getWidth()/2, getHeight()/2);
	}
}
