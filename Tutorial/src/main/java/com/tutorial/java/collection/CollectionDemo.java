package com.tutorial.java.collection;

public class CollectionDemo {

	public static void main(String[] args) {
		System.out.println(space(4)+"Iterable"+space(4));
		System.out.println(space(8)+"|"+space(8));
		System.out.println(space(4)+dash(4));
		System.out.println(space(2)+"Collection"+space(2));
		System.out.println(space(1)+"List"+space(1));
	}
	
	private static String space(int n) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			sb.append(" ");
		}
		return sb.toString();
	}
	
	private static String dash(int n) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			sb.append("-");
		}
		return sb.toString();
	}

}
