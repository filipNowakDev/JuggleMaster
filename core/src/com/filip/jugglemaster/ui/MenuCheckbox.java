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
		/*this.getImageCell().minSize(Gdx.graphics.getHeight()/10, Gdx.graphics.getHeight()/10);*/
		/*this.getCells().get(0).size(Gdx.graphics.getHeight()/10, Gdx.graphics.getHeight()/10);*/

		this.addListener(new ChangeListener() {
			@Override
			public void changed (ChangeEvent event, Actor actor) {
				callback.onChange(MenuCheckbox.this.isChecked());
			}
		});
	}

	private static CheckBoxStyle prepareCheckBoxStyle()
	{

		float h  = Gdx.graphics.getHeight()/25;
		float w = h * 1.25f;
		Skin skin = (Assets.manager.get(Assets.uiSkin, Skin.class));
		CheckBoxStyle style = skin.get("default", CheckBoxStyle.class);
		style.font = Assets.manager.get(Assets.font, BitmapFont.class);
		style.checkboxOn.setMinHeight(h);
		style.checkboxOn.setMinWidth(w);
		style.checkboxOff.setMinHeight(h);
		style.checkboxOff.setMinWidth(w);
		return style;
	}
}
