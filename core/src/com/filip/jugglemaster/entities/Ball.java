package com.filip.jugglemaster.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Ball extends Image
{
	private static final int width = 100;
	private static final int height = 100;
	private static final int starting_x = 200;
	private static final int starting_y = 50;

	public Ball()
	{
		super(new Texture("SoccerBall.jpg"));

		this.setOrigin(width/2, height/2);
		this.setScale(width, height);
		this.setPosition(starting_x, starting_y);

	}
}
