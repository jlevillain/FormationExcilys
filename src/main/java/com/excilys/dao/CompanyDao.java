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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.excilys.om.Company;
import com.excilys.exception.SQLRuntimeException;

/**
 * class managing the database for company
 * @author jlevillain
 *
 */
@Repository("companyDao")
public class CompanyDao {
	Logger logger = LoggerFactory.getLogger(CompanyDao.class);
	
	@Autowired
	DaoFactory daoFactory;
	
	/**
	 * get one company
	 * @param id id of the company
	 * @return a company
	 * @throws SQLRuntimeException
	 */
	public Company getOne(long id) throws SQLRuntimeException {
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Company comp =null;
		Connection cn=daoFactory.getConnectionPool();
		try {
			stmt =cn.prepareStatement("SELECT id,name FROM company where id=?;");
			stmt.setLong(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				comp = new Company();
				comp.setId(rs.getLong(1));
				comp.setName(rs.getString(2));
				
			}
		}catch(SQLException e) {
			throw new SQLRuntimeException("getOneCompany "+e.getMessage(),e.getStackTrace());
		}finally {
			daoFactory.closeConnection(rs, stmt);
		}
		return comp;
	}

	/**
	 * get a list of company
	 * @return the list of company
	 * @throws SQLRuntimeException
	 */
	public List<Company> getAll() throws SQLRuntimeException {
		List<Company> liste = new ArrayList<Company>();
		ResultSet rs = null;
		Statement stmt = null;
		try {
			Connection cn=daoFactory.getConnectionPool();
			stmt = cn.createStatement();
			rs = stmt.executeQuery("SELECT id, name FROM company;");
			while (rs.next()) {
				Company comp = new Company();
				comp.setId(rs.getLong(1));
				comp.setName(rs.getString(2));
				liste.add(comp);
			}
		}catch (SQLException e) {
			throw new SQLRuntimeException("getAllCompany "+e.getMessage(),e.getStackTrace());
		}finally {
			daoFactory.closeConnection(rs, stmt);
		}
		return liste;
	}
	
	
}
