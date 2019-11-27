package com.tutorial.java.misc;

abstract class Parent {
	
	public abstract void getA();
	
	protected abstract void getB();
	
	public void getC() {
		System.out.println("C");
	}
	
	protected void getD() {
		System.out.println("D");
	}
	
	private void getE() {
		System.out.println("E");
	}
}


class ChildClass extends Parent{

	@Override
	public void getA() {
		System.out.println("Child:A");
	}

	@Override
	protected void getB() {
		System.out.println("Child:B");
	}
}


public class AbstractClassDemo{
	public static void main(String[] args) {
		ChildClass c = new ChildClass();
		c.getA();
		c.getB();
		c.getC();
		c.getD();
	}
}