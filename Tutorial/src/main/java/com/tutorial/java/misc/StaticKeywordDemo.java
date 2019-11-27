package com.tutorial.java.misc;

public class StaticKeywordDemo {
	
}

abstract class ParentAbstractClass{
	abstract public void getName();
}

class Child extends ParentAbstractClass{

	@Override
	public void getName() {
		System.out.println("Hi");
		
	}
	
}
