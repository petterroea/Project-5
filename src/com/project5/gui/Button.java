package com.project5.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.project5.gui.MouseButtonEvent.MouseButtonState;

public class Button implements UiElement {
	private String str;
	private int wantedX, wantedY, wantedW, wantedH;
	private EventHandler callback;
	
	public Button(String str, EventHandler callback) {
		this.str = str;
		this.callback = callback;
	}
	
	public Button(String str, int x, int y, int width, int height, EventHandler callback) {
		this(str, callback);
		this.wantedX = x;
		this.wantedY = y;
		this.wantedW = width;
		this.wantedH = height;
	}

	@Override
	public int getPreferredWidth() {
		// TODO Auto-generated method stub
		return wantedW < 30 ? 30 : wantedW;
	}

	@Override
	public int getPreferredHeight() {
		// TODO Auto-generated method stub
		return wantedH < 30 ? 30 : wantedH;
	}

	@Override
	public int getMinimumWidth() {
		// TODO Auto-generated method stub
		return 30;
	}

	@Override
	public int getMinimumHeight() {
		// TODO Auto-generated method stub
		return 30;
	}

	@Override
	public void render(Graphics g, int x, int y, int w, int h) {
		g.setColor(Color.gray);
		g.fillRect(x, y, w, h);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(x+1, y+1, w-2, h-2);
		g.setColor(Color.white);
		g.drawString(str, x+10, y+h/2);
	}

	@Override
	public void onMouseButton(MouseButtonEvent event, Rectangle drawPos) {
		if(event.getState()==MouseButtonState.UP) {
			System.out.println("Tee hee, i was clicked");
			callback.fire(this);
		}
	}

}
