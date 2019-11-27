/*
HashSet is not thread-safe. You can get thread-safe HashSet using 
Collections.synchronizedSet method at the cost of performance.
You can also use CopyOnWriteArraySet concurrency class for thread safety.
HashSet iterator methods are fail-fast
can be converted list to hashset and vice-versa
 */

package com.tutorial.java.collection;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class HashSetDemo {
	public static void main(String[] args) {
		HashSet<Integer> hashSet = new HashSet<Integer>();
		hashSet.add(21);
		hashSet.add(null);
		hashSet.add(22);
		hashSet.add(null);
		hashSet.add(21);
		
		System.out.println(hashSet);
		
		Set<Integer> set  = Collections.synchronizedSet(hashSet);
		CopyOnWriteArraySet<Integer> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
		copyOnWriteArraySet.add(3);
		set.add(3);
	}
}
