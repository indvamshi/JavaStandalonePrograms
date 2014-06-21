package com.standalone.examples.producerconsumer;

public class WaitNotifyExample {

	public static void main(String[] args) {
		QueueMessage queueMessage = new QueueMessage();
		new Producer(queueMessage);
		new Consumer(queueMessage);
	}

}
