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
import org.springframework.jdbc.core.JdbcTemplate;
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
		JdbcTemplate insert=new JdbcTemplate(dataSource);
		rs=insert.update("INSERT INTO log_table (request) VALUES (?)", new Object[] {request.getRequest()});
		return (rs!=0);
	}
}
