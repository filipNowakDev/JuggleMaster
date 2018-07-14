package com.filip.jugglemaster.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.filip.jugglemaster.JuggleMasterGame;
import com.filip.jugglemaster.assets.Assets;
import com.filip.jugglemaster.ui.IClickCallback;
import com.filip.jugglemaster.ui.MenuButton;

public class MainMenuScreen extends AbstractMenuScreen
{
	public MainMenuScreen(JuggleMasterGame game)
	{
		super(game);
		initItems();
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

	private void initItems()
	{
		initTitleLabel();
		initPlayButton();
		//initStoreButton();
		initOptionsButton();
		initExitButton();
	}

	private void initTitleLabel()
	{
		Skin skin = (Assets.manager.get(Assets.uiSkin, Skin.class));

		Label.LabelStyle style = /*new Label.LabelStyle();*/skin.get("title", Label.LabelStyle.class);
		style.font = Assets.manager.get(Assets.font, BitmapFont.class);
		Label label = new Label("Juggle Master", style);
		label.setAlignment(Align.center);
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
				game.setScreen(new OptionsScreen(game));
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

}
