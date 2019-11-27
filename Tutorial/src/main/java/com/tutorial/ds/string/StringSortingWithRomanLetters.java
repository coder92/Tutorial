package com.tutorial.ds.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringSortingWithRomanLetters {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());

		//abc XI| abc VIII| bcd XXII|
		while(t-->0){
			System.out.println(sortRomanLetterString(br.readLine()));
		}
	}


	private static String sortRomanLetterString(String str){
		String sortedString;
		return null;

		

	}
}
