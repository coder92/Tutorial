package com.tutorial.ds.linkedlist;

public class App {

	public static void main(String[] args) {
		
		//testMyLinkedList();
		
		testJavaLinkedList();
		
	}

	private static void testJavaLinkedList() {
		System.out.println("Welcome to Java Linkedlist!!!");
		java.util.LinkedList<Integer> list = new java.util.LinkedList<Integer>();
		System.out.println(list);
		list.add(1);
		System.out.println(list);
		list.add(2, 2); //TODO: list start with 0, given index out of bound exception 
		System.out.println(list);
		
	}

	private static void testMyLinkedList() {
		System.out.println("Welcome to My Linkedlist!!!");
		LinkedList linkedList = new SimpleLinkedList();
		linkedList.display();
		
		for(int i=1;i<5;i++) {
			linkedList.addFirst(i);
			linkedList.display();
		}
		for(int i=6;i<10;i++) {
			linkedList.addLast(i);
			linkedList.display();
		}
		linkedList.delete(6);
		linkedList.display();
		linkedList.delete(1);
		linkedList.display();
		
		linkedList.delete(linkedList.size());
		linkedList.display();
		
		System.out.println(linkedList.indexOf(6));
		
	}

}
