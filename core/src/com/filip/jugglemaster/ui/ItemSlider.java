package com.filip.jugglemaster.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.filip.jugglemaster.assets.Assets;

import java.util.ArrayList;
import java.util.List;

public class ItemSlider extends Actor
{
	private List<String> itemsPaths;
	private List<Image> items;
	private int selectedItem;

	public ItemSlider(float height)
	{
		this.setHeight(height);
		this.setWidth(Gdx.graphics.getWidth());
		initList();
		initListeners();
	}

	public void addItem(String itemName)
	{
		Image image = new Image(Assets.manager.get(itemName, Texture.class));
		itemsPaths.add(itemName);
		items.add(image);
		image.setWidth(image.getWidth() * this.getHeight() / image.getHeight());
		image.setHeight(this.getHeight());

	}

	private void initListeners()
	{
		this.addListener(new ActorGestureListener(){
			@Override
			public void fling(InputEvent event, float velocityX, float velocityY, int button)
			{
				super.fling(event, velocityX, velocityY, button);
				if(Math.abs(velocityX) > Math.abs(velocityY))
				{
					if (velocityX > 10f)
						selectedItem++;
					else if (velocityX < 10f)
						selectedItem--;
					System.out.println(velocityX);
				}
				if(selectedItem >= ItemSlider.this.items.size())
					selectedItem = 0;
				else if(selectedItem < 0)
					selectedItem = ItemSlider.this.items.size()-1;
			}

		});
	}

	private void initList()
	{
		items = new ArrayList<Image>();
		itemsPaths = new ArrayList<String>();
		selectedItem = 0;
	}

	@Override
	public void draw(Batch batch, float parentAlpha)
	{
		super.draw(batch, parentAlpha);
		Image img = items.get(selectedItem);
		img.setPosition(Gdx.graphics.getWidth()/2f - img.getWidth()/2f, getY());
		img.draw(batch, parentAlpha);
	}

	public String getCurrentItem()
	{
		return itemsPaths.get(selectedItem);
	}
}
