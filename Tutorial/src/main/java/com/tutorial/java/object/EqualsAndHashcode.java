package com.tutorial.java.object;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;
import java.util.HashSet;
import java.util.Set;

public class EqualsAndHashcode implements Referenceable{
	
	String firstName, lastName;
	
	public EqualsAndHashcode(String fn, String ln) {
		this.firstName = fn;
		this.lastName = ln;
	}

	/*
	 * @Override public boolean equals(Object obj) { System.out.println("equals"); EqualsAndHashcode f = (EqualsAndHashcode) obj; return
	 * firstName.equals(f.firstName) && lastName.equals(f.lastName); }
	 */
	@Override
	public int hashCode() {
		
		int hashcode = 31*firstName.hashCode()+ lastName.hashCode();
		System.out.println("hashcode = "+hashcode);
		return hashcode;
	}
	
	public static void main(String[] args) {
		Set<EqualsAndHashcode> set = new HashSet<EqualsAndHashcode>();
		EqualsAndHashcode h1 = new EqualsAndHashcode("Ankit", "Dixit");
		set.add(h1);
		EqualsAndHashcode h2 = new EqualsAndHashcode("Ankit", "Dixit");
		System.out.println(set.contains(h2));
		
		System.out.println("-----------------");
		System.out.println(h1==h2);
		
		System.out.println(h1.equals(h2));
		
		System.out.println(Integer.toHexString(System.identityHashCode(h1)));
		
		System.out.println(Integer.toHexString(System.identityHashCode(h2)));
		
		String s1 = "ankit";
		String s2 = new String("ankit");
		
		System.out.println(Integer.toHexString(System.identityHashCode(s1)));
		
		System.out.println(Integer.toHexString(System.identityHashCode(s2)));
		
		
	}

	@Override
	public Reference getReference() throws NamingException {
		
		return null;
	}
	
	
}
