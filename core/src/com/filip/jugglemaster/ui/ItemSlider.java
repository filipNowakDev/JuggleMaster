package com.filip.jugglemaster.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.filip.jugglemaster.assets.Assets;

import java.util.ArrayList;
import java.util.List;

public class ItemSlider extends Actor
{
	private final Stage stage;
	private List<String> itemsPaths;
	private List<Image> items;
	private int selectedItem;

	public ItemSlider(float height, Stage stage)
	{
		this.setHeight(height);
		this.setWidth(Gdx.graphics.getWidth());
		this.stage = stage;
		initList();
		initListeners();
	}

	public void addItem(String itemName, String currentlySelected)
	{
		Image image = new Image(Assets.manager.get(itemName, Texture.class));
		itemsPaths.add(itemName);
		items.add(image);
		image.setWidth(image.getWidth() * this.getHeight() / image.getHeight());
		image.setHeight(this.getHeight());
		if (currentlySelected.equals(itemName))
		{
			selectedItem = items.size() - 1;
			image.setPosition(Gdx.graphics.getWidth() / 2f - image.getWidth() / 2f, this.getY());
		} else
		{
			image.setPosition(Gdx.graphics.getWidth(), this.getY());

		}
		stage.addActor(image);
		this.toFront();

	}

	private void initListeners()
	{
		this.addListener(new ActorGestureListener()
		{
			@Override
			public void fling(InputEvent event, float velocityX, float velocityY, int button)
			{
				super.fling(event, velocityX, velocityY, button);
				int lastItem = selectedItem;
				int dir = 0;
				if (Math.abs(velocityX) > Math.abs(velocityY))
				{
					if (velocityX > 10f)
					{
						dir = 1;
						selectedItem++;
					} else if (velocityX < 10f)
					{
						dir = -1;
						selectedItem--;
					}
				}
				if (selectedItem >= ItemSlider.this.items.size())
					selectedItem = 0;
				else if (selectedItem < 0)
					selectedItem = ItemSlider.this.items.size() - 1;

				items.get(lastItem).addAction(Actions.moveBy((getWidth() / 2 + items.get(lastItem).getWidth() / 2) * dir,
						0, 0.5f, Interpolation.swingOut));

				items.get(selectedItem).setX(dir > 0 ? -items.get(selectedItem).getWidth() : Gdx.graphics.getWidth());
				items.get(selectedItem).addAction(Actions.moveBy((getWidth() / 2 + items.get(lastItem).getWidth() / 2) * dir,
						0, 0.5f, Interpolation.swingOut));


			}

		});
	}

	private void initList()
	{
		items = new ArrayList<Image>();
		itemsPaths = new ArrayList<String>();
	}

	public String getCurrentItem()
	{
		return itemsPaths.get(selectedItem);
	}
}
