package com.filip.jugglemaster.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Ball extends Image
{
	private static final int width = 100;
	private static final int height = 100;
	private static final int starting_x = 200;
	private static final int starting_y = 0;

	public Ball()
	{
		super(new Texture("SoccerBall.png"));

		this.setOrigin(width/2, height/2);
		this.setSize(width, height);
		this.setPosition(starting_x, starting_y);

	}

	public void reactOnClick()
	{
		Action bump = Actions.sequence(Actions.moveBy(0, 200, 0.20f, Interpolation.exp5Out),
				Actions.moveBy(0, -200, 0.20f, Interpolation.exp5In));
		this.addAction(bump);
	}
}
