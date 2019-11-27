package com.tutorial.java.collection;

import java.util.HashMap;
import java.util.WeakHashMap;

public class WeakHashMapDemo {
	
	public static void main(String[] args) throws InterruptedException {
		weakHashMapDemo();
	}
	
	public static void weakHashMapDemo() throws InterruptedException
	{
		WeakHashMap<Object, String> weakHashMap = new WeakHashMap<Object, String>();
		Object string = "a";
		weakHashMap.put(string, "abc");
		
		weakHashMap.put("ab", "jhsbhj");
		
		
		
		HashMap<Object, String> map = new HashMap<Object, String>();
		
		map.put(string, "cde");
		map.put("ab", "skcjbskj");
		
		System.out.println("weakHashMap = "+weakHashMap);
		System.out.println("map="+map);
		
		
		string = null;
		System.out.println("weakHashMap = "+weakHashMap);
		System.out.println("map="+map);
		
		System.gc();
		Thread.sleep(5000);
		
		System.out.println("weakHashMap = "+weakHashMap);
		System.out.println("map="+map);
		
	}
}
