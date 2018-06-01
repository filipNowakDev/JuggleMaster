package com.filip.jugglemaster.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Ball extends Image
{
	private static final int width = 100;
	private static final int height = 100;
	private static final int starting_x = 190;
	private static final int starting_y = 0;
	private Vector2 speed;
	private float angleSpeed = 0;
	private boolean onTheFloor;

	public Ball()
	{
		super(new Texture("SoccerBall.png"));
		init();
	}

	private void init()
	{
		speed = new Vector2(0, 0);
		onTheFloor = true;
		this.setOrigin(width / 2, height / 2);
		this.setSize(width, height);
		this.setPosition(starting_x, starting_y);
	}

	public void reactOnClick(final float x, final float y)
	{
		Action bump = Actions.run(new Runnable()
		{
			@Override
			public void run()
			{
				Vector2 displacement = new Vector2(-(x - 50 - getX()), -(y - (getY() + 50)));
				System.out.println(Gdx.input.getX() + " " + Gdx.input.getY());
				speed = displacement.scl(10);
				angleSpeed -= displacement.x * Math.signum(displacement.y);
				if (onTheFloor && displacement.y > 0)
					onTheFloor = false;
			}
		});

		this.addAction(bump);
	}

	public void update(final Vector2 gravity)
	{
		int xSlowdown = 20;
		int rotationSlowdown = 50;
		updatePosition(gravity, xSlowdown);
		updateRotation(rotationSlowdown);

	}

	private void updatePosition(Vector2 gravity, int xSlowdown)
	{
		this.setPosition(this.getX() + Gdx.graphics.getDeltaTime() * speed.x, this.getY() + Gdx.graphics.getDeltaTime() * speed.y);
		if (this.getY() < 0)
		{
			onTheFloor = true;
			this.setY(0);
			speed.y = -speed.y / 3f;
			xSlowdown = 1000;

		}

		speed.x -= Math.signum(speed.x) * xSlowdown * Gdx.graphics.getDeltaTime();
		if (Math.abs(speed.x) < 10)
			speed.x = 0;
		speed.add(0, gravity.y * Gdx.graphics.getDeltaTime());

		if (getX() <= 0)
		{
			setX(0);
			speed.x = -speed.x;
		} else if ((getX() + 100) >= 480)
		{
			setX(380);
			speed.x = -speed.x;
		}
	}

	private void updateRotation(int rotationSlowdown)
	{
		if (getX() <= 0)
			angleSpeed = speed.y;

		else if ((getX() + 100) >= 480)
			angleSpeed = -speed.y;

		if(this.getY() <= 0)
			angleSpeed = -speed.x;

		angleSpeed -= Math.signum(angleSpeed) * rotationSlowdown * Gdx.graphics.getDeltaTime();
		if (Math.abs(angleSpeed) < 5)
			angleSpeed = 0;
		this.rotateBy(angleSpeed * Gdx.graphics.getDeltaTime());
	}

	//----------------------------

	public boolean isOnTheFloor()
	{
		return onTheFloor;
	}
}
