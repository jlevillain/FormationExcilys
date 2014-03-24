package com.excilys.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DaoFactory {
	static Logger logger = LoggerFactory.getLogger(DaoFactory.class);
	public static Connection getConnection() {
		
		Connection cn = null;
		
		try {
			/*
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/commerce","root","root");
			*/
			Context initContext = new InitialContext();
			
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/Computer");
			cn = ds.getConnection();
			logger.debug(cn.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return cn;
	}
	
	public static void closeConnection(Connection cn, Statement stmt, ResultSet rs) {
		try {
			if (cn != null)
				cn.close();
			
			if (stmt != null)
				stmt.close();
			if (rs != null)
				rs.close();
			
		} catch (SQLException e) {
			
		}
	}
	
	
	public static ComputerDao getComputerDao() {
		return ComputerDao.getInstance();
	}
	
	public static CompanyDao getCompanyDao() {
		return CompanyDao.getInstance();
	}
	
}
