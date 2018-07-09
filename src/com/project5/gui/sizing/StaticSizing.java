package com.project5.gui.sizing;

import com.project5.gui.SizingResponder;

public class StaticSizing implements SizingResponder {
	
	public StaticSizing(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	private int x, y, w, h;

	@Override
	public int getWidth() {
		return w;
	}

	@Override
	public int getHeight() {
		return h;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

}
