package com.tutorial.notclassified;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorDemo {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(1);
		list.add(2);
		list.add(5);
		
		ListIterator<Integer> listIterator = list.listIterator();
		
		while(listIterator.hasNext())
		{
			System.out.println(listIterator.next());
			listIterator.add(7);
		}
		
		System.out.println(list);
	}
	
	
}
