package com.tutorial.java.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//marker annotation used to mark a declaration

@Retention(RetentionPolicy.SOURCE)
@interface MyMarker{}


public class MarkerAnnotationDemo{
	
}

/*
 * Java defines many built-in annotations. Most are specialized, but seven are 
 * general purpose.
Of these, four are imported from java.lang.annotation: @Retention, @Documented, @Target,
and @Inherited. Three�@Override, @Deprecated, and @SuppressWarnings�are included
in java.lang. 
 */