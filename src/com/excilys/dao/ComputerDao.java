package com.excilys.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.excilys.om.Company;
import com.excilys.om.Computer;

public class ComputerDao {
	private static ComputerDao computerDao=null;
	private ComputerDao() {
		
	}
	
	public static ComputerDao getComputerDao() {
		if (computerDao==null) {
			computerDao=new ComputerDao();
		}
		return computerDao;
	}

	public List<Computer> getAll() {
		List<Computer> liste = new ArrayList<Computer>();
		ResultSet rs = null;
		Statement stmt = null;
		Connection cn=DaoFactory.getConnection();
		try {
			stmt = cn.createStatement();
			rs = stmt.executeQuery("SELECT id, name, introduced, discontinuted, company_id FROM computer;");
			while (rs.next()) {
				Computer comp=new Computer();
				comp.setId(rs.getLong(1));
				comp.setName(rs.getString(2));
				comp.setDiscontinuted(rs.getDate(3));
				comp.setIntroduced(rs.getDate(4));
				comp.setCompany_id(rs.getLong(5));
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
		System.out.println((new ComputerDao()).getAll());
		return liste;
	}
	
	public static void main(String args[]) {
		
	}
	

}
