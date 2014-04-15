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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.jolbox.bonecp.BoneCPDataSource;
import com.google.common.base.*;
import com.excilys.exception.NamingRuntimeException;
import com.excilys.exception.SQLRuntimeException;
import com.excilys.om.Computer;

/**
 * class managing the connection with the database
 * @author jlevillain
 *
 */
@Component("ConnectionManagement")
public class DaoFactory {
	private Logger logger = LoggerFactory.getLogger(DaoFactory.class);
	private BoneCPDataSource bcpds=null;
	private ThreadLocal<Connection> threadLocalConnection=null;
	
	/**
	 * constructor of the dao factory
	 */
	public DaoFactory() {
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
	/**
	 * start a transaction
	 */
	public void startTransaction() {
		try {
			threadLocalConnection.get().setAutoCommit(false);;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.debug("StartTransaction error s"+e.getMessage());
			throw new SQLRuntimeException(e.getMessage(), e.getStackTrace());
		}
		
	}
	
	/**
	 * validate a transaction
	 */
	public void commit() {
		try {
			threadLocalConnection.get().commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.debug("Commit error s"+e.getMessage());
			throw new SQLRuntimeException(e.getMessage(), e.getStackTrace());
		}
	}
	
	/**
	 * cancel a transaction
	 */
	public void rollback() {
		try {
			threadLocalConnection.get().rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.debug("Rollback error s"+e.getMessage());
			throw new SQLRuntimeException(e.getMessage(), e.getStackTrace());
		}
		
	}
	
	/**
	 * get the pool connection of the database
	 * @return pool connection
	 */
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
	
	/**
	 * close the connection with the database
	 */
	public void closeConnection() {
		try {
		
			threadLocalConnection.get().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.debug("closeConnection error s"+e.getMessage());
		}
		threadLocalConnection.remove();
	}
	
	/**
	 * close the connection with the database
	 * @param rs resultset to close
	 * @param stmt statement to close
	 */
	public void closeConnection(ResultSet rs,Statement stmt) {
		try {
			if (rs!=null)
				rs.close();
			if (stmt!=null)
				stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.debug("closeConnection rs stmt error "+e.getMessage());
			throw new SQLRuntimeException("closeConnection rs stmt error "+e.getMessage(), e.getStackTrace());
		}
	}
	
}
