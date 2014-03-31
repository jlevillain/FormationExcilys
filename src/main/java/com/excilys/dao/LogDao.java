package com.excilys.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.excilys.om.Computer;

import  com.excilys.exception.SQLRuntimeException;

public enum LogDao {
	INSTANCE;
	Logger logger = LoggerFactory.getLogger(LogDao.class);
	public boolean insertOne( String request) throws SQLRuntimeException {
		int rs=0;
		PreparedStatement stmt = null;
		Connection cn=DaoFactory.INSTANCE.getConnectionPool();
		try {
			stmt = cn.prepareStatement("INSERT INTO log_table (request) VALUES (?);");
			//stmt.setLong(1, comp.getId());
			stmt.setString(1, request);
			
			rs= stmt.executeUpdate();
			logger.debug("insertOne request"+rs);
		}catch(SQLException e) {
			throw new SQLRuntimeException("getOne "+e.getMessage(),e.getStackTrace());
		}finally {
			DaoFactory.INSTANCE.closeConnection(null, stmt);
		}
		return (rs!=0);
	}
}
