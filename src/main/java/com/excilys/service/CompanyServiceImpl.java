package com.excilys.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.excilys.dao.CompanyDao;
import com.excilys.dao.DaoFactory;
import com.excilys.om.Company;
import  com.excilys.exception.SQLRuntimeException;

@Service
public class CompanyServiceImpl implements CompanyService{
	
	Logger logger = LoggerFactory.getLogger(ComputerService.class);
	@Autowired
	DaoFactory daoFactory;
	@Autowired
	CompanyDao companyDao;
	public List<Company> getAll() {
		Connection cn=daoFactory.getConnectionPool();	
		List<Company> list=null;
		try {
			list = companyDao.getAll();
		} catch (SQLRuntimeException e) {
			// TODO Auto-generated catch block
			logger.debug(new StringBuilder("getAll SQLexception ").append(e.getMessage()).append(" ").append(e.getStackTrace()).toString());
			throw e;
		}finally {
			daoFactory.closeConnection();
		}
		
		return list;
	}
}
