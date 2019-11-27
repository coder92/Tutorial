package com.tutorial.ds.stack;

import java.util.Arrays;

public class StackImpl {
	
	private Object[] stackArr; 
	private int size;
	private int capacity;
	
	public StackImpl() {
		size=0;
		capacity =16;
		stackArr = new Object[capacity];
	}
	
	public void push(Object data) {
		if(size==capacity) {
			capacity = capacity*2;
			stackArr = Arrays.copyOf(stackArr, capacity);
		}
		stackArr[size++] = data;
	}
	
	public Object pop(){
		
		return new Object();
	}
	
	public Object peek() {
		return new Object();
	}

	public boolean isFull() {
		return false;
	}
	
	public boolean isEmpty() {
		return true;
	}
	
	public int size() {
		return size;
	}
	
	public void display() {
		System.out.println(Arrays.asList(stackArr));
	}
}
