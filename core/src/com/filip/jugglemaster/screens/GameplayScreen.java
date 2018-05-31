package com.filip.jugglemaster.screens;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.reflect.Field;
import com.filip.jugglemaster.JuggleMasterGame;
import com.filip.jugglemaster.entities.Ball;

public class GameplayScreen extends AbstractScreen
{
	private Ball ball;
	private Button ballButton;

	public GameplayScreen(JuggleMasterGame game)
	{
		super(game);
	}

	@Override
	protected void init()
	{
		initBall();
		initBallButton();
	}

	private void initBallButton()
	{
		ballButton = new Button(new Button.ButtonStyle());
		ballButton.setWidth(ball.getWidth());
		ballButton.setHeight(ball.getHeight());
		ballButton.setX(ball.getX());
		ballButton.setY(ball.getY());
		ballButton.setDebug(true);
		stage.addActor(ballButton);
		ballButton.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
			{

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
		batch.begin();
		stage.draw();
		batch.end();
	}

	private void update()
	{
		stage.act();
	}
}
