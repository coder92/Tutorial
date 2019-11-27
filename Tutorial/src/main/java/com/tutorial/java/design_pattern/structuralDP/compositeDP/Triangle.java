package com.tutorial.java.design_pattern.structuralDP.compositeDP;

public class Triangle implements Shape {

	@Override
	public void draw(String fillColor) {
		System.out.println("Drawing Triangle with color "+fillColor);
	}

}