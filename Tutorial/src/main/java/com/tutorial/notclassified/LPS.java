package com.tutorial.notclassified;

public class LPS {
	
	private String getLPS(String str) {
		if(str ==  null)
			return null;
		if(str.length()==1)
			return str;
		
		if(checkFL(str)){
			
		}else {
			
		}
		return str;
	}
	
	private boolean checkFL(String str) {
		return (str.charAt(0) == str.charAt(str.length()-1));
	}
	
	public static void main(String[] args) {
		
	}
}
