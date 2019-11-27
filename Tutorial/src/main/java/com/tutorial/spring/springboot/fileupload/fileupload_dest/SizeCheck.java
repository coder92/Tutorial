package com.tutorial.spring.springboot.fileupload.fileupload_dest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import com.tutorial.spring.springboot.fileupload.service.FileUploadProps;

public class SizeCheck {
	public static void main(String[] args) throws IOException {
		String fileName="mongodb.tgz";
		File destFile = new File(FileUploadProps.uploadLocation+"\\"+fileName);
		byte[] bytes = Files.readAllBytes(destFile.toPath());
		System.out.println(bytes.length);
	}
}
