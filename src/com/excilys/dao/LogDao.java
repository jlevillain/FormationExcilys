package com.excilys.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.excilys.om.Computer;

public enum LogDao {
	INSTANCE;
	Logger logger = LoggerFactory.getLogger(LogDao.class);
	public boolean insertOne( String request) throws SQLException {
		int rs=0;
		PreparedStatement stmt = null;
		Connection cn=DaoFactory.INSTANCE.getConnectionPool();
		stmt = cn.prepareStatement("INSERT INTO log_table (request) VALUES (?);");
		//stmt.setLong(1, comp.getId());
		stmt.setString(1, request);
		
		rs= stmt.executeUpdate();
		logger.debug("insertOne request"+rs);
		stmt.close();
		return (rs!=0);
	}
}
