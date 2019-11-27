/*
Java Set is a collection of elements (Or objects) that contains no duplicate elements.
NOT an ordered collection
Unlike List, Set DOES NOT allow you to add duplicate elements.
Set allows you to add at most one null element only.

*/


package com.tutorial.java.collection;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(1);
		set.add(null);
		set.add(3);
		set.add(null);
		
		System.out.println(set);
	}
	
}
