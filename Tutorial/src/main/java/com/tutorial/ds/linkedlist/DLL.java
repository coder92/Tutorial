package com.tutorial.ds.linkedlist;

import java.util.Collection;

/*
 * @author: ankit.dixit
 * implementation of doubly linkedlist
 */

public class DLL<E> {
	
	transient Node<E> first;
	transient Node<E> last;
	transient int size=0;
	
	public DLL() {
		
	}
	
	public DLL(Collection<? extends E> c) {
		this();
		addAll(c);
	}
	
	private void linkFirst(E e) {
		Node<E> f = first;
		
	}
	
	
	public boolean add(E item) {
		
		return false;
	}
	
	public boolean addAll(Collection c) {
		return false;
	}
	
	
	
	
	
	private class Node<E>{
		E item;
		Node<E> prev;
		Node<E> next;
		
		public Node(Node<E> prev, E item, Node<E> next) {
			this.prev = prev;
			this.item = item;
			this.next = next;
		}
	}

}
