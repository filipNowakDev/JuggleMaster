package com.filip.jugglemaster.screens;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.reflect.Field;
import com.filip.jugglemaster.JuggleMasterGame;
import com.filip.jugglemaster.entities.Ball;

public class GameplayScreen extends AbstractScreen
{
	private Ball ball;
	private Button ballButton;
	private Label scoreLabel;

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
		scoreLabel = new Label("", style);
		scoreLabel.setX(20);
		scoreLabel.setY(750);
		stage.addActor(scoreLabel);
	}

	private void initBallButton()
	{
		ballButton = new Button(new Button.ButtonStyle());
		ballButton.setWidth(ball.getWidth());
		ballButton.setHeight(ball.getHeight());
		ballButton.setX(ball.getX());
		ballButton.setY(ball.getY());
		ballButton.setDebug(false);
		stage.addActor(ballButton);

		ballButton.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
			{
				ball.reactOnClick();
				game.addPoint();
				return super.touchDown(event, x, y, pointer, button);
			}
		});
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
		System.out.println("Points: " + game.getPoints());
		batch.begin();
		stage.draw();
		batch.end();
	}

	private void update()
	{
		stage.act();
		ballButton.setX(ball.getX());
		ballButton.setY(ball.getY());
	}
}
