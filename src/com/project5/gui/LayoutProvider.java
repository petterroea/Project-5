package com.project5.gui;

import java.awt.Rectangle;

public interface LayoutProvider {
	public Rectangle getLayout(Rectangle previous, UiElement currentElement, SizingResponder size);
}
