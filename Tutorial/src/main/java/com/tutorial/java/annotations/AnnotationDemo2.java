package com.tutorial.java.annotations;

import java.lang.reflect.Method;
// An annotation type declaration that includes defaults.

class AnnotationDemo2 {
	
	public static void main(String args[]) {
		myMeth();
	}
	
	// Annotate a method using the default values.
	@MyAnno()
	public static void myMeth() {
		AnnotationDemo2 ob = new AnnotationDemo2();
		// Obtain the annotation for this method
		// and display the values of the members.
		try {
			Class c = ob.getClass();
			Method m = c.getMethod("myMeth");

			MyAnno anno = m.getAnnotation(MyAnno.class);
			System.out.println(anno.str() + " " + anno.val());
		} catch (NoSuchMethodException exc) {
			System.out.println("Method Not Found.");
		}
	}
}