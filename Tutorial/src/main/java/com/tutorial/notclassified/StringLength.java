package com.tutorial.notclassified;

import java.util.LinkedHashSet;

public class StringLength {
	
	public static void main(String[] args) {
		String string = "<path isPartOfHierarchy=\"true\"  useAs=\"value\">$.[*].[?(@.metric=='throughput')]..tags[?(@.component=='ingest'&&@.type=='empty')].component</path>";
		
		System.out.println(string.charAt(124));
		
		LinkedHashSet<Object> set = new LinkedHashSet<Object>();
		set.add("a");
		
		System.out.println(set);
		
		callByValue(set);
		
		System.out.println(set);
		
		
	}
	
	
	public static void callByValue(LinkedHashSet<Object> set)
	{
		set.add("abc");
	}
	

}
