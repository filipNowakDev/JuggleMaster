package com.filip.jugglemaster.ui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class ScoreLabel extends Label
{
	String label;
	public ScoreLabel(int x, String label)
	{
		super("", prepareLabelStyle());
		this.label = label;
		init(x);
	}

	private void init(int x)
	{
		this.setX(x);
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
		this.setText(label + points);
	}
}
