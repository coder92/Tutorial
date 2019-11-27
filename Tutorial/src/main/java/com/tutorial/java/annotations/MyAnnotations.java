package com.tutorial.java.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public @interface MyAnnotations {

}

//public @interface MyAnnotation extends MapMode  
//TODO: invalid can not use extend. by default it has annotation super class

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{
	
	
	//public void methodI(); //TODO: invalid can not take void
	
	public int methodI();
	
	//public int methodI(int a); //TODO: invalid can take params
	
	public double methodD();
	
	/*String methodS() {     //TODO: invalid can have body
		
	};*/

}


@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
	String str() default "My Anno Str";
	int val() default 1000;
}

@Retention(RetentionPolicy.RUNTIME)
@interface What {
	String description();
}