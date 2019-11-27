package com.tutorial.java.concurrency;

import java.util.ArrayList;

public class ProducerConsumerIPCList {
	public static void main(String[] args) {
		PC pc = new PC();
		
		Thread producer = new Thread(new ProducerIPC(pc));
		
		Thread consumer = new Thread(new ConsumerIPC(pc));
		
		producer.start();
		
		consumer.start();
		
	}
}

class ProducerIPC implements Runnable{

	PC pc;
	public ProducerIPC(PC pc) {
		this.pc = pc;
	}
	@Override
	public void run() {
		pc.produce();
	}
	
}

class ConsumerIPC implements Runnable{

	PC pc;
	
	public ConsumerIPC(PC pc) {
		this.pc = pc;
	}
	@Override
	public void run() {
		pc.consume();
	}
	
}

class PC{
	ArrayList<Integer>  list = new ArrayList<Integer>();
	int maxSize = 5;

	public void produce() {
		int i=0;
		try {
			while(true) {
				synchronized(this) {
					if(list.size()==maxSize)
						wait();
				list.add(i++);
				
				System.out.println("Producer producered item : "+list.get(list.size()-1));
				
				notify();
				
				Thread.sleep(1000);
				
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void consume() {
		try {
			while(true) {
				synchronized(this) {
					if(list.size() ==0 ) {
						wait();
					}
					
					int val = list.remove(0);
					
					System.out.println("Consumer consumed item: "+val);
					
					notify();
					
					Thread.sleep(1000);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}