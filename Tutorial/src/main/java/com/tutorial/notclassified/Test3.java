package com.tutorial.notclassified;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class Test3 {
	
	public static void main(String[] args) {
		/*
		 * int[] A = {1,1,2,3,4}; printArray(A); arrayManipulation(A); System.out.println(); printArray(A);
		 */
		
		CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<Integer>();
		
		copyOnWriteArrayList.add(1);
		
		System.out.println(copyOnWriteArrayList);
		
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		arrayList.add(1);
		arrayList.add(2);
		
		Iterator<Integer> iterable = copyOnWriteArrayList.iterator();
		
		while(iterable.hasNext()) {
			System.out.println(iterable.next());
			copyOnWriteArrayList.add(4);
		}
		
	}
	
	private static void printArray(int[] A) {
		for(int i=0;i<A.length;i++) {
			System.out.print(A[i]+" ");
		}
	}

	public static void arrayManipulation(int[] A) {
		int[] c = {1,2};
		A = c;
	}
}
