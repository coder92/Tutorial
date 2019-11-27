package com.tutorial.spring.springboot.fileupload.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

    public boolean saveFile(MultipartFile file, String fileName);
    
    public Resource getFile(String fileName);
}
