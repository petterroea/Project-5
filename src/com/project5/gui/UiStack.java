package com.project5.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.project5.GameWindow;

public class UiStack {
	private GameWindow window;
	private SizingResponder sizer;
	private LayoutProvider provider;
	
	private LinkedList<UiElement> elements = new LinkedList<UiElement>();
	
	public UiStack(GameWindow window, SizingResponder sizer, LayoutProvider provider) {
		this.window = window;
		this.sizer = sizer;
		this.provider = provider;
	}
	
	public void addElement(UiElement element) {
		elements.add(element);
	}
	
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(sizer.getX(), sizer.getY(), sizer.getWidth(), sizer.getHeight());
		
		Rectangle previous = null;
		for(UiElement element : elements) {
			Rectangle drawPos = provider.getLayout(previous, element, sizer);
			element.render(g, drawPos.x+sizer.getX(), drawPos.y+sizer.getY(), drawPos.width, drawPos.height);
			previous = drawPos;
		}
	}
	
	public void passInMouseButton(MouseButtonEvent event) {
		Rectangle previous = null;
		for(UiElement element : elements) {
			Rectangle drawPos = provider.getLayout(previous, element, sizer);
			if(drawPos.contains(new Point(event.getX()-sizer.getX(), event.getY()-sizer.getY()))) {
				element.onMouseButton(event, drawPos, sizer);
			}
			previous = drawPos;
		}
	}

	public void passInMouseMotion(MouseMotionEvent event) {
		Rectangle previous = null;
		for(UiElement element : elements) {
			Rectangle drawPos = provider.getLayout(previous, element, sizer);
			if(drawPos.contains(new Point(event.getX()-sizer.getX(), event.getY()-sizer.getY()))) {
				element.onMouseMotion(event, drawPos, sizer);
			}
			previous = drawPos;
		}
		
	}
}
