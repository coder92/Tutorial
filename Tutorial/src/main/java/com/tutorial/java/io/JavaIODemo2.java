package com.tutorial.java.io;

//Use a BufferedReader to read string from the console.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class JavaIODemo2 {
	public static void main(String args[])
			throws IOException
	{
		BufferedReader br = new
				BufferedReader(new InputStreamReader(System.in));

		String str;
		System.out.println("Enter lines of text.");
		System.out.println("Enter 'stop' to quit.");
		do {
			str = br.readLine();
			System.out.println(str);
		} while(!str.equals("stop"));
	}
}