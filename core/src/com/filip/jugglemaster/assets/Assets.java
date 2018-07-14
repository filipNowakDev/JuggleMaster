package com.filip.jugglemaster.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Assets
{
	public static AssetManager manager;

	//------TEXTURES------
	public static final String ball = "images/SoccerBall.png";
	public static final String background = "images/footballpitchscaled.jpg";
	public static final String coin = "images/coin-sheet-scaled.png";
	public static final String uiAtlas = "skin/flat-earth-ui.atlas";

	public static final String uiSkin = "skin/flat-earth-ui.json";

	//------SOUNDS--------
	public static final String kick = "sound/smackSound.mp3";
	public static final String ding = "sound/ding.mp3";

	//------MUSIC---------

	public static final String music = "music/Computer_Music_All-stars_-_May_the_Chords_Be_with_You.mp3";

	//------FONTS---------
	public static final String font = "fonts/xolonium-fonts-4.1/ttf/Xolonium-Bold.ttf";
	public static final String labelFont = "fonts/xolonium-fonts-4.1/ttf/Xolonium-Regular.ttf";


	//--------------------

	public static void load()
	{
		manager = new AssetManager();
		loadTextures();
		loadSounds();
		loadMusic();
		loadFonts();
	}

	private static void loadMusic()
	{
		manager.load(music, Music.class);
	}

	private static void loadFonts()
	{
		FileHandleResolver resolver = new InternalFileHandleResolver();
		manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
		manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));

		FreetypeFontLoader.FreeTypeFontLoaderParameter mainFont = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
		mainFont.fontFileName = font;
		mainFont.fontParameters.size = Gdx.graphics.getHeight() / 20;
		manager.load(font, BitmapFont.class, mainFont);

		FreetypeFontLoader.FreeTypeFontLoaderParameter _labelFont = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
		_labelFont.fontFileName = labelFont;
		_labelFont.fontParameters.size = Gdx.graphics.getWidth() / 20;
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
		manager.load(uiAtlas, TextureAtlas.class);
		manager.load(uiSkin, Skin.class);

	}

	public static void dispose()
	{
		manager.dispose();
	}

}
