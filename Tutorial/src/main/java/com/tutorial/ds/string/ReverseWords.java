package com.tutorial.ds.string;

import com.tutorial.common.TestingClass;

/**
 * {@link https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string/0}
 * <p>
 * Given a String of length S, reverse the whole string without reversing the individual words in it. Words are separated by dots.

Input:
The first line contains T denoting the number of testcases. T testcases follow. Each case contains a string S containing characters.

Output:
For each test case, in a new line, output a single line containing the reversed String.

Constraints:
1 <= T <= 100
1 <= |S| <= 2000

Example:
Input:
2
i.like.this.program.very.much
pqr.mno

Output:
much.very.program.this.like.i
mno.pqr
 * </p>
 * 
 * @author Ankit.Dixit
 *
 */
public class ReverseWords {
	public static void main(String[] args) {
		ReverseWords obj = new ReverseWords();
		System.out.println(TestingClass.testString("my.name.is.ankit", "ankit.is.name.my"));
	}

	private String reverseWords(String inputLine){
	     StringBuilder sb = new StringBuilder();
	     
	     int s, e=inputLine.length()-1;
	     
	     while(true){
	         s = inputLine.lastIndexOf('.', e);
	         if(s==-1)
	            break;
	         
	         sb.append(inputLine.substring(s+1, e+1)).append(".");
	         e=s-1;
	         //System.out.println(sb);
	     }
	     sb.append(inputLine.substring(0,e+1));
	     return sb.toString();
	 }
}
