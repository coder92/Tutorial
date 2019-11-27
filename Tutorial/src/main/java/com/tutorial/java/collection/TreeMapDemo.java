/*
 TreeMap entries are sorted in the natural ordering of its keys.
 It also provides a constructor to provide Comparator to be used for ordering.
 log(n) time cost for the containsKey, get, put and remove operations.
 TreeMap is not synchronized and hence not thread-safe.
 Collections.synchronizedSortedMap method.
  Iterator is fail-fast(throw exception- ConcurrentModificationException. if collection is modified during iteration).
 
 make it thread-safe 
 	SortedMap m = Collections.synchronizedSortedMap(new TreeMap(...));
 
 HashMap vs TreeMap
 1.TreeMap entries are sorted in natural ordering of keys whereas HashMap doesn’t store entries in any order
 2. TreeMap doesn’t allow null key whereas we can have one null key in HashMap.
 3. TreeMap uses Red-Black tree based NavigableMap implementation whereas HashMap uses hashing algorithm implementation.
 
 TreeMap Internal Working
 Node } parent, right and left
 left < parent ; right >=parent
 
 Red-Black Tree
 	Root node must be Black in color
 	every node must either red or black
 	A red node can not have a red colour neighbor node
 	All paths from a root node to the null should consist the same number of black nodes.	

TreeMap Internal Working 
	K key;
	V value;
	Entry<K,V> left;
	Entry<K,V> right;
	Entry<K,V> parent;
	boolean color = BLACK;
 
 */


package com.tutorial.java.collection;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {
	public static void main(String[] args) {
		treeMapImpl();
		//lamdaTreeMapImpl();
	}

	private static void treeMapImpl() {
		MyComparator myComparator = new MyComparator();
		TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>(myComparator);
		treeMap.put(1, "A");
		treeMap.put(3, "BAA");
		treeMap.put(2, "AAAAAA");
		treeMap.put(2, null);
		//treeMap.put(null, "a");
		
		System.out.println(treeMap);
	}

	private static void lamdaTreeMapImpl() {
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>((x,y) -> {
			return  ( (x>y) ? -1 : ((x == y) ? 0 : 1) );
			});
	}
}

class MyComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		return (o1-o2);
	}
	
}


