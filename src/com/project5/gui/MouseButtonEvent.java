package com.project5.gui;

public class MouseButtonEvent {
	private int x, y;
	private MouseButtonState state;
	
	public enum MouseButtonState{
		DOWN,
		UP,
		CLICK
	}
	
	public MouseButtonEvent(int x, int y, MouseButtonState state) {
		this.state = state;
		this.x = x;
		this.y = y;
	}
	
	public MouseButtonState getState() {
		return state;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
