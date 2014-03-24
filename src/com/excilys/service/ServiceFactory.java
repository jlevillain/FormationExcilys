package com.excilys.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceFactory {
	Logger logger = LoggerFactory.getLogger(ComputerService.class);
	private static ComputerService computerService=null;
	private static CompanyService companyService=null;
	public static ComputerService getComputerService() {
		if (computerService==null) {
			computerService=new ComputerServiceImpl();
		}
		return computerService;
	}
	
	public static CompanyService getCompanyService() {
		if (companyService==null) {
			companyService=new CompanyServiceImpl();
		}
		return companyService;
	}
}
