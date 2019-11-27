package com.tutorial.java.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;


@What(description = "An annotation test class")
@MyAnno(str = "Meta2", val = 99)
class AnnotationDemo1 {
	
	public static void main(String args[]) {
		myMeth();
	}
	
	@What(description = "An annotation test method")
	@MyAnno(str = "Testing", val = 100)
	public static void myMeth() {
		
		AnnotationDemo1 ob = new AnnotationDemo1();
		
		try {
			Annotation annos[] = ob.getClass().getAnnotations();
			
			// Display all annotations for AnnotationDemo1.
			System.out.println("All annotations for AnnotationDemo1:");
			
			for(Annotation a : annos)
				System.out.println(a);
			
			System.out.println();
			
			// Display all annotations for myMeth.
			Method m = ob.getClass( ).getMethod("myMeth");
			annos = m.getAnnotations();
			System.out.println("All annotations for myMeth:");
			for(Annotation a : annos)
				System.out.println(a);
		} catch (NoSuchMethodException exc) {
			System.out.println("Method Not Found.");
		}
	}
}