package com.tutorial.java.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorDemo {
	
	public static void main(String[] args) {
		
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student(1,"anil", 101));
		list.add(new Student(5,"joy",104));
		
		list.add(new Student(3,"ram",102));
		
		list.add(new Student(4,"rahul",106));
		
		System.out.println("List before Sorting");
		
		Collections.sort(list, new NameComparator());
		
	}
	
}


class Student{
	int id;
	String name;
	int rollNumber;
	
	
	public Student(int id, String name, int rollNumber) {
		this.id = id;
		this.name = name;
		this.rollNumber = rollNumber;
	}
	
}


class NameComparator implements Comparator<Student>{

	@Override
	public int compare(Student s1, Student s2) {
		return s1.name.compareTo(s2.name);
	}
	
}


class IdComparator implements Comparator<Student>{
	
	@Override
	public int compare(Student s1, Student s2) {
		if(s1.id == s2.id)
			return 0;
		if(s1.id >s2.id)
			return 1;
		else
			return -1;
	}
}

class RollNumberComparator implements Comparator<Student>{
	@Override
	public int compare(Student s1, Student s2) {
		if(s1.rollNumber == s2.rollNumber)
			return 0;
		if(s1.rollNumber > s2.rollNumber)
			return 1;
		else
			return -1;
	}
}