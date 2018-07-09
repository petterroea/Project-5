package com.project5;

import java.awt.Graphics;
import java.io.File;

import com.project5.assets.AssetLoadingTask;

public class LoadingScreen implements Screen{
	
	AsyncWorker loadingWorkers = new AsyncWorker();

	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
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
