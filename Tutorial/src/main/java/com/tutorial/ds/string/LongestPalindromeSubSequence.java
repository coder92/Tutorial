package com.tutorial.ds.string;

public class LongestPalindromeSubSequence {
	public static void main(String[] args) {
		
	}
	
	public String bruteForceApproach(String str) {
		return null;
	}
	
	public String DPApproach(String str) {
		int n = str.length();
		boolean table[][] = new boolean[n][n];
		
		int maxLen = 1;
		
		for(int i=0;i<n;i++) {
			table[i][i] = true;
		}
		
		//check for substring of length 2 
		
		return null;
	}
	
	
}
