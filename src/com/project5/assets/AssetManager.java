package com.project5.assets;

import java.awt.image.BufferedImage;
import java.util.HashMap;

public class AssetManager {
	public static AssetManager SINGLETON = new AssetManager();
	
	private HashMap<String, BufferedImage> images = new HashMap<String, BufferedImage>();
	private HashMap<String, Theme> themes = new HashMap<String, Theme>();
	private String defaultTheme = null;
	
	public void registerImage(BufferedImage image, String className) {
		images.put(className, image);
	}

	public void registerTheme(String name, Theme theme) {
		themes.put(name, theme);
		if(defaultTheme == null) {
			defaultTheme = name;
		}
	}
	
	public Theme getTheme(String themeName) {
		if(themeName == null) {
			return themes.get(defaultTheme);
		}
		return themes.get(themeName);
	}

	public BufferedImage getImage(String menuImage) {
		return images.get(menuImage);
	}
}
