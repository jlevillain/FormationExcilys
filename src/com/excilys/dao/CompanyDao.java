package com.excilys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.excilys.om.Company;


public class CompanyDao {
	Logger logger = LoggerFactory.getLogger(CompanyDao.class);
	private static CompanyDao companyDao=null;
	public CompanyDao() {
		
	}
	
	public static CompanyDao getInstance() {
		if (companyDao==null) {
			companyDao=new CompanyDao();
		}
		return companyDao;
	}

	
	public Company getOne(long id) {
		Connection cn=DaoFactory.getConnection();
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Company comp =null;
		try {
			stmt =cn.prepareStatement("SELECT id,name FROM company where id=?;");
			stmt.setLong(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				comp = new Company();
				comp.setId(rs.getLong(1));
				comp.setName(rs.getString(2));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DaoFactory.closeConnection(cn, stmt, rs);
		}
		return comp;
	}

	
	public List<Company> getAll() {
		List<Company> liste = new ArrayList<Company>();
		ResultSet rs = null;
		Statement stmt = null;
		Connection cn=DaoFactory.getConnection();
		try {
			stmt = cn.createStatement();
			rs = stmt.executeQuery("SELECT id, name FROM company;");
			while (rs.next()) {
				Company comp = new Company();
				comp.setId(rs.getLong(1));
				comp.setName(rs.getString(2));
				liste.add(comp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DaoFactory.closeConnection(cn, stmt, rs);
		}

		return liste;
	}
	
}
