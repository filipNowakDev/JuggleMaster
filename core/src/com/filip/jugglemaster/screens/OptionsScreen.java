package com.filip.jugglemaster.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.filip.jugglemaster.JuggleMasterGame;
import com.filip.jugglemaster.assets.Assets;
import com.filip.jugglemaster.ui.IChangeCallback;
import com.filip.jugglemaster.ui.IClickCallback;
import com.filip.jugglemaster.ui.MenuButton;
import com.filip.jugglemaster.ui.MenuCheckbox;

public class OptionsScreen extends AbstractMenuScreen
{
	public OptionsScreen(JuggleMasterGame game)
	{
		super(game);
		initItems();
	}

	private void initItems()
	{
		initTitle();
		initSoundCheckbox();
		initBackButton();
	}

	private void initBackButton()
	{
		MenuButton backButton = new MenuButton(0, 0, "Back", new IClickCallback()
		{
			@Override
			public void onClick()
			{
				game.setScreen(new MainMenuScreen(game));
			}
		});
		addToBottom(backButton);
		stage.addActor(backButton);
	}

	private void initSoundCheckbox()
	{
		final MenuCheckbox soundCheckBox = new MenuCheckbox(0, 0, "Sound", new IChangeCallback()
		{
			@Override
			public void onChange(boolean state)
			{
				OptionsScreen.this.game.getOptionsService().setSoundEnabled(state);
			}
		});
		soundCheckBox.setChecked(game.getOptionsService().isSoundEnabled());
		addToBottom(soundCheckBox);
		stage.addActor(soundCheckBox);
	}

	private void initTitle()
	{
		Label.LabelStyle style = new Label.LabelStyle();
		style.font = Assets.manager.get(Assets.font, BitmapFont.class);
		Label label = new Label("Options", style);
		addToBottom(label);
		stage.addActor(label);
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
			game.setScreen(new MainMenuScreen(game));
	}
}
