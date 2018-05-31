package com.filip.jugglemaster.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Ball extends Image
{
	private static final int width = 100;
	private static final int height = 100;
	private static final int starting_x = 200;
	private static final int starting_y = 0;
	public Vector2 speed;
	private boolean isOnTheFloor;

	public Ball()
	{
		super(new Texture("SoccerBall.png"));
		init();
	}

	private void init()
	{
		speed = new Vector2(0, 0);
		isOnTheFloor = true;
		this.setOrigin(width/2, height/2);
		this.setSize(width, height);
		this.setPosition(starting_x, starting_y);
	}

	public void reactOnClick()
	{
		Action bump = Actions.run(new Runnable()
		{
			@Override
			public void run()
			{
				speed.add(0, 500);
				if(isOnTheFloor)
					isOnTheFloor = false;
			}
		});

		this.addAction(bump);
	}

	public void update(final Vector2 gravity)
	{
		if(this.getY() < 0)
		{
			isOnTheFloor = true;
			this.setY(0);
			speed.y = speed.x = 0;
			System.out.println("below bot, y: " + this.getY());
		}
		else if (!isOnTheFloor)
		{

			speed.add(0, gravity.y * Gdx.graphics.getDeltaTime());
			System.out.println("Gravity should work " + gravity.y);
		}
		this.setPosition(this.getX() + Gdx.graphics.getDeltaTime() * speed.x, this.getY() + Gdx.graphics.getDeltaTime() * speed.y);
	}

	public void bump()
	{
		speed.add(0, 100);
	}
}
