/*
Java ThreadLocal is used to create thread local variables.
We can use synchronization for thread safety but if we want to avoid synchronization, we can use ThreadLocal variables.
Every thread has it’s own ThreadLocal variable and they can use it’s get() and set() methods to get the default value or change it’s value local to Thread.
ThreadLocal instances are typically private static fields in classes that wish to associate state with a thread.

ThreadLocal class is extend in Java 8 with a new method withInitial() that takes Supplier functional interface as argument.


*/
package com.tutorial.java.concurrency;

import java.text.SimpleDateFormat;
import java.util.Random;

public class ThreadLocalDemo implements Runnable{

    // SimpleDateFormat is not thread-safe, so give one to each thread
	
	private static final ThreadLocal<Integer> threadLocalObj = new ThreadLocal<Integer>();
    private static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue()
        {
            return new SimpleDateFormat("yyyyMMdd HHmm");
        }
    };
    
    public static void main(String[] args) throws InterruptedException {
        ThreadLocalDemo obj = new ThreadLocalDemo();
        for(int i=0 ; i<10; i++){
            Thread t = new Thread(obj, ""+i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }
    }

    @Override
    public void run() {
        System.out.println("Thread Name= "+Thread.currentThread().getName()+" default Formatter = "+formatter.get().toPattern());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadLocalObj.set(new Random().nextInt(100));
        //formatter pattern is changed here by thread, but it won't reflect to other threads
        formatter.set(new SimpleDateFormat());
        
        System.out.println("Thread Name= "+Thread.currentThread().getName()+" threadLocalObj = "+threadLocalObj.get());
        System.out.println("Thread Name= "+Thread.currentThread().getName()+" formatter = "+formatter.get().toPattern());
    }
    
    static void lamdaThreadLocalImpl(){

    	final ThreadLocal<SimpleDateFormat> formatter = 
    			ThreadLocal.<SimpleDateFormat>withInitial
    			(() -> {return new SimpleDateFormat("yyyyMMdd HHmm");});

    }

}
