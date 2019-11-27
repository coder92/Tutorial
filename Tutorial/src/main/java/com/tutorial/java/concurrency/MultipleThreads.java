package com.tutorial.java.concurrency;

public class MultipleThreads {
	public static void main(String[] args) {
		Countdown cd = new Countdown();
		CountdownThread cdt1 = new CountdownThread(cd);
		CountdownThread cdt2 = new CountdownThread(cd);
		cdt1.setName("Thread 1");
		cdt2.setName("Thread 2");
		cdt1.start();
		cdt2.start();
	}

}

class Countdown{
	private int i;
	 public  void  doCountDown() {
		String color ="red";
		/*
		 * switch(Thread.currentThread().getName()) { case "Thread 1": color = AnsiColor.ANSI_RED; break; case "Thread 2": color =
		 * AnsiColor.ANSI_GREEN; break; default: color= AnsiColor.ANSI_PURPLE; }
		 */
		
		synchronized(this) {
			for(i=0;i<10;i++) {
				System.out.println(color+ Thread.currentThread().getName()+":i="+i);
			}
		}
		
	}
}

class CountdownThread extends Thread{
	Countdown cd;
	public CountdownThread(Countdown c) {
		cd =c;
	}
	
	@Override
	public void run() {
		cd.doCountDown();
	}
}
