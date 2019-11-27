package com.tutorial.spring.springboot.fileupload.restController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.tutorial.spring.springboot.fileupload.service.FileUploadService;

@RestController
@RequestMapping("/v1/fileupload")
public class FileUploadController {

	Logger logger = LoggerFactory.getLogger(FileUploadController.class);
    private final FileUploadService fileUploadService;

    @Autowired
    public FileUploadController(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }
    
    @PostMapping("/")
    public String saveFile(@RequestParam("file") MultipartFile file, @RequestParam("filename") String fileName) {

    	logger.info("Post request received for saveFile. filename = "+fileName);
        if(fileUploadService.saveFile(file, fileName)) {
        	logger.info("file uploaded successfully!");
        	return "File = "+fileName+" has been uploaded successfully.";
        }
       
        logger.info("file not able to upload!");
        
        return "File = "+fileName+" has not been uploaded successfully.";
    }
    
    @GetMapping("/{filename}")
    public Resource getFile(@PathVariable("filename") String fileName) {
    	logger.info("Get Request receive for getFile. Filename = "+fileName);
    	return fileUploadService.getFile(fileName);
    }

}
