package com.tutorial.java.design_pattern.structuralDP.compositeDP;

public class Circle implements Shape {

	@Override
	public void draw(String fillColor) {
		System.out.println("Drawing Circle with color "+fillColor);
	}

}