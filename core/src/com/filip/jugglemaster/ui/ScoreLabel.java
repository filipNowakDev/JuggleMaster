package com.filip.jugglemaster.ui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class ScoreLabel extends Label
{
	public ScoreLabel()
	{
		super("Score: 0", prepareLabelStyle());
		init();
	}

	private void init()
	{
		this.setX(20);
		this.setY(750);
	}

	private static LabelStyle prepareLabelStyle()
	{
		LabelStyle style = new LabelStyle();
		style.font = new BitmapFont();
		return style;
	}

	public void setScore(int points)
	{
		this.setText("Score: " + points);
	}
}
