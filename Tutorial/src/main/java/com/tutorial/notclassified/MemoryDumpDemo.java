package com.tutorial.notclassified;

public class MemoryDumpDemo {
	
	public static void main(String[] args) {
		int i=0;
		String string ="ssss";
		
		while(true) {
			System.out.println("Memory Dump - "+i);
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
