package com.project5.assets;

import java.awt.image.BufferedImage;
import java.util.HashMap;

public class AssetManager {
	public static AssetManager SINGLETON = new AssetManager();
	
	private HashMap<String, BufferedImage> images = new HashMap<String, BufferedImage>();
	
	public void registerImage(BufferedImage image, String className) {
		images.put(className, image);
	}
}
