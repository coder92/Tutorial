package com.tutorial.spring.springboot.fileupload.service;

import java.util.List;
import com.tutorial.spring.springboot.fileupload.entity.KYC;

public interface KYCService {
	
	public List<KYC> getAllKYCDocs();
	
	public KYC getKYCDoc(long userId);
	
	public boolean saveKYCDoc(long userId, KYC kycDoc);
	
	public boolean deleteKYCDoc(long userId);
	
	public boolean updateKYCDoc(long userId, KYC kycDoc);
	
}
