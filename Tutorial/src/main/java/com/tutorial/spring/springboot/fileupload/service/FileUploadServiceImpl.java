package com.tutorial.spring.springboot.fileupload.service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadServiceImpl implements FileUploadService{
	
	Logger logger = LoggerFactory.getLogger(FileUploadServiceImpl.class);
	
	@Override
	public boolean saveFile(MultipartFile file, String fileName) {
        try {
        	logger.info("saveFile method called. file ="+fileName);
            if (file.isEmpty()) {
            	logger.error("File is empty");
            	return false;
            }
            try (InputStream inputStream = file.getInputStream()) {
            	
            	File destFile = new File(FileUploadProps.uploadLocation+"\\"+fileName);
            	logger.info("destFile = "+destFile.getAbsolutePath());
            	
            	OutputStream outputStream = new FileOutputStream(destFile, true);
            	
            	byte[] buffer = new byte[1024];
            	
            	int length;
            	
            	byte[] destFileBytes = Files.readAllBytes(destFile.toPath());
            	
            	if(isFileExists(fileName)) {
            		logger.info("Resuming downling the file from offset(bytes) = "+destFileBytes.length);
            	}else {
            		logger.info("Downloading the file from Starting");
            	}
            	
            	BufferedInputStream bis = new BufferedInputStream(inputStream);
            	
            	bis.skip(destFileBytes.length);
            	
            	while((length = bis.read(buffer))>0) {
            		outputStream.write(buffer, 0, length);
            		outputStream.flush();
            	}
            	
                return true;
            }
        }
        catch (IOException e) {
        	logger.error("exception occured ="+e);
        }
        return false;
	}

	
	 private boolean isFileExists(String fileName) {
		 File folder = new File(FileUploadProps.uploadLocation);
		 File[] listOfFiles = folder.listFiles();

		 for (int i = 0; i < listOfFiles.length; i++) {
		   if (listOfFiles[i].isFile()) {
		     if(listOfFiles[i].getName().equals(fileName))
		    	 return true;
		   } 
		 }
		return false;
	}


	@Override
	    public Resource getFile(String filename) {
	        try {
	        	logger.info("Get request received for filename = "+filename);
	            File file = new File(FileUploadProps.uploadLocation+"\\"+filename);
	            
	            Resource resource = new UrlResource(file.toPath().toUri());
	            if (resource.exists() || resource.isReadable()) {
	                return resource;
	            }
	            else {
	                logger.error("Could not read file: "+filename);
	            }
	        }
	        catch (MalformedURLException e) {
	            logger.error("exception = "+e);
	        }
	        return null;
	    }
}
