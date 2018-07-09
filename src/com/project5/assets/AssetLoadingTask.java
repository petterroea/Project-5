package com.project5.assets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.project5.AsyncTask;

public class AssetLoadingTask implements AsyncTask {
	
	public AssetLoadingTask(File loadingFile) {
		loadJson(loadingFile);
	}
	
	private String readFromFile(File f) throws FileNotFoundException {
		Scanner in = new Scanner(new FileReader(f));
		
		StringBuilder sb = new StringBuilder();
		while(in.hasNext()) {
		    sb.append(in.next());
		}
		in.close();
		return sb.toString();
	}

	private void loadJson(File loadingFile) {
		String contents = "";
		try {
			contents = readFromFile(loadingFile);
			JSONParser parser = new JSONParser();
			
			JSONObject obj = (JSONObject)parser.parse(contents);
			if((Long)obj.get("version") != 1) {
				System.out.println("Invalid version");
			}
			if(obj.containsKey("assets")) {
				JSONArray assetArray = (JSONArray)obj.get("assets");
				for(Object o : assetArray) {
					JSONObject entry = (JSONObject)o;
					//Load the asset NICO
					//Hint: ImageIO.read();, use the file name
					//Register image with game engine in AssetManager.java
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}