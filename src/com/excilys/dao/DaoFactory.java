package com.excilys.dao;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DaoFactory {
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
			System.out.println(cn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return cn;
	}
}
