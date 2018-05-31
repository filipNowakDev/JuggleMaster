package com.filip.jugglemaster.screens;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.filip.jugglemaster.JuggleMasterGame;
import com.filip.jugglemaster.entities.Ball;
import com.filip.jugglemaster.ui.BallButton;
import com.filip.jugglemaster.ui.IClickCallback;
import com.filip.jugglemaster.ui.ScoreLabel;

public class GameplayScreen extends AbstractScreen
{
	private Ball ball;
	private BallButton ballButton;
	private ScoreLabel scoreLabel;

	public GameplayScreen(JuggleMasterGame game)
	{
		super(game);
	}

	@Override
	protected void init()
	{
		initBall();
		initBallButton();
		initScoreLabel();
	}

	private void initScoreLabel()
	{
		Label.LabelStyle style = new Label.LabelStyle();
		style.font = new BitmapFont();
		scoreLabel = new ScoreLabel();
		stage.addActor(scoreLabel);
	}

	private void initBallButton()
	{
		ballButton = new BallButton(ball, new IClickCallback()
		{
			@Override
			public void onClick()
			{
				ball.reactOnClick();
				game.addPoint();
				scoreLabel.setScore(game.getPoints());
			}
		});
		stage.addActor(ballButton);
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
		ballButton.updatePosition();
	}
}
