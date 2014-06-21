package com.standalone.examples.producerconsumer;

public class ProducerConsumerExample {

	public static void main(String[] args) throws InterruptedException {

		final Processor processor = new Processor();
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					processor.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					processor.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		thread1.start();
		thread2.start();
		
		thread1.join();
		thread2.join();
	}

}
