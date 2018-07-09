package com.project5;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Project5Entrypoint extends Applet implements Runnable, GameWindow{
	
	private Thread gameThread;
	//To avoid flickering, we draw to an image which we then quickly blit
	private BufferedImage backBuffer;
	
	@Override
	public void init() {
		gameThread = new Thread(this);
	}
	
	@Override
	public void start() {
		gameThread.start();
	}
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Project 5");
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Project5Entrypoint entrypoint = new Project5Entrypoint();
		frame.add(entrypoint);
		
		entrypoint.init();
		frame.show();
		entrypoint.start();
	}

	@Override
	public void run() {
		long lastRun = System.currentTimeMillis();
		long lastFps = System.currentTimeMillis();
		long gameStartTime = System.currentTimeMillis();
		int frameCounter = 0;
		while(true) {
			if(backBuffer == null || this.getWidth() != backBuffer.getWidth() || this.getHeight() != backBuffer.getHeight()) {
				backBuffer = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
			}
			//Calculate FPS every second
			frameCounter++;
			if(lastFps+1000 < System.currentTimeMillis()) {
				System.out.println("FPS: " + frameCounter);
				frameCounter = 0;
				lastFps = System.currentTimeMillis();
			}
			
			//Calculate time since the game started
			long elapsedTime = System.currentTimeMillis()-gameStartTime;
			double runtime = (double)elapsedTime/1000.0;
			
			//Calculate time since the start of the last frame
			long delta = System.currentTimeMillis() - lastRun;
			lastRun = System.currentTimeMillis();
			
			Graphics g = backBuffer.getGraphics();
			//Draw stuff
			g.setColor(Color.black);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			//Draw a nice copper effect
			for(int i = 0; i < 200; i++) {
				int xPos = (getWidth()/2) + (int)(Math.sin((double)i*0.5+runtime)*200);
				int yPosGround = (int)(Math.cos((double)i*0.5+runtime)*30);
				int yPos = (getHeight()/2) + (int)(Math.cos((double)i*0.734+runtime*1.5)*100) + yPosGround;
				g.setColor(Color.white);
				g.drawLine(xPos-1, yPos, xPos+1, yPos);
				g.drawLine(xPos, yPos-1, xPos, yPos+1);
				
				g.setColor(Color.gray);
				g.drawLine(xPos-1, yPosGround + (this.getHeight()/2)+100, xPos+1, yPosGround + (this.getHeight()/2)+100);
				g.drawLine(xPos, yPosGround-1 + (this.getHeight()/2)+100, xPos, yPosGround+1 + (this.getHeight()/2)+100);
			}
			
			this.getGraphics().drawImage(backBuffer,  0,  0,  null);
		}
	}

}
