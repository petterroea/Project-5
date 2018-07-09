package com.project5;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;

import com.project5.assets.AssetLoadingTask;

public class LoadingScreen implements Screen{
	
	private GameWindow window;
	
	public LoadingScreen(GameWindow window) {
		this.window = window;
	}
	
	AsyncWorker loadingWorkers = new AsyncWorker();

	@Override
	public void update(Graphics g, long delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g, long delta) {
		g.setColor(Color.black);
		g.fillRect(0, 0, window.getWidth(), window.getHeight());
		g.setFont(g.getFont().deriveFont(20f));
		g.setColor(Color.white);
		g.drawString("NOW LOADING", 10, 10);
	}

	@Override
	public void onTransitionIn() {
		//Add things that need loading here
		loadingWorkers.addTask(new AssetLoadingTask(new File("assets", "basegame.json")));
		loadingWorkers.start();
	}

	@Override
	public void onTransitionOut() {
		// TODO Auto-generated method stub
		
	}

}
