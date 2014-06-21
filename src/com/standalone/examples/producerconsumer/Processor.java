package com.standalone.examples.producerconsumer;

import java.util.Scanner;

public class Processor {

	
	public void produce() throws InterruptedException {
	
		synchronized (this) {
			System.out.println("producing ....");
			wait();
			System.out.println("producer resumed");
		}
	}
	
	public void consume() throws InterruptedException {
		Scanner scanner = new Scanner(System.in);
		Thread.sleep(2000);
		synchronized (this) {
			System.out.println("consuming");
			scanner.nextLine();
			System.out.println("Return key pressed");
			notify();
		}
	}
}
