package com.tutorial.java.interview;

public class AutoBoxingUnBoxing {
	public static void main(String[] args) {
		Long l1 = 1l;
		Long l2 = 2l;
		
		System.out.println(l1==l2);
		
		l1++;
		l2++;
		
		System.out.println(l1==l2);
	}
}
