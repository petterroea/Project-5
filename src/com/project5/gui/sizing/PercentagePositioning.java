package com.project5.gui.sizing;

import com.project5.GameWindow;
import com.project5.gui.SizingResponder;

public class PercentagePositioning implements SizingResponder {
	
	GameWindow window;
	float x, y, w, h;
	
	public PercentagePositioning(GameWindow window, float x, float y, float w, float h) {
		this.window = window;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	@Override
	public int getWidth() {
		return (int)((float)window.getWidth()*(w/100f));
	}

	@Override
	public int getHeight() {
		return (int)((float)window.getHeight()*(h/100f));
	}

	@Override
	public int getX() {
		return (int)((float)window.getWidth()*(x/100f));
	}

	@Override
	public int getY() {
		return (int)((float)window.getHeight()*(y/100f));
	}

}
