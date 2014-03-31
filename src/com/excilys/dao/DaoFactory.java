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
import com.google.common.base.*;

import exception.NamingRuntimeException;
import exception.SQLRuntimeException;

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
			throw new NamingRuntimeException(e.getMessage(), e.getStackTrace());
			
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
			throw new NamingRuntimeException(e.getMessage(), e.getStackTrace());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.debug(""+e.getMessage());
			throw new SQLRuntimeException(e.getMessage(), e.getStackTrace());
		}
		

	
		
		return cn;
	}
	
	public void startTransaction() {
		try {
			threadLocalConnection.get().setAutoCommit(false);;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.debug("StartTransaction error s"+e.getMessage());
			throw new SQLRuntimeException(e.getMessage(), e.getStackTrace());
		}
		
	}
	
	public void commit() {
		try {
			threadLocalConnection.get().commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.debug("Commit error s"+e.getMessage());
			throw new SQLRuntimeException(e.getMessage(), e.getStackTrace());
		}
	}
	
	public void rollback() {
		try {
			threadLocalConnection.get().rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.debug("Rollback error s"+e.getMessage());
			throw new SQLRuntimeException(e.getMessage(), e.getStackTrace());
		}
		
	}
	
	public Connection getConnectionPool() {
		
		if (threadLocalConnection.get()==null) {
			try {
				threadLocalConnection.set(bcpds.getConnection());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.debug("getConnection error s"+e.getMessage());
				throw new SQLRuntimeException(e.getMessage(), e.getStackTrace());
			}
		}
		
		return threadLocalConnection.get();
	}
	
	
	public void closeConnection() {
		try {
		
			threadLocalConnection.get().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.debug("closeConnection error s"+e.getMessage());
		}
		threadLocalConnection.remove();
	}
	
	public void closeConnection(ResultSet rs,Statement stmt) {
		try {
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.debug("closeConnection rs stmt error "+e.getMessage());
			throw new SQLRuntimeException("closeConnection rs stmt error "+e.getMessage(), e.getStackTrace());
		}
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
