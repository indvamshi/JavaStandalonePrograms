package com.standalone.examples.javamemory;

public class BillPughSingletonMainExample implements Runnable {

	public static void main(String[] args) {
		
		BillPughSingletonMainExample example = new BillPughSingletonMainExample();
		new Thread(example).start();
		new Thread(example).start();
	}

	@Override
	public void run() {
		System.out.println("instance "+BillPughSingleton.getInstance().hashCode());
	}

}
