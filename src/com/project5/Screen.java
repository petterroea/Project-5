package com.project5;

import java.awt.Graphics;

import com.project5.gui.KeyboardEvent;
import com.project5.gui.MouseButtonEvent;
import com.project5.gui.MouseMotionEvent;

/**
 * Defines a scene in the game which can be drawn
 * @author petterroea
 *
 */
public interface Screen {
	//Draw stuff
	void update(Graphics g, long delta);
	void render(Graphics g, long delta);
	
	//Event handlers
	void onTransitionIn(); //When this screen is transitioned to
	void onTransitionOut(); //When this screen is transitioned away from
	
	//Mouse handlers
	void onMouseButton(MouseButtonEvent event);
	void onMouseMotion(MouseMotionEvent event);
	
	//Keyboard handler
	void onKeyboard(KeyboardEvent event);
	
}
