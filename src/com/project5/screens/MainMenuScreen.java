package com.project5.screens;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.project5.GameWindow;
import com.project5.Screen;
import com.project5.assets.AssetManager;

public class MainMenuScreen implements Screen {
	private GameWindow window;
	
	public MainMenuScreen(GameWindow window) {
		this.window = window;
	}

	@Override
	public void update(Graphics g, long delta) {
		BufferedImage bgImage = AssetManager.SINGLETON.getTheme(null).getMenuImage();
		g.drawImage(bgImage, 0, 0, bgImage.getWidth(), bgImage.getHeight(), 0, 0, window.getWidth(), window.getHeight(), null);
		
	}

	@Override
	public void render(Graphics g, long delta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTransitionIn() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTransitionOut() {
		// TODO Auto-generated method stub

	}

}
