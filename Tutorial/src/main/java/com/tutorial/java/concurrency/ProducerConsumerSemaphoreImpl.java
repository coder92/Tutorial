package com.tutorial.java.concurrency;

import java.util.concurrent.Semaphore;

public class ProducerConsumerSemaphoreImpl {
	
	public static void main(String[] args) {
		Q q = new Q();
		Thread producer = new Thread(new Producer(q));
		Thread consumer = new Thread(new Consumer(q));
		
		producer.start();
		
		consumer.start();
	}
}

class Q{
	int item;
	
	Semaphore producerSem = new Semaphore(1);
	Semaphore consumerSem = new Semaphore(0);
	
	public void get() {
		try {
			consumerSem.acquire();
			
			System.out.println("COnsumer consumed the item : "+item);
			
			producerSem.release();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void put(int item) {
		try {
			producerSem.acquire();
			
			//do something
			this.item = item;
			
			System.out.println("Producer produce item : "+item);
			
			consumerSem.release();
			
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Producer implements Runnable{

	Q q;
	
	public Producer(Q q) {
		this.q = q;
	}
	
	@Override
	public void run() {
		for(int i=0;i<5;i++) {
			q.put(i);
		}
	}
	
}

class Consumer implements Runnable{

	Q q;
	
	public Consumer(Q q) {
		this.q = q;
	}
	
	@Override
	public void run() {
		
		for(int i=0;i<5;i++) {
			q.get();
		}
	}
	
}