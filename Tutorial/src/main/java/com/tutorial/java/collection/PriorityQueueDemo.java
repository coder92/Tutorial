/*
 Queue follows First-In-First-Out model but sometimes we need to process the objects in the queue based on the priority. That is when Java PriorityQueue is used
 ex. premium customer first 
 PriorityQueue is an unbounded queue based on a priority heap
 elements of the priority queue are ordered by default in natural order. 
 We can provide a Comparator for ordering at the time of instantiation of priority queue.
 Java Priority Queue doesn’t allow null values and we can’t create PriorityQueue of Objects that are non-comparable. 
  if there are multiple objects with same ordering, then it can poll any one of them randomly. 
  When we poll the queue, it returns the head object from the queue
  PriorityQueue is not thread safe | PriorityBlockingQueue - thread safe
  take O(log(n)) time for enqueing and dequeing method.
 */

package com.tutorial.java.collection;

import java.util.*;

public class PriorityQueueDemo {

	public static void main(String[] args) {
		naturalOrderingPriorityQueueDemo();
		comparatorPriorityQueueDemo();
	}
	private static void naturalOrderingPriorityQueueDemo() {
		System.out.println("============naturalOrderingPriorityQueueDemo============");
		Queue<Integer> priorityQueue = new PriorityQueue<Integer>();
		priorityQueue.add(3);
		priorityQueue.add(4);
		priorityQueue.add(1);
		priorityQueue.add(7);
		priorityQueue.add(2);
		
		  Random r = new Random(10); for(int i=0;i<10;i++) { priorityQueue.add(r.nextInt(10)); }
		 
		System.out.println(priorityQueue);
		
		while(!priorityQueue.isEmpty()) {
			System.out.print(priorityQueue.poll()+" ");
		}
		System.out.println("");
	}
	
	private static void comparatorPriorityQueueDemo() {
		System.out.println("===========comparatorPriorityQueueDemo==========");
		Queue<StudentPriorityQueue> priorityQueue = new PriorityQueue<StudentPriorityQueue>(new PQIdComparator());
		
		for(int i=0;i<10;i++) {
			StudentPriorityQueue obj = new StudentPriorityQueue();
			
			obj.setId(new Random().nextInt(100));
			obj.setName("name-"+i);
			obj.setDob(new Date());
			priorityQueue.add(obj);
		}
		
		System.out.println(priorityQueue);
		
		while(!priorityQueue.isEmpty()) {
			System.out.print(priorityQueue.poll()+" ");
		}
		System.out.println();
	}

}


class StudentPriorityQueue{
	long id;
	String name;
	Date dob;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "[id=" + id+ "]";
	}
}

class PQIdComparator implements Comparator<StudentPriorityQueue>{

	@Override
	public int compare(StudentPriorityQueue o1, StudentPriorityQueue o2) {
		return (int)(o1.id-o2.id);
	}
}

