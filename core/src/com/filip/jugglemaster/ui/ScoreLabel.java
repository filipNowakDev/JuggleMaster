package com.filip.jugglemaster.ui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.filip.jugglemaster.assets.Assets;

public class ScoreLabel extends Label
{
	String label;
	public ScoreLabel(int x, int y, String label)
	{
		super("", prepareLabelStyle());
		this.label = label;
		init(x, y);
	}

	private void init(int x, int y)
	{
		this.setX(x);
		this.setY(y);
	}

	private static LabelStyle prepareLabelStyle()
	{
		LabelStyle style = new LabelStyle();
		style.font = Assets.manager.get(Assets.labelFont, BitmapFont.class)/* new BitmapFont()*/;
		return style;
	}

	public void setScore(int points)
	{
		this.setText(label + points);
	}
}
