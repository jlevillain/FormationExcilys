package com.excilys.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.excilys.dao.DaoFactory;
import com.excilys.om.Company;


public enum CompanyServiceImpl implements CompanyService{
	INSTANCE;
	Logger logger = LoggerFactory.getLogger(ComputerService.class);
	public List<Company> getAll() {
		Connection cn=DaoFactory.INSTANCE.getConnectionPool();	
		List<Company> list=null;
		try {
			cn.setAutoCommit(false);
			list = DaoFactory.INSTANCE.getCompanyDao().getAll();
			DaoFactory.INSTANCE.getLogDao().insertOne("getAll CompanyService");
			cn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.debug(new StringBuilder("getAll SQLexception ").append(e.getMessage()).append(" ").append(e.getStackTrace()).toString());
			try {
				cn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			DaoFactory.INSTANCE.closeConnection();
		}
		
		return list;
	}
}
