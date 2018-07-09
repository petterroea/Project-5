package com.project5;

import java.util.LinkedList;

public class AsyncWorker {
	private LinkedList<AsyncTask> tasks = new LinkedList<AsyncTask>();
	private LinkedList<Thread> threads = new LinkedList<Thread>();
	private boolean running = false;
	
	public AsyncWorker() {
		
	}
	
	public void addTask(AsyncTask task) {
		if(running) {
			throw new RuntimeException("Attempted to add task after the workers were started");
		}
		tasks.add(task);
	}
	
	public void start() {
		running = true;
		for(AsyncTask task : tasks) {
			Thread t = new Thread(task);
			t.start();
			threads.add(t);
		}
	}
	
	public boolean tasksAreRunning() {
		return running;
	}
	
	public boolean tasksAreDone() {
		boolean oneRunning = false;
		for(AsyncTask task : tasks) {
			oneRunning = oneRunning || !task.isDone();
		}
		for(Thread t : threads) {
			oneRunning = oneRunning || t.isAlive();
		}
		return !oneRunning;
	}
	public void waitForRunning() {
		while(!tasksAreDone()) {
			try {
				Thread.sleep(10L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
