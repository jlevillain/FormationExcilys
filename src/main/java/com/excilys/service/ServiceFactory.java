package com.excilys.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum ServiceFactory {
	INSTANCE;
	Logger logger = LoggerFactory.getLogger(ComputerService.class);
	public ComputerService getComputerService() {
		return ComputerServiceImpl.INSTANCE;
	}
	
	public CompanyService getCompanyService() {
		return CompanyServiceImpl.INSTANCE;
	}
}
