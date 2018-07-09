package com.project5.gui;

import java.awt.Rectangle;

public class StackLayoutProvider implements LayoutProvider {
	
	private LayoutDirection direction;
	
	public StackLayoutProvider(LayoutDirection direction) {
		this.direction = direction;
	}
	
	public enum LayoutDirection {
		VERTICAL,
		HORIZONTAL
	}

	@Override
	public Rectangle getLayout(Rectangle previous, UiElement currentElement, SizingResponder size) {
		if(previous == null) {
			//First element
			if(direction == LayoutDirection.VERTICAL) {
				return new Rectangle(0, 0, size.getWidth(), currentElement.getPreferredHeight());
			} else {
				return new Rectangle(0, 0, currentElement.getPreferredWidth(), size.getHeight());
			}
		}
		//Not first element
		int x = previous.x;
		int y = previous.y;
		if(direction == LayoutDirection.VERTICAL) {
			y += previous.height + 10;
		} else {
			x += previous.width + 10;
		}
		
		if(direction == LayoutDirection.VERTICAL) {
			return new Rectangle(x, y, size.getWidth(), currentElement.getPreferredHeight());
		} else {
			return new Rectangle(x, y, currentElement.getPreferredWidth(), size.getHeight());
		}
	}

}
