package com.tutorial.spring.springboot.fileupload.logger;

import org.slf4j.Logger;

public class LoggerImpl {
	
	Logger logger;
	public LoggerImpl(Logger logger) {
		this.logger = logger;
	}
	
	public void info(String requestId, String msg ) {
		logger.info("RequestId="+requestId+" | msg = "+msg);
	}
	
	public void error(String requestId, String msg) {
		logger.error("RequestId = "+requestId+" | msg = "+msg);
	}
	
}
