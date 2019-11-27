package com.tutorial.notclassified;

import java.io.File;

public class ShowFilesInADirectory {
	public static void main(String[] args) {
		File folder = new File("D:\\Ankit\\Technical\\java\\Spring-Hibernet Tutorial\\Tutorial_Pdfs\\01-spring-core-pdfs");
		File[] files = folder.listFiles();
		
		String path = "01-spring-core-pdfs";
		for(File file: files) {
			String name = file.getName();
			String url = "<a href=\""+path+"\\"+name+"\">"+name+"</a></br>";
			
			System.out.println(url);
		}
	}
}
