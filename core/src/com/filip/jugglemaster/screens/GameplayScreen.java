package com.filip.jugglemaster.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.filip.jugglemaster.JuggleMasterGame;
import com.filip.jugglemaster.entities.Ball;
import com.filip.jugglemaster.ui.BallButton;
import com.filip.jugglemaster.ui.IClickCallback;
import com.filip.jugglemaster.ui.ScoreLabel;

public class GameplayScreen extends AbstractScreen
{
	private Ball ball;
	private Image backgroundImage;
	private BallButton ballButton;
	private ScoreLabel scoreLabel;
	private Vector2 gravity = new Vector2(0, -600);

	public GameplayScreen(JuggleMasterGame game)
	{
		super(game);
	}

	@Override
	protected void init()
	{
		initBackground();
		initBall();
		initBallButton();
		initScoreLabel();
	}

	private void initBackground()
	{
		backgroundImage = new Image(new Texture("footballpitchscaled.jpg"));
		stage.addActor(backgroundImage);
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
				//ball.bump();
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
		ball.update(gravity);
		ballButton.updatePosition();
	}
}
