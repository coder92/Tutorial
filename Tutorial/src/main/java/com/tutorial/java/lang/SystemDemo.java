package com.tutorial.java.lang;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * <h1>System Class of lang package </h1>
 * 
 * <p>
 * java.lang.*; - by default import 
 * so System class loads by-default.
 * </p>
 * </br>
 * <p>
 * System.out is print stream static reference in System class.  
 * which initialise when class loads and its value is the console.
 * we can change the value of it.
 * <p>
 * <br>
 * <p>
 * 
 * </p>
 * @author Ankit.Dixit
 *
 */

public class SystemDemo {

	public static void main(String[] args) throws FileNotFoundException {
		//startSystemDemo();
		
		System.out.println("System methods");
		
		consoleMethod();
		
	}

	private static void startSystemDemo() {
		PrintStream ps = null;
		try {

			System.out.println("System demo");
			
			ps = new PrintStream("resources/out.txt");
			System.setOut(ps);
			System.out.print("hi this is first line in out.txt file");
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ps.close();
		}
	}
	
	private static void consoleMethod() {
		System.out.println(System.console());
	}
}
