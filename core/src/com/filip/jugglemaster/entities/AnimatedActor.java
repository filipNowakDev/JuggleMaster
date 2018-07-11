package com.filip.jugglemaster.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.filip.jugglemaster.assets.Assets;

public class AnimatedActor extends Actor
{

	private Animation<TextureRegion> animation;
	private Texture animationSheet;
	private float stateTime;


	//asset specified by 'path' must be loaded in Assets first
	public AnimatedActor(String path, int cols, int rows)
	{
		stateTime = 0;
		initAnimationSheet(path);
		initAnimation(cols, rows);
		initActor(cols, rows);
	}

	private void initActor(int cols, int rows)
	{
		setX(0);
		setY(0);
		setWidth(animationSheet.getWidth()/cols);
		setHeight(animationSheet.getHeight()/rows);

	}

	private void initAnimationSheet(String path)
	{
		animationSheet = Assets.manager.get(path, Texture.class);
	}

	private void initAnimation(int cols, int rows)
	{

		TextureRegion[][] tmp = TextureRegion.split(animationSheet,
				animationSheet.getWidth() / cols,
				animationSheet.getHeight() / rows);
		TextureRegion[] animationFrames = new TextureRegion[cols * rows];
		int index = 0;
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cols; j++)
			{
				animationFrames[index++] = tmp[i][j];
			}
		}
		animation = new Animation<TextureRegion>(0.050f, animationFrames);
	}

	@Override
	public void act(float delta)
	{
		super.act(delta);
		stateTime += delta;
	}

	@Override
	public void draw(Batch batch, float parentAlpha)
	{
		TextureRegion currentFrame = animation.getKeyFrame(stateTime, true);
		batch.draw(currentFrame, getX(), getY());
	}
}
