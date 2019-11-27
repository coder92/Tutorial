package com.tutorial.java.annotations;

import java.lang.reflect.Method;

public class AnnaotationImpl {

	public static void main(String[] args) {
		testMyAnnotation();
	}
	
	@MyAnnotation(methodI=1,methodD=2.5)
	public static void testMyAnnotation(){
		
		AnnaotationImpl annaotationImpl = new AnnaotationImpl();
		
		// Obtain the annotation for this method
		// and display the values of the members.
		
		try {
			// First, get a Class object that represents
			// this class.
			
			Class c = annaotationImpl.getClass();
			
			// Now, get a Method object that represents
			// this method.
			
			Method m = c.getMethod("testMyAnnotation");
			
			// Next, get the annotation for this class.
			
			MyAnnotation anno = m.getAnnotation(MyAnnotation.class);
			
			// Finally, display the values.
			
			System.out.println(anno.methodI() + " " + anno.methodD());
			} catch (NoSuchMethodException exc) {
			System.out.println("Method Not Found.");
			}
	}
	
}