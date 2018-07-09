package com.project5.assets;

import java.awt.image.BufferedImage;

import org.json.simple.JSONObject;

public class Theme {
	private String menuImage = "";

	public Theme(JSONObject themeObj) {
		menuImage = (String)themeObj.get("menuSplash");
	}
	
	public BufferedImage getMenuImage() {
		return AssetManager.SINGLETON.getImage(menuImage);
	}

}
