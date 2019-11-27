package com.tutorial.notclassified;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemo {
	public static void main(String[] args) {
		
		ThreadDemo tDemo = new ThreadDemo();
		
		for(int i=0;i<10;i++) {
			Thread thread = new Thread(tDemo);
			
			thread.setName("Thread-"+i);
			thread.start();
		}
		
	}
	
	
}


class ThreadDemo implements Runnable{

	int a = 1;
	
	//critical section
	@Override
	public void run() {
		ReadWriteLock rwl = new ReentrantReadWriteLock();
		
		System.out.println("Thread "+ Thread.currentThread().getName()+ " before reading.");
		
		rwl.readLock().lock();
		//read section
		
		System.out.println("Thread "+ Thread.currentThread().getName() + " is reading now. a = "+a);
		
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		rwl.readLock().unlock();
		
		System.out.println("Thread "+ Thread.currentThread().getName()+ " after reading and before writing.");

		
		rwl.writeLock().lock();
		//write section
		a++;
		System.out.println("Thread "+ Thread.currentThread().getName()+ " is writing now. a = "+ a);

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		rwl.writeLock().unlock();
		
		
		
	}
	
}