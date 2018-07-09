package com.project5;

import java.awt.Graphics;

/**
 * Defines a scene in the game which can be drawn
 * @author petterroea
 *
 */
public interface Screen {
	//Draw stuff
	void update(Graphics g);
	void render(Graphics g);
	
	//Event handlers
	void onTransitionIn(); //When this screen is transitioned to
	void onTransitionOut(); //When this screen is transitioned away from
	
}
