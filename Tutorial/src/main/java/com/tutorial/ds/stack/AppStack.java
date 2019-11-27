package com.tutorial.ds.stack;

public class AppStack {

	public static void main(String[] args) {
		
		myImpl();
		
		//javaImpl();
	}

	private static void javaImpl() {
		
		
	}

	private static void myImpl() {
		StackImpl stackImpl = new StackImpl();
		stackImpl.display();
		System.out.println(stackImpl.size());
		for(int i=1;i<=20;i++) {
			stackImpl.push(i);
			stackImpl.display();
		}
		System.out.println(stackImpl.size());
		
	}

}
