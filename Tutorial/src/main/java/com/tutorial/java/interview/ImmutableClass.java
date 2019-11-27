package com.tutorial.java.interview;

import java.util.HashMap;

public final class ImmutableClass {
	private final int age;
	private final String name;
	private final int id;
	private final HashMap<Integer, Integer> map;
	
	public ImmutableClass(int age , String name , int id, HashMap<Integer, Integer> map) {
		this.age = age;
		this.name = name;
		this.id=id;
		
		//perform deep copy 
		HashMap<Integer, Integer> tMap = new HashMap<Integer, Integer>();
		for(Integer key: map.keySet()) {
			tMap.put(key, map.get(key));
		}
		this.map = tMap;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	@SuppressWarnings("unchecked")
	public HashMap<Integer, Integer> getMap() {
		return (HashMap<Integer, Integer>) map.clone();
	}
	
	public static void main(String[] args) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 1);
		map.put(2, 2);
		ImmutableClass obj = new ImmutableClass(12, "ankit", 2, map);
		
		map = obj.getMap();
		
		System.out.println(obj.getMap());
		
		map.put(3, 3);
		
		System.out.println(obj.getMap());
	}
}
