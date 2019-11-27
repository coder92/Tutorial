package com.tutorial.java.concurrency;

public class MainApp {
	
	static int count;

	public static void main(String[] args) throws InterruptedException {
		
		
		
		/*System.out.println("main thread");
		Thread t1 = new ThreadDemo();
		t1.start();
		System.out.println("main again");
		
		new Thread() {
			public void run() {
				System.out.println(this.toString()+">>Annonymous Class Thread");
			}; 
		}.start();*/
		
		//MyRunnable
		/*MyRunnable ob1 = new MyRunnable("one");
		MyRunnable ob2 = new MyRunnable("two");
		MyRunnable ob3 = new MyRunnable("three");
		
		System.out.println("checking isAlive");

		System.out.println("ob1.t.isAlive()="+ob1.t.isAlive());
		System.out.println("ob2.t.isAlive()="+ob2.t.isAlive());
		System.out.println("ob3.t.isAlive()="+ob3.t.isAlive());
		
		try {
			System.out.println("ob1.t.join()");
			ob1.t.join();
			
			System.out.println("ob2.t.join()");
			ob2.t.join();
			System.out.println("ob3.t.join()");
			ob3.t.join();
		}catch(InterruptedException e) {
			System.out.println("main thread interrupted");
		}*/
		
		
		//ThreadDemo1- 
		ThreadDemo1 td1 = new ThreadDemo1("td1",1,10);
		ThreadDemo1 td2 = new ThreadDemo1("td2",11,60);
		ThreadDemo1 td3 = new ThreadDemo1("td3",61,90);
		
		td1.start();
		td1.join();
		td2.start();
		td2.join();
		td3.start();
		td3.join();
		System.out.println("main thread end");
	}

}




class ThreadDemo1 extends Thread{

	//int count =0;
	String name;
	int a,b;

	public ThreadDemo1(String name, int a, int b){
		this.name=name;
		this.a = a;
		this.b=b;
	}
	@Override
	public void run() {
		System.out.println(">>ThreadDemo1");
		System.out.println("name="+name+"  count="+MainApp.count);
		incCounter();
	}
	
	void incCounter() {
		while(b-a>=0) {
			MainApp.count++;
			System.out.println("name="+name+"  count="+MainApp.count);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			a++;
		}
	}
}

class MyRunnable implements Runnable{
	String name;
	Thread t; 
	
	public MyRunnable(String name) {
		this.name = name;
		t = new Thread(this,name);
		System.out.println("MyRunnable>>New Thread>>"+t);
		t.start();
	}
	
	@Override
	public void run() {
		//System.out.println(">>run>>MyRunnable>>"+this.toString());
		try {
			for(int i=0;i<5;i++) {
				System.out.println(name+":"+i);
				Thread.sleep(1000);
			}
		}catch(InterruptedException e) {
			System.out.println(name+":"+"interrupted.");
		}
		System.out.println(name+" exiting");
	}
}


