package com.filip.jugglemaster.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.filip.jugglemaster.JuggleMasterGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = JuggleMasterGame.NAME;
		config.width = JuggleMasterGame.WIDTH;
		config.height = JuggleMasterGame.HEIGHT;
		config.resizable = false;
		new LwjglApplication(new JuggleMasterGame(), config);
	}
}
