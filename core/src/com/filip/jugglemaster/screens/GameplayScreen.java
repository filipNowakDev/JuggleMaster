package com.filip.jugglemaster.screens;

import com.filip.jugglemaster.JuggleMasterGame;
import com.filip.jugglemaster.entities.Ball;

public class GameplayScreen extends AbstractScreen
{
	private Ball ball;

	public GameplayScreen(JuggleMasterGame game)
	{
		super(game);
		init();
	}

	private void init()
	{
		initBall();
	}

	private void initBall()
	{
		ball = new Ball();
		stage.addActor(ball);
	}

	@Override
	public void render(float delta)
	{
		super.render(delta);
		update();
		batch.begin();
		stage.draw();
		batch.end();
	}

	private void update()
	{
		stage.act();
	}
}
