package com.tutorial.java.collection;

import java.util.Hashtable;

/**
 * <h2>Hashtable vs Hashmap<h2> <br>
 * <ul>
 * <li>HashMap is non synchronized while Hashtable is synchronized</li> 
 * <li>One more minor difference is that HashMap allows a null key but Hashtable doesn't.</li>
 * </ul>
 * <br>
 * @author Ankit.Dixit
 *
 */
public class HashTableDemo {
	public static void main(String[] args) {
		Hashtable<String, String> hashtable = new Hashtable<String, String>();
		hashtable.put("als", "a");
		hashtable.put("B", "B");
		System.out.println(hashtable);
		//hashtable.put(null, "b");
		hashtable.put("V", null);
	}
}
