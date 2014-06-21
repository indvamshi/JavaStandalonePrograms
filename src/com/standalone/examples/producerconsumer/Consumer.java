package com.standalone.examples.producerconsumer;

public class Consumer implements Runnable{

	private QueueMessage queueMessage;
	
	public Consumer(QueueMessage queueMessage) {
		this.queueMessage = queueMessage;
		new Thread(this, "Consumer").start();
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			queueMessage.get();
		}
		
/*		while(true) {
			queueMessage.get();
		}
*/
	}

}
