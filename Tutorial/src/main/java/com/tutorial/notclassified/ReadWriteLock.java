package com.tutorial.notclassified;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock {
	public static void main(String[] args) {
		ReaderWriter rw = new ReaderWriter();
		
		Thread t1 = new Thread(rw);
		
		Thread t2 = new Thread(rw);
		
		t1.start();
		t2.start();
		
	}
}

class ReaderWriter implements Runnable {
	int count = 0;

	@Override
	public void run() {
		
		ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
		
		while(true)
		{
			reentrantReadWriteLock.readLock().lock();
			
			System.out.println(count);
			
			reentrantReadWriteLock.readLock().unlock();
			
			
			reentrantReadWriteLock.writeLock().lock();
				count++;
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			reentrantReadWriteLock.writeLock().unlock();
		}
	
	}
}



