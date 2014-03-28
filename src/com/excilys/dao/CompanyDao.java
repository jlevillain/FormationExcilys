package com.excilys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.excilys.dto.CompanyDto;
import com.excilys.om.Company;


public enum CompanyDao {
	INSTANCE;
	Logger logger = LoggerFactory.getLogger(CompanyDao.class);
	
	public Company getOne(long id) throws SQLException {
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Company comp =null;
		Connection cn=DaoFactory.INSTANCE.getConnectionPool();
		stmt =cn.prepareStatement("SELECT id,name FROM company where id=?;");
		stmt.setLong(1, id);
		rs = stmt.executeQuery();
		while (rs.next()) {
			comp = new Company();
			comp.setId(rs.getLong(1));
			comp.setName(rs.getString(2));
			
		}
		rs.close();
		stmt.close();
		return comp;
	}

	
	public List<Company> getAll() throws SQLException {
		List<Company> liste = new ArrayList<Company>();
		ResultSet rs = null;
		Statement stmt = null;
		Connection cn=DaoFactory.INSTANCE.getConnectionPool();
		stmt = cn.createStatement();
		rs = stmt.executeQuery("SELECT id, name FROM company;");
		while (rs.next()) {
			Company comp = new Company();
			comp.setId(rs.getLong(1));
			comp.setName(rs.getString(2));
			liste.add(comp);
		}
		rs.close();
		stmt.close();
		return liste;
	}
	
	
}
