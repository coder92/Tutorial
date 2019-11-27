package com.tutorial.notclassified;

public class DeadLock {
	
	public static void main(String[] args) {
		
		final String s1 = "str1";
		final String s2 = "str2";
		
		Thread t1 = new Thread() {
			public void run() {
				synchronized (s1) {
					System.out.println("String locked : by thread 1 :"+ s1);
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					synchronized (s2) {
						System.out.println("String locked: by thread1 :"+s2);
					}
				}
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				
				synchronized (s2) {
					System.out.println("String locked by thread2 :"+s2);
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					synchronized (s1) {
						System.out.println("String locked by thread2 :"+s1);
					}
				}
				
			}
		};
		
		t1.start();
		
		t2.start();
		
	}
	
	
	
}
