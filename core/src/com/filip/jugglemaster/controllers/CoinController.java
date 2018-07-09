package com.filip.jugglemaster.controllers;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Timer;
import com.filip.jugglemaster.JuggleMasterGame;
import com.filip.jugglemaster.entities.Ball;
import com.filip.jugglemaster.entities.Coin;
import com.filip.jugglemaster.ui.ScoreLabel;

public class CoinController
{

	private Stage stage;
	private Ball ball;
	private int spawnTime;
	private Coin coin;

	public CoinController(Stage stage, Ball ball)
	{
		init(stage, ball);

	}

	private void init(final Stage _stage, Ball ball)
	{
		randomizeSpawnTime();
		this.stage = _stage;
		this.ball = ball;
		Timer.schedule(new Timer.Task()
		{

			@Override
			public void run()
			{
				randomizeSpawnTime();
				if(coin == null)
				{
					coin = new Coin(200, 500);
					stage.addActor(coin);
				}
			}
		}, spawnTime, spawnTime);

	}

	private void randomizeSpawnTime()
	{
		spawnTime = MathUtils.random(5, 10);
	}


	public void update(JuggleMasterGame game, ScoreLabel scoreLabel)
	{
		if(coin != null && ball.collides(coin))
		{
			coin.onCollision();
			game.addPoints(5);
			coin = null;
			scoreLabel.setScore(game.getPoints());
		}
	}
}
