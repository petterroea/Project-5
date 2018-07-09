package com.project5.gui;

public class MouseMotionEvent {
	public enum MouseMotionType {
		DRAG,
		MOVE
	}
	
	private int x, y;
	private MouseMotionType type;
	
	public MouseMotionEvent(int x, int y, MouseMotionType type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public MouseMotionType getType() {
		return type;
	}
}
