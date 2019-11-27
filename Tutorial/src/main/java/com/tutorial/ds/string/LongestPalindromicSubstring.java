package com.tutorial.ds.string;

import java.util.HashMap;

public class LongestPalindromicSubstring {
	
	public static void main(String[] args) {
		LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
		obj.test();
	}
	
	//find all substring and then 
	//check isPalindrome or not 
	private String longestSubstringPalindrome(String str){
		int max =1;
		String lps=str.charAt(0)+"";

		//find all substring

		for(int i=0;i<str.length();i++){
			StringBuilder sb = new StringBuilder();
			sb.append(str.charAt(i));
			for(int j=i+1;j<str.length();j++){
				sb.append(str.charAt(j));
				if(isPalindrome( sb.toString() ) ){
					if(max < sb.length() ) {
						max = sb.length();
						lps = sb.toString();
					}
				}
			}
		}
		return lps;
	}

	private boolean isPalindrome(String str){
		int i=0;
		int j = str.length()-1;

		while(i<j){
			if(str.charAt(i++) != str.charAt(j--) )
				return false;
		}
		return true;
	}
	
	private void test() {
		HashMap<String, String> inputOutputMap = new HashMap<String, String>();
		
		inputOutputMap.put("aaaabbaa", "aabbaa");
		
		
		for(String input: inputOutputMap.keySet()) {
			String actual = longestSubstringPalindrome(input);
			String expected = inputOutputMap.get(input);
			if(actual.equals(expected))
				System.out.println("clear for input : "+input);
			else
				System.out.println("Failed for input : "+ input+" | actual = "+ actual + "| expected = "+ expected);
		}
	}
}
