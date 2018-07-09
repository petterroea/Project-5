package com.project5.screens;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.project5.GameWindow;
import com.project5.Screen;
import com.project5.assets.AssetManager;
import com.project5.gui.Button;
import com.project5.gui.KeyboardEvent;
import com.project5.gui.MouseButtonEvent;
import com.project5.gui.MouseMotionEvent;
import com.project5.gui.Slider;
import com.project5.gui.StackLayoutProvider;
import com.project5.gui.UiStack;
import com.project5.gui.StackLayoutProvider.LayoutDirection;
import com.project5.gui.UiElement;
import com.project5.gui.sizing.PercentagePositioning;
import com.project5.gui.EventHandler;

public class MainMenuScreen implements Screen {
	private GameWindow window;
	private UiStack menuButtons;
	
	public MainMenuScreen(GameWindow window) {
		this.window = window;
		this.menuButtons = new UiStack(window, 
				new PercentagePositioning(window, 40f, 10f, 20f, 80f), 
				new StackLayoutProvider(LayoutDirection.VERTICAL));
		menuButtons.addElement(new Button("Test", new EventHandler() {

			@Override
			public void fire(UiElement target) {
				System.out.println("Test");
			}}));
		menuButtons.addElement(new Button("Foo", new EventHandler() {

			@Override
			public void fire(UiElement target) {
				System.out.println("Foo");
			}}));
		menuButtons.addElement(new Button("Bar", new EventHandler() {

			@Override
			public void fire(UiElement target) {
				System.out.println("Bar");
			}}));
		menuButtons.addElement(new Slider(0.0f, 1.0f, 0.5f, new EventHandler() {
			@Override
			public void fire(UiElement target) {
				// TODO Auto-generated method stub
				
			}
		}));
	}

	@Override
	public void update(Graphics g, long delta) {
		BufferedImage bgImage = AssetManager.SINGLETON.getTheme(null).getMenuImage();
		g.drawImage(bgImage, 0, 0, bgImage.getWidth(), bgImage.getHeight(), 0, 0, window.getWidth(), window.getHeight(), null);
		
		this.menuButtons.render(g);
		
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
		menuButtons.passInMouseButton(event);
	}

	@Override
	public void onMouseMotion(MouseMotionEvent event) {
		menuButtons.passInMouseMotion(event);
	}

	@Override
	public void onKeyboard(KeyboardEvent event) {
		// TODO Auto-generated method stub
		
	}

}
