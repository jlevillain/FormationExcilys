package com.excilys.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jolbox.bonecp.BoneCPDataSource;
import com.google.common.base.*;;

public enum DaoFactory {
	INSTANCE;
	private Logger logger = LoggerFactory.getLogger(DaoFactory.class);
	private BoneCPDataSource bcpds=null;
	private ThreadLocal<Connection> threadLocalConnection=null;
	{
		try{
			Context initContext = new InitialContext();
				
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/ComputerPool");
			bcpds=new BoneCPDataSource();
			bcpds.setDatasourceBean(ds);
			threadLocalConnection=new ThreadLocal<Connection>();
		} catch (NamingException e) {
			logger.debug(""+e.getMessage());
		}
	}
	
	public Connection getConnection() {
		
		Connection cn = null;
		
		/*
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/commerce","root","root");
		*/
		Context initContext;
		try {
			initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/Computer");
			cn = ds.getConnection();
			logger.debug(cn.toString());
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			logger.debug(""+e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.debug(""+e.getMessage());
		}
		

	
		
		return cn;
	}
	
	public Connection getConnectionPool() {
		
		if (threadLocalConnection.get()==null) {
			try {
				threadLocalConnection.set(bcpds.getConnection());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.debug("");
			}
		}
		
		return threadLocalConnection.get();
	}
	
	
	public void closeConnection() {
		if (threadLocalConnection.get() != null) {
			try {
			
				threadLocalConnection.get().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		threadLocalConnection.remove();
	}
	
	
	public ComputerDao getComputerDao() {
		return ComputerDao.INSTANCE;
	}
	
	public CompanyDao getCompanyDao() {
		return CompanyDao.INSTANCE;
	}
	
	public LogDao getLogDao() {
		return LogDao.INSTANCE;
	}
	
}
