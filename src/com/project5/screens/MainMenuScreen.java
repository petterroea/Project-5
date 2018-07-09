package com.project5.screens;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.project5.GameWindow;
import com.project5.Screen;
import com.project5.assets.AssetManager;
import com.project5.gui.KeyboardEvent;
import com.project5.gui.MouseButtonEvent;
import com.project5.gui.MouseMotionEvent;

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

	@Override
	public void onMouseButton(MouseButtonEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMouseMotion(MouseMotionEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onKeyboard(KeyboardEvent event) {
		// TODO Auto-generated method stub
		
	}

}
