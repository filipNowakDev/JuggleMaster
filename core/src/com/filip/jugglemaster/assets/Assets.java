package com.filip.jugglemaster.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.SkinLoader;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;

public class Assets
{
	public static AssetManager manager;

	//------TEXTURES------
	public static String ball = "images/SoccerBall.png";
	public static String background = "images/footballpitchscaled.jpg";
	public static String coin = "images/coin-sheet-scaled.png" ;
	public static String buttonAtlas = "images/buttons_pack.atlas";

	//------SOUNDS--------
	public static String kick = "sound/smackSound.mp3";
	public static String ding = "sound/ding.mp3";

	//------FONTS---------
	public static String font = "fonts/xolonium-fonts-4.1/ttf/Xolonium-Bold.ttf";
	public static String labelFont = "fonts/xolonium-fonts-4.1/ttf/Xolonium-Regular.ttf";

	//--------------------

	public static void load()
	{
		manager  = new AssetManager();
		loadTextures();
		loadSounds();
		loadFonts();
	}

	private static void loadFonts()
	{
		FileHandleResolver resolver = new InternalFileHandleResolver();
		manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
		manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));

		FreetypeFontLoader.FreeTypeFontLoaderParameter mainFont = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
		mainFont.fontFileName = font;
		mainFont.fontParameters.size = 30;
		manager.load(font, BitmapFont.class, mainFont);

		FreetypeFontLoader.FreeTypeFontLoaderParameter _labelFont = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
		_labelFont.fontFileName = labelFont;
		_labelFont.fontParameters.size = Gdx.graphics.getWidth()/20;
		manager.load(labelFont, BitmapFont.class, _labelFont);
	}

	private static void loadSounds()
	{
		manager.load(kick, Sound.class);
		manager.load(ding, Sound.class);
	}

	private static void loadTextures()
	{
		manager.load(ball, Texture.class);
		manager.load(background, Texture.class);
		manager.load(coin, Texture.class);
		manager.load(buttonAtlas, TextureAtlas.class);
	}

	public static void dispose()
	{
		manager.dispose();
	}

}
