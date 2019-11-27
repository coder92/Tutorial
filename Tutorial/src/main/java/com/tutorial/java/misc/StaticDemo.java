package com.tutorial.java.misc;

public class StaticDemo {
	public static void main(String[] args) {
		try {
			B b = null;
			b.getB();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class B{
	public static void getB() {
		System.out.println("B");
	}
}