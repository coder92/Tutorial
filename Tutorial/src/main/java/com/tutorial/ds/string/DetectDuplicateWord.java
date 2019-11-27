package com.tutorial.ds.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectDuplicateWord {
	public static void main(String[] args) {
		String s= "I am ; a free . man : who want to get # a free_pass";
		
		Pattern p = Pattern.compile("(\\d+)|([a-zA-Z]+)");
		Matcher m = p.matcher(s);
		
		m.results();
		String[] strArr = s.split("(;)|(.)|(\\s)");
		
		for(int i=0;i<strArr.length;i++) {
			System.out.println(strArr[i]);
		}
	}

}
