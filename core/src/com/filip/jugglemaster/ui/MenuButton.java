package com.filip.jugglemaster.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.filip.jugglemaster.assets.Assets;

public class MenuButton extends TextButton
{



	public MenuButton(float x, float y, String label, final IClickCallback callback)
	{
		super(label, prepareButtonStyle());

		this.setPosition(x, y);
		this.addListener(new InputListener() {
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {

				return true;
			}
			@Override
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				callback.onClick();
			}
		});
	}

	private static TextButtonStyle prepareButtonStyle()
	{
		TextureAtlas buttonAtlas;
		Skin buttonSkin;
		BitmapFont font;

		buttonAtlas = Assets.manager.get(Assets.buttonAtlas, TextureAtlas.class);
		buttonSkin = new Skin();
		buttonSkin.addRegions(buttonAtlas);
		font = Assets.manager.get(Assets.font, BitmapFont.class);

		TextButtonStyle style = new TextButtonStyle();

		style.up = buttonSkin.getDrawable("button_normal");
		style.down = buttonSkin.getDrawable("button_pressed");
		style.font = font;

		return style;
	}
}
