package com.standalone.examples.javamemory;

public class ThreadRunableExample implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(ThreadRunableExample.class.getName() + " is running");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(ThreadRunableExample.class.getName() + " is running");
	}
	
	public static void main(String[] args) {
		ThreadRunableExample example = new ThreadRunableExample();
		Thread thread = new Thread(example);
		thread.start();
		
	}

}
