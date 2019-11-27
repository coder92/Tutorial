package com.tutorial.java.concurrency;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
	public static void main(String[] args) throws InterruptedException {
		Semaphore s = new Semaphore(0);
		s.acquire();
	}
}
