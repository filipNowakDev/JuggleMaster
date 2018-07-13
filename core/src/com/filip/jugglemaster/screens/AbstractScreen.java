package com.filip.jugglemaster.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.filip.jugglemaster.JuggleMasterGame;

public abstract class AbstractScreen implements Screen
{
	protected JuggleMasterGame game;
	protected Stage stage;
	protected OrthographicCamera camera;
	protected SpriteBatch batch;

	public AbstractScreen(JuggleMasterGame game)
	{
		this.game = game;
		createCamera();
		stage = new Stage(new ScreenViewport(/*JuggleMasterGame.WIDTH, JuggleMasterGame.HEIGHT,*/ camera));
		batch = new SpriteBatch();
		Gdx.input.setInputProcessor(stage);
		Gdx.input.setCatchBackKey(true);
		init();
	}

	protected abstract void init();

	private void createCamera()
	{
		camera = new OrthographicCamera();
		camera.setToOrtho(false, JuggleMasterGame.WIDTH, JuggleMasterGame.HEIGHT);
		camera.update();
	}

	@Override
	public void show()
	{

	}

	@Override
	public void render(float delta)
	{
		clearScreen();
		camera.update();
		batch.setProjectionMatrix(camera.combined);
	}

	private void clearScreen()
	{
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}

	@Override
	public void resize(int width, int height)
	{
		stage.getViewport().update(width, height, true);
	}

	@Override
	public void pause()
	{
		game.setPaused(true);
	}

	@Override
	public void resume()
	{
		game.setPaused(false);
	}

	@Override
	public void hide()
	{

	}

	@Override
	public void dispose()
	{
		game.dispose();
	}
}
