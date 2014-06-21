package com.standalone.examples.producerconsumer;

public class Producer implements Runnable{

	private QueueMessage queueMessage;
	
	Producer(final QueueMessage queueMessage) {
		this.queueMessage = queueMessage;
		new Thread(this, "Producer").start();
	}
	@Override
	public void run() {
		//int i = 0;
/*		while(true) {
			queueMessage.put(i++);
		}*/
		for (int i = 0; i < 10; i++) {
			queueMessage.put(i++);
		}
	}

}
