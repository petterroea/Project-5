package com.project5.gui;

public class KeyboardEvent {
	public enum EventType {
		UP,
		DOWN,
		TYPE
	}
	
	private char keyChar;
	private int keyCode;
	private EventType type;
	
	public KeyboardEvent(char keyChar, int keyCode, EventType type) {
		this.type = type;
		this.keyChar = keyChar;
		this.keyCode = keyCode;
	}
	
	public EventType getType() {
		return type;
	}
	
	public char getKeyChar() {
		return keyChar;
	}
	
	public int getKeyCode() {
		return keyCode;
	}
}
