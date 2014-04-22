package com.excilys.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.excilys.exception.SQLRuntimeException;
import com.jolbox.bonecp.BoneCPDataSource;

/**
 * class managing the connection with the database
 * @author jlevillain
 *
 */
@Component("ConnectionManagement")
public class DaoFactory {
	private Logger logger = LoggerFactory.getLogger(DaoFactory.class);
	private ThreadLocal<Connection> threadLocalConnection=null;
	
	@Autowired
	@Qualifier("dataSource")
	private BoneCPDataSource dataSource;
	
	/**
	 * constructor of the dao factory
	 */
	public DaoFactory() {
		threadLocalConnection=new ThreadLocal<Connection>();
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
				threadLocalConnection.set(dataSource.getConnection());
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
