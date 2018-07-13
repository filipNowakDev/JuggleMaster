package com.filip.jugglemaster.controllers;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.Timer;
import com.filip.jugglemaster.JuggleMasterGame;
import com.filip.jugglemaster.entities.Ball;
import com.filip.jugglemaster.entities.Coin;
import com.filip.jugglemaster.services.SoundService;
import com.filip.jugglemaster.ui.ScoreLabel;

public class CoinController
{

	private Stage stage;
	private Ball ball;
	private int spawnTime;
	private Coin coin;
	private SoundService soundService;

	public CoinController(Stage stage, Ball ball, JuggleMasterGame game)
	{
		init(stage, ball, game);

	}

	private void init(final Stage _stage, Ball ball, final JuggleMasterGame game)
	{
		randomizeSpawnTime();
		this.stage = _stage;
		this.ball = ball;
		this.soundService = game.getSoundService();
		Timer.schedule(new Timer.Task()
		{

			@Override
			public void run()
			{
				randomizeSpawnTime();
				if(coin == null)
				{
					coin = new Coin((int)MathUtils.random(stage.getWidth() - 50), (int)stage.getHeight() + 50, soundService);
					coin.addAction(Actions.moveBy(0, -stage.getHeight() - 200,
							32f / ((game.getScoreService().getPoints() / 10) + 1)));
					stage.addActor(coin);
				}
			}
		}, spawnTime, spawnTime);

	}

	private void randomizeSpawnTime()
	{
		spawnTime = MathUtils.random(3, 7);
	}


	public void update(JuggleMasterGame game, ScoreLabel scoreLabel)
	{
		if((coin != null && ball.collides(coin)))
		{
			coin.onCollision();
			game.getScoreService().addPoints(5);
			coin = null;
			scoreLabel.setScore(game.getScoreService().getPoints());
		}
		else if(coin != null && coin.getY() < -50)
		{
			coin.remove();
			coin = null;
		}
	}
}
