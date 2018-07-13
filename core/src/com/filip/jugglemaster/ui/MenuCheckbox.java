package com.filip.jugglemaster.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.filip.jugglemaster.assets.Assets;

public class MenuCheckbox extends CheckBox
{
	public MenuCheckbox(float x, float y, String label, final IChangeCallback callback)
	{
		super(label, prepareCheckBoxStyle());
		this.setPosition(x, y);
		this.addListener(new ChangeListener() {
			@Override
			public void changed (ChangeEvent event, Actor actor) {
				callback.onChange(MenuCheckbox.this.isChecked());
			}
		});
	}

	private static CheckBoxStyle prepareCheckBoxStyle()
	{
		TextureAtlas skinAtlas;
		Skin skin;
		BitmapFont font;

		skinAtlas = Assets.manager.get(Assets.uiAtlas, TextureAtlas.class);
		skin = new Skin();
		skin.addRegions(skinAtlas);
		font = Assets.manager.get(Assets.font, BitmapFont.class);

		CheckBoxStyle style = new CheckBoxStyle();

		style.checkboxOff = skin.getDrawable("checkbox");
		style.checkboxOn = skin.getDrawable("checkbox-pressed");
		style.font = font;

		return style;
	}
}
