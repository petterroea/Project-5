package com.project5.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Slider implements UiElement {
	
	private float start;
	private float end;
	private float value;
	private EventHandler valueChanged;
	
	public Slider(float start, float end, EventHandler valueChanged) {
		if(end < start) {
			throw new IllegalArgumentException();
		}
		
		this.start = start;
		this.end = end;
		this.valueChanged = valueChanged;
	}
	
	public Slider(float start, float end, float value, EventHandler valueChanged) {
		this(start, end, valueChanged);
		this.value = value;
	}
	
	public float getValue() {
		return value;
	}

	@Override
	public int getPreferredWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPreferredHeight() {
		// TODO Auto-generated method stub
		return 30;
	}

	@Override
	public int getMinimumWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMinimumHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void render(Graphics g, int x, int y, int w, int h) {
		g.setColor(Color.gray);
		g.fillRect(x+10, y+h/2-1, w-20, 2);
		
		int lerpedVal = (int)((float)(w-20) * ((float)(value-start)/(float)(end-start)));
		g.setColor(Color.black);
		g.fillArc(x+10+lerpedVal-10, y+h/2-10, 20, 20, 0, 360);
	}

	@Override
	public void onMouseButton(MouseButtonEvent event, Rectangle drawPos) {
		// TODO Auto-generated method stub

	}

}
