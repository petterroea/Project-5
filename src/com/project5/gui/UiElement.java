package com.project5.gui;

import java.awt.Graphics;
import java.awt.Rectangle;

public interface UiElement {
	public int getPreferredWidth();
	public int getPreferredHeight();
	
	public int getMinimumWidth();
	public int getMinimumHeight();
	
	public void render(Graphics g, int x, int y, int w, int h);
	public void onMouseButton(MouseButtonEvent event, Rectangle drawPos);
}
