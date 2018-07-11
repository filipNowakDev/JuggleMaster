package com.filip.jugglemaster.assets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class Assets
{
	public static AssetManager manager;

	//------TEXTURES------
	public static String ball = "images/SoccerBall.png";
	public static String background = "images/footballpitchscaled.jpg";
	public static String coin = "images/coin-sheet-scaled.png" ;

	//------SOUNDS------
	public static String kick = "sound/smackSound.wav";
	public static String ding = "sound/ding.mp3";

	public static void load()
	{
		manager  = new AssetManager();
		//-------------------------------------
		manager.load(ball, Texture.class);
		manager.load(background, Texture.class);
		manager.load(coin, Texture.class);
		//--------------------------------------
		manager.load(kick, Sound.class);
		manager.load(ding, Sound.class);
	}

	public static void dispose()
	{
		manager.dispose();
	}

}
