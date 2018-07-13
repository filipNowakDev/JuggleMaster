package com.filip.jugglemaster.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Scaling;
import com.filip.jugglemaster.JuggleMasterGame;
import com.filip.jugglemaster.assets.Assets;
import com.filip.jugglemaster.ui.IClickCallback;
import com.filip.jugglemaster.ui.MenuButton;

public class MainMenuScreen extends AbstractScreen
{

	private static final int BUTTON_COUNT = 4;

	public MainMenuScreen(JuggleMasterGame game)
	{
		super(game);
	}

	@Override
	protected void init()
	{
		initBackground();
		initButtons();
	}

	@Override
	public void render(float delta)
	{
		super.render(delta);
		stage.act(delta);
		batch.begin();
		stage.draw();
		batch.end();

		if (Gdx.input.isKeyJustPressed(Input.Keys.BACK))
			Gdx.app.exit();
	}

	private void initButtons()
	{
		initPlayButton();
		initStoreButton();
		initOptionsButton();
		initExitButton();
	}



	private void initPlayButton()
	{
		MenuButton playButton = new MenuButton(0, 0, "Play", new IClickCallback()
		{
			@Override
			public void onClick()
			{
				game.setScreen(new GameplayScreen(game));
			}
		});
		setButtonPosition(playButton, 0);
		stage.addActor(playButton);
	}

	private void initStoreButton()
	{
		MenuButton storeButton = new MenuButton(0, 0, "Store", new IClickCallback()
		{
			@Override
			public void onClick()
			{
			}
		});
		setButtonPosition(storeButton, 1);
		stage.addActor(storeButton);
	}

	private void initOptionsButton()
	{
		MenuButton optionsButton = new MenuButton(0, 0, "Options", new IClickCallback()
		{
			@Override
			public void onClick()
			{
			}
		});
		setButtonPosition(optionsButton, 2);
		stage.addActor(optionsButton);
	}

	private void initExitButton()
	{
		MenuButton exitButton = new MenuButton(0, 0, "Exit", new IClickCallback()
		{
			@Override
			public void onClick()
			{
				Gdx.app.exit();
			}
		});
		setButtonPosition(exitButton, 3);
		stage.addActor(exitButton);
	}

	private void initBackground()
	{
		Image backgroundImage = new Image(Assets.manager.get(Assets.background, Texture.class));
		backgroundImage.setScaling(Scaling.fill);
		backgroundImage.setPosition(Gdx.graphics.getWidth()/2 - backgroundImage.getWidth()/2,
				Gdx.graphics.getHeight()/2 - backgroundImage.getHeight()/2);
		stage.addActor(backgroundImage);
	}


	private void setButtonPosition(MenuButton button, int position)
	{
		button.setPosition(stage.getWidth()/2 - button.getWidth()/2, ((BUTTON_COUNT - position) * stage.getHeight() / (BUTTON_COUNT + 1)) - button.getHeight()/2);
	}
}
