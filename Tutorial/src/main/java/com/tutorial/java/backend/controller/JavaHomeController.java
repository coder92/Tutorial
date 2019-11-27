package com.tutorial.java.backend.controller;

import com.tutorial.common.FileContentReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;

@RestController
@RequestMapping("/tutorial/java")
@CrossOrigin(origins = "http://localhost:4200")
public class JavaHomeController {

	@Autowired
	FileContentReader fileContentReader;

	@GetMapping("")
	@ResponseBody
	public String welComeMsg() {
		File file = new File("Notes/JavaNotes");
		return fileContentReader.readFileContent(file);
	}
	
	
}
