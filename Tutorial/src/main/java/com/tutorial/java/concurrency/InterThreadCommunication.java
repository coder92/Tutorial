package com.tutorial.java.concurrency;

public class InterThreadCommunication {
	public static void main(String args[]) {
		Q q = new Q();
		new Producer(q);
		new Consumer(q);
		System.out.println("Press Control-C to stop.");
	}
}


//An incorrect implementation of a producer and consumer.
/*class Q {
	int n;
	synchronized int get() {
		System.out.println("Got: " + n);
		return n;
	}
	synchronized void put(int n) {
		this.n = n;
		System.out.println("Put: " + n);
	}
}

class Producer implements Runnable {
	Q q;
	Producer(Q q) {
		this.q = q;
		new Thread(this, "Producer").start();
	}
	public void run() {
		int i = 0;
		while(true) {
			q.put(i++);
		}
	}
}
class Consumer implements Runnable {
	Q q;
	Consumer(Q q) {
		this.q = q;
		new Thread(this, "Consumer").start();
	}
	public void run() {
		while(true) {
			q.get();
		}
	}
}*/


//A correct implementation of a producer and consumer.
class ITCQ {
	int n;
	boolean valueSet = false;
	synchronized int get() {
		while(!valueSet)
			try {
				wait();
			} catch(InterruptedException e) {
				System.out.println("InterruptedException caught");
			}
		System.out.println("Got: " + n);
		valueSet = false;
		notify();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		return n;
	}
	synchronized void put(int n){
		while(valueSet)
			try {
				wait();
			} catch(InterruptedException e) {
				System.out.println("InterruptedException caught");
			}
		this.n = n;
		valueSet = true;
		System.out.println("Put: " + n);
		notify();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
class ITCProducer implements Runnable {
	Q q;
	ITCProducer(Q q) {
		this.q = q;
		new Thread(this, "Producer").start();
	}
	public void run() {
		int i = 0;
		while(true) {
			q.put(i++);
		}
	}
}
class ITCConsumer implements Runnable {
	Q q;
	ITCConsumer(Q q) {
		this.q = q;
		new Thread(this, "Consumer").start();
	}
	public void run() {
		while(true) {
			q.get();
		}
	}
}