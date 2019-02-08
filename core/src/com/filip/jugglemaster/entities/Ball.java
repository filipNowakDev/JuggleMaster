package com.filip.jugglemaster.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.filip.jugglemaster.assets.Assets;
import com.filip.jugglemaster.services.BallService;
import com.filip.jugglemaster.services.SoundService;

public class Ball extends Image
{
	private static final int width = Gdx.graphics.getWidth() / 5;
	private static final int height = Gdx.graphics.getWidth() / 5;
	private static int starting_x;
	private static int starting_y = 0;
	private Vector2 speed;
	private float angleSpeed = 0;
	private boolean onTheFloor;
	private SoundService soundService;
	private BallService ballService;

	public Ball(SoundService soundService, BallService ballService)
	{
		super(Assets.manager.get(Assets.ball, Texture.class));
		init(soundService, ballService);
	}

	private void init(SoundService soundService, BallService ballService)
	{
		speed = new Vector2(0, 0);
		this.soundService = soundService;
		this.ballService = ballService;
		this.setDrawable(new TextureRegionDrawable(new TextureRegion(Assets.manager.get(ballService.getCurrentBall(), Texture.class))));
		onTheFloor = true;
		this.setDebug(false);
		this.setOrigin(width / 2, height / 2);
		this.setSize(width, height);
		starting_x = Gdx.graphics.getWidth() / 2 - width / 2;
		this.setPosition(starting_x, starting_y);

	}

	public void reactOnClick(final float x, final float y)
	{
		Action bump = Actions.run(new Runnable()
		{
			@Override
			public void run()
			{
				soundService.playKickSound(1);
				Vector2 displacement = new Vector2(-(x - width / 2 - getX()), -(y - (getY() + height / 2)));
				speed = displacement.scl(Gdx.graphics.getWidth() / (float) (5 * width / 8));

				angleSpeed -= displacement.x * Math.signum(displacement.y) / (width / 130f);
				if (onTheFloor && displacement.y > 0)
					onTheFloor = false;
			}
		});

		this.addAction(bump);
	}


	public void update(final Vector2 gravity)
	{
		int xSlowdown = 20 * width / 100;
		int rotationSlowdown = 50;
		updatePosition(gravity, xSlowdown);
		updateRotation(rotationSlowdown);

	}

	private void updatePosition(Vector2 gravity, int xSlowdown)
	{
		this.setPosition(this.getX() + Gdx.graphics.getDeltaTime() * speed.x, this.getY() + Gdx.graphics.getDeltaTime() * speed.y);
		if (this.getY() <= 0)
		{
			onTheFloor = true;
			if (Math.abs(speed.y) > 40)
				soundService.playKickSound(Math.abs(speed.y / 500f));
			this.setY(0);
			speed.y = -speed.y / 2.5f;
			xSlowdown = 400 * width / 100;

		} else
			onTheFloor = false;

		speed.x -= Math.signum(speed.x) * xSlowdown * Gdx.graphics.getDeltaTime();
		if (Math.abs(speed.x) < 8f)
			speed.x = 0;

		speed.add(0, gravity.y * Gdx.graphics.getDeltaTime());

		if (getX() <= -1)
		{
			setX(0);
			soundService.playKickSound(Math.abs(speed.y / 500f));
			speed.x = -speed.x;
		} else if ((getX() + width) >= Gdx.graphics.getWidth())
		{
			setX(Gdx.graphics.getWidth() - width);
			soundService.playKickSound(Math.abs(speed.y / 500f));
			speed.x = -speed.x;
		}
	}

	private void updateRotation(int rotationSlowdown)
	{


		float rotationCoefficient = 150f;
		if (getX() <= 0)
			angleSpeed = speed.y / (width / rotationCoefficient);

		else if ((getX() + width) >= Gdx.graphics.getWidth())
			angleSpeed = -speed.y / (width / rotationCoefficient);

		if (this.getY() <= 0)
		{
			angleSpeed = -speed.x / (width / rotationCoefficient) /*(((1 + e) * speed.x + alpha * (1 + e) * radius * angleSpeed) / ((1 + alpha) * radius))*//* * (360f / 6.28f)*/;
		}

		angleSpeed -= Math.signum(angleSpeed) * rotationSlowdown * Gdx.graphics.getDeltaTime();
		if (Math.abs(angleSpeed) < width/100)
			angleSpeed = 0;
		this.rotateBy(angleSpeed * Gdx.graphics.getDeltaTime());
	}

	//----------------------------

	public boolean isOnTheFloor()
	{
		return onTheFloor;
	}

	public boolean collides(Coin coin)
	{
		float w = 0.5f * (this.getWidth() + coin.getSize());
		float h = 0.5f * (this.getHeight() + coin.getSize());
		float dx = this.getX() + this.getWidth() / 2 - coin.getX() - coin.getSize() / 2;
		float dy = this.getY() + this.getHeight() / 2 - coin.getY() - coin.getSize() / 2;

		if (Math.abs(dx) <= w && Math.abs(dy) <= h)
		{
			return true;
		}
		return false;
	}
}
