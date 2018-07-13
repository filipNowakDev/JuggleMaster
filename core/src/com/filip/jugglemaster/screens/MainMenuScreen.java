package com.filip.jugglemaster.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Scaling;
import com.filip.jugglemaster.JuggleMasterGame;
import com.filip.jugglemaster.assets.Assets;
import com.filip.jugglemaster.ui.IClickCallback;
import com.filip.jugglemaster.ui.MenuButton;

public class MainMenuScreen extends AbstractMenuScreen
{

	//private static final int BUTTON_COUNT = 5;

	public MainMenuScreen(JuggleMasterGame game)
	{
		super(game);
		initBackground();
		initButtons();
	}

	@Override
	protected void init()
	{

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
		initTitleLabel();
		initPlayButton();
		initStoreButton();
		initOptionsButton();
		initExitButton();
	}

	private void initTitleLabel()
	{
		Label.LabelStyle style = new Label.LabelStyle();
		style.font = Assets.manager.get(Assets.font, BitmapFont.class);
		Label label = new Label("Juggle Master", style);
		addToBottom(label);
		stage.addActor(label);
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
		addToBottom(playButton);
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
		addToBottom(storeButton);
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
		addToBottom(optionsButton);
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
		addToBottom(exitButton);
		stage.addActor(exitButton);
	}

	private void initBackground()
	{
		Image backgroundImage = new Image(Assets.manager.get(Assets.background, Texture.class));
		backgroundImage.setScaling(Scaling.fill);
		backgroundImage.setPosition(Gdx.graphics.getWidth() / 2 - backgroundImage.getWidth() / 2,
				Gdx.graphics.getHeight() / 2 - backgroundImage.getHeight() / 2);
		stage.addActor(backgroundImage);
	}

}
