package com.excilys.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.excilys.om.Company;

public class CompanyDao {
	private static CompanyDao companyDao=null;
	public CompanyDao() {
		
	}
	
	public static CompanyDao getCompanyDao() {
		if (companyDao==null) {
			companyDao=new CompanyDao();
		}
		return companyDao;
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
			try {
				if (rs != null)

					rs.close();

				if (stmt != null)

					stmt.close();

				if (cn != null)
					cn.close();
			} catch (SQLException e) {
			}
		}

		return liste;
	}
	
}
