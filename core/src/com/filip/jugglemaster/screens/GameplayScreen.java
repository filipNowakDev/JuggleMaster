package com.filip.jugglemaster.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.filip.jugglemaster.JuggleMasterGame;
import com.filip.jugglemaster.assets.Assets;
import com.filip.jugglemaster.controllers.CoinController;
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
	private ScoreLabel recordLabel;
	private Vector2 gravity = new Vector2(0, -600);
	private CoinController coinController;

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
		initRecordLabel();

		initCoinController(stage, ball);
	}

	private void initCoinController(Stage stage, Ball ball)
	{
		coinController = new CoinController(stage, ball, game);

	}


	private void initRecordLabel()
	{
		recordLabel = new ScoreLabel(320, "Record: ");
		recordLabel.setScore(game.getScoreService().getMaxPoints());
		stage.addActor(recordLabel);
	}

	private void initBackground()
	{
		backgroundImage = new Image(Assets.manager.get(Assets.background, Texture.class));
		stage.addActor(backgroundImage);
	}

	private void initScoreLabel()
	{
		scoreLabel = new ScoreLabel(20, "Score: ");
		stage.addActor(scoreLabel);
	}

	private void initBallButton()
	{
		ballButton = new BallButton(ball, new IClickCallback()
		{
			@Override
			public void onClick()
			{

				game.getScoreService().addPoint();
				Vector3 cords = camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
				ball.reactOnClick(cords.x, cords.y);
				scoreLabel.setScore(game.getScoreService().getPoints());
				recordLabel.setScore(game.getScoreService().getMaxPoints());

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

		if (Gdx.input.isKeyJustPressed(Input.Keys.BACK))
			game.setScreen(new MainMenuScreen(game));
	}



	private void update()
	{


		stage.act(Gdx.graphics.getDeltaTime());
		ball.update(gravity);
		coinController.update(game, scoreLabel);
		if(ball.isOnTheFloor())
		{
			game.getScoreService().resetPoints();
			scoreLabel.setScore(game.getScoreService().getPoints());
		}
		ballButton.updatePosition();
	}
}
