package com.tutorial.java.collection;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Dequeue Interface
	A linear collection that supports element insertion and removal at both ends. 
	The name deque is short for “double-ended queue” and is usually pronounced “deck”. 
	Most Deque implementations place no fixed limits on the number of elements they may contain, 
	but this interface supports capacity-restricted deques as well as those with no fixed size limit.

 * @author Ankit.Dixit
 *
 */

public class ArrayDequeImpl{
	
	public static void main(String[] args) {
		
		ArrayDeque<Integer> arrayDeque = null; 
		ArrayDequeImpl obj = new ArrayDequeImpl(arrayDeque);
	}
	
	//default size - 16
	public ArrayDequeImpl(ArrayDeque<Integer> arrayDeque) {
		arrayDeque = new ArrayDeque<Integer>();
		System.out.println("ArrayDeque instance has been created with default size = 16.");
	}
	
	public void methodExplored(ArrayDeque<Integer> arrayDeque){
		arrayDeque.add(1);
		System.out.println("add(1): "+arrayDeque);
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(2); 
		list.add(3);
		arrayDeque.addAll(list);		
		System.out.println("addAll(list): "+arrayDeque);
		
		arrayDeque.addFirst(4);
		
		arrayDeque.addLast(5);
	}
	
}
