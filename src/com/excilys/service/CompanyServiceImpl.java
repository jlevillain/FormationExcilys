package com.excilys.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.excilys.dao.DaoFactory;
import com.excilys.om.Company;

import exception.SQLRuntimeException;


public enum CompanyServiceImpl implements CompanyService{
	INSTANCE;
	Logger logger = LoggerFactory.getLogger(ComputerService.class);
	public List<Company> getAll() {
		Connection cn=DaoFactory.INSTANCE.getConnectionPool();	
		List<Company> list=null;
		try {
			list = DaoFactory.INSTANCE.getCompanyDao().getAll();
		} catch (SQLRuntimeException e) {
			// TODO Auto-generated catch block
			logger.debug(new StringBuilder("getAll SQLexception ").append(e.getMessage()).append(" ").append(e.getStackTrace()).toString());
			throw e;
		}finally {
			DaoFactory.INSTANCE.closeConnection();
		}
		
		return list;
	}
}
