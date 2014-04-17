package com.excilys.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import com.excilys.om.Computer;
import com.excilys.om.Log;
import  com.excilys.exception.SQLRuntimeException;
import com.jolbox.bonecp.BoneCPDataSource;
/**
 * class managing with the database for log
 * @author jlevillain
 *
 */
@Repository("logDao")
public class LogDao {
	Logger logger = LoggerFactory.getLogger(LogDao.class);
	
	@Autowired
	DaoFactory daoFactory;
	
	@Autowired
	@Qualifier("dataSource")
	BoneCPDataSource dataSource;
	
	/**
	 * insert a log in the database
	 * @param request request effectuated
	 * @return success of the method
	 * @throws SQLRuntimeException
	 */
	public boolean insertOne( Log request) throws SQLRuntimeException {
		int rs=0;
		PreparedStatement stmt = null;
		Connection cn=DataSourceUtils.getConnection(dataSource);
		try {
			stmt = cn.prepareStatement("INSERT INTO log_table (request) VALUES (?);");
			//stmt.setLong(1, comp.getId());
			stmt.setString(1, request.getRequest());
			
			rs= stmt.executeUpdate();
			logger.debug("insertOne request"+rs);
		}catch(SQLException e) {
			throw new SQLRuntimeException("getOne "+e.getMessage(),e.getStackTrace());
		}finally {
			daoFactory.closeConnection(null, stmt);
		}
		return (rs!=0);
	}
}
