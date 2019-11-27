package com.tutorial.java.interview;

public class FinallyClass {
	public static void main(String[] args) {
		try {
			System.out.println("try");
			 //return; //will finally block execute or not ? - YES
			System.exit(0);  //will finally block execute or not ? - NO
		}catch(Exception e) {
			System.out.println("catch");
		}finally {
			System.out.println("finally");
		}
	}
}
