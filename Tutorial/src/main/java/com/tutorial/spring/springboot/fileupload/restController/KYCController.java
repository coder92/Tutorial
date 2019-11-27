package com.tutorial.spring.springboot.fileupload.restController;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tutorial.spring.springboot.fileupload.entity.KYC;
import com.tutorial.spring.springboot.fileupload.logger.LoggerImpl;
import com.tutorial.spring.springboot.fileupload.service.KYCService;

@RestController
@RequestMapping("/v1/kyc")
public class KYCController {

	
	LoggerImpl logger = new LoggerImpl(LoggerFactory.getLogger(KYCController.class));
	
	
	private KYCService kycService;
	
	@Autowired
	public KYCController(KYCService kycService) {
		this.kycService = kycService;
	}
	
	@GetMapping("/")
	public List<KYC> getKYCDocs(@RequestHeader("Request-Id") String requestId) {
		logger.info(requestId, "Get Request has been received for getKYCDocs");
		return kycService.getAllKYCDocs();
	}
	
	@GetMapping("/{userId}")
	public KYC findKYC(@PathVariable long userId, @RequestHeader("Request-Id") String requestId) {
		logger.info(requestId,"Get Request has been received for findKYC with userId ="+userId);
		return kycService.getKYCDoc(userId);
	}
	
	@PostMapping("/")
	public HttpStatus addKYC(@RequestBody KYC kyc, @RequestHeader("Request-Id") String requestId) {
		logger.info(requestId, "Post Request has been received for addKYC");
		logger.info(requestId, "KYC = "+kyc);
		if(kycService.saveKYCDoc(kyc.getUserId(), kyc)) {
			logger.info(requestId, "KYC Doc has been successfully saved!");
			return HttpStatus.OK;
		}else {
			logger.error(requestId, "KYC Doc has not been successfully saved!");
			return HttpStatus.BAD_REQUEST;
		}
	}
	
	@PutMapping("/")
	public HttpStatus updateKYC(@RequestBody KYC kyc, @RequestHeader("Request-Id") String requestId) {
		logger.info(requestId, "Put Request has been received for updateKYC");
		logger.info(requestId, "KYC = "+kyc);
		if(kycService.updateKYCDoc(kyc.getUserId(), kyc)) {
			logger.info(requestId, "KYC Doc has been updated successfully !");
			return HttpStatus.OK;
		}else {
			logger.error(requestId, "KYC Doc has not been updated successfully !");
			return HttpStatus.BAD_REQUEST;
		}
	}
	
	@DeleteMapping("/{userId}")
	public HttpStatus deleteKYC(@PathVariable("userId") Long userId, @RequestHeader("Request-Id") String requestId) {
		logger.info(requestId, "Delete Request has been received for deleteKYC");
		
		if(kycService.deleteKYCDoc(userId)) {
			logger.info(requestId, "KYC Doc has been deleted successfully !");
			return HttpStatus.OK;
		}else {
			logger.error(requestId, "KYC Doc has not been deleted successfully !");
			return HttpStatus.BAD_REQUEST;
		}
	}
}
