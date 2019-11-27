package com.tutorial.spring.springboot.fileupload.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.tutorial.spring.springboot.fileupload.entity.KYC;
import com.tutorial.spring.springboot.fileupload.logger.LoggerImpl;
import com.tutorial.spring.springboot.fileupload.restController.UserController;

@Service
public class KYCServiceImpl implements KYCService{

	Map<Long, KYC> kycDB = new HashMap<Long, KYC>();
	LoggerImpl logger = new LoggerImpl(LoggerFactory.getLogger(KYCServiceImpl.class));
	
	//instance block for one defalut KYC record
	{
		KYC kyc = new KYC();
		kyc.setAadharNo("123456789012");
		kyc.setUserId(1);
		kyc.setVoterCardNo("12321221");
	}
	
	@Override
	public List<KYC> getAllKYCDocs() {
		List<KYC> allKYCs = new ArrayList<KYC>();
		for(long id: kycDB.keySet()) {
			allKYCs.add(kycDB.get(id));
		}
		return allKYCs;
	}

	@Override
	public KYC getKYCDoc(long userId) {
		if(kycDB.get(userId)!=null)
			return kycDB.get(userId);
		return null;
	}

	@Override
	public boolean saveKYCDoc(long userId, KYC kycDoc) {
		try {
			logger.info("", "Request received for saving the KYC Doc ="+kycDoc+" with UserId = "+userId);
			kycDB.put(userId, kycDoc);
			logger.info("", "Document Saved!");
			return true;
		}catch(Exception e) {
			logger.error("", "Exception occured while saving KYC doc = "+kycDoc+" With UserId = "+userId+" e ="+e);
		}
		return false;
	}

	@Override
	public boolean deleteKYCDoc(long userId) {
		try {
			logger.info("", "Request received for deleting the KYC Doc with UserId = "+userId);
			if(kycDB.remove(userId)!=null) {
				logger.info("", "KYCDoc with UserId ="+userId+" has been deleted successfully.");
				return true;
			}else {
				logger.info("", "KYCDoc with UserId ="+userId+" has not been deleted successfully.");
				return false;
			}
		}catch(Exception e) {
			logger.error("", "Exception occured while deleting KYC doc With UserId = "+userId+" e ="+e);
		}
		return false;
	}

	@Override
	public boolean updateKYCDoc(long userId, KYC kycDoc) {
		try {
			if(kycDB.get(userId)!=null) {
				kycDB.put(userId, kycDoc);
				return true;
			}else {
				logger.error("", "KYC Doc has not been updated successfully.");
				return false;
			}
		} catch (Exception e) {
			logger.error("", "Exception occured while updating KYC doc With UserId = "+userId+" e ="+e);
		}
		return false;
	}
}
