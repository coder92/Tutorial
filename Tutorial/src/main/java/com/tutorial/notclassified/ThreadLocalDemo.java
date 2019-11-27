package com.tutorial.notclassified;

public class ThreadLocalDemo {
	public static void main(String[] args) {
		
		ThreadDemoSupporterClass obj = new ThreadDemoSupporterClass();
		Thread t1 = new Thread(obj);
		Thread t2 = new Thread(obj);
		
		t1.setName("thread1");
		t2.setName("thread2");
		
		t1.start();
		t2.start();
	}
}


class ThreadDemoSupporterClass implements Runnable{

	ThreadLocal<Integer> list = new ThreadLocal<Integer>();
	@Override
	public void run() {
		if(Thread.currentThread().getName().equals("thread1"))
		{
			list.set(1);
		}else
		{
			list.set(2);
		}
		
		System.out.println("List of thread :"+Thread.currentThread().getName()+" is :"+list.get());
		
		
	}
	
}