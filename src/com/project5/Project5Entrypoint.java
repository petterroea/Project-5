package com.project5;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import com.project5.gui.KeyboardEvent;
import com.project5.gui.MouseButtonEvent;
import com.project5.gui.MouseMotionEvent;
import com.project5.screens.LoadingScreen;

public class Project5Entrypoint extends Applet implements Runnable, GameWindow, MouseListener, MouseMotionListener, KeyListener{
	
	private Thread gameThread;
	//To avoid flickering, we draw to an image which we then quickly blit
	private BufferedImage backBuffer;
	private Screen currentScreen;
	
	@Override
	public void init() {
		gameThread = new Thread(this);
		
		//Start by loading assets
		currentScreen = new LoadingScreen(this);
		currentScreen.onTransitionIn();
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addKeyListener(this);
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
			currentScreen.update(g, delta);
			currentScreen.render(g, delta);
			
			this.getGraphics().drawImage(backBuffer,  0,  0,  null);
		}
	}

	@Override
	public void transitionToScreen(Screen screen) {
		currentScreen.onTransitionOut();
		currentScreen = screen;
		currentScreen.onTransitionIn();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		currentScreen.onMouseButton(new MouseButtonEvent(arg0.getX(), arg0.getY(), MouseButtonEvent.MouseButtonState.CLICK));
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		currentScreen.onMouseButton(new MouseButtonEvent(arg0.getX(), arg0.getY(), MouseButtonEvent.MouseButtonState.DOWN));
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		currentScreen.onMouseButton(new MouseButtonEvent(arg0.getX(), arg0.getY(), MouseButtonEvent.MouseButtonState.UP));
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		currentScreen.onMouseMotion(new MouseMotionEvent(e.getX(), e.getY(), MouseMotionEvent.MouseMotionType.DRAG));
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		currentScreen.onMouseMotion(new MouseMotionEvent(e.getX(), e.getY(), MouseMotionEvent.MouseMotionType.MOVE));
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		currentScreen.onKeyboard(new KeyboardEvent(arg0.getKeyChar(), arg0.getKeyCode(), KeyboardEvent.EventType.DOWN));
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		currentScreen.onKeyboard(new KeyboardEvent(arg0.getKeyChar(), arg0.getKeyCode(), KeyboardEvent.EventType.UP));
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		currentScreen.onKeyboard(new KeyboardEvent(arg0.getKeyChar(), arg0.getKeyCode(), KeyboardEvent.EventType.TYPE));
		
	}

}
