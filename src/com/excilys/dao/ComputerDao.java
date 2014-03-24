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
import com.excilys.om.Computer;
import java.sql.Date;
public class ComputerDao {
	Logger logger = LoggerFactory.getLogger(ComputerDao.class);
	private static ComputerDao computerDao=null;
	private ComputerDao() {
		
	}
	
	public static ComputerDao getInstance() {
		if (computerDao==null) {
			computerDao=new ComputerDao();
		}
		return computerDao;
	}

	
	public Computer getOne(long id) {
		Computer comp=null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection cn=DaoFactory.getConnection();
		try {
			stmt = cn.prepareStatement("SELECT c.id, c.name, c.introduced, c.discontinued, c.company_id, company.name FROM computer as c LEFT JOIN company ON c.company_id=company.id where c.id=?");
			stmt.setLong(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				comp=new Computer();
				comp.setId(rs.getLong(1));
				comp.setName(rs.getString(2));
				comp.setDiscontinued(rs.getDate(3));
				comp.setIntroduced(rs.getDate(4));
				Company company=new Company();
				company.setId(rs.getLong(5));
				company.setName(rs.getString(6));
				comp.setCompany(company);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DaoFactory.closeConnection(cn, stmt, rs);
		}
		return comp;
	
	}
	
	public List<Computer> getAll() {
		List<Computer> liste = new ArrayList<Computer>();
		ResultSet rs = null;
		Statement stmt = null;
		Connection cn=DaoFactory.getConnection();
		try {
			stmt = cn.createStatement();
			rs = stmt.executeQuery("SELECT c.id, c.name, c.introduced, c.discontinued, c.company_id, company.name FROM computer as c LEFT JOIN company ON c.company_id=company.id;");
			while (rs.next()) {
				Computer comp=new Computer();
				comp.setId(rs.getLong(1));
				comp.setName(rs.getString(2));
				comp.setDiscontinued(rs.getDate(3));
				comp.setIntroduced(rs.getDate(4));
				Company company=new Company();
				company.setId(rs.getLong(5));
				company.setName(rs.getString(6));
				comp.setCompany(company);
				liste.add(comp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DaoFactory.closeConnection(cn, stmt, rs);
		}
		return liste;
	
	}
	public int getSize() {
		ResultSet rs = null;
		Statement stmt = null;
		Connection cn=DaoFactory.getConnection();
		int size=0;
		try {
			stmt = cn.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(*) FROM computer;");
			rs.next();
			size=rs.getInt(1);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DaoFactory.closeConnection(cn, stmt, rs);
		}
		return size;
	}
	
	public boolean updateOne(Computer comp) {
		int rs=0;
		PreparedStatement stmt = null;
		Connection cn=DaoFactory.getConnection();
		try {
			stmt = cn.prepareStatement("UPDATE computer SET name=?, introduced=?, discontinued=?, company_id=? where id=?");
			//stmt.setLong(1, comp.getId());
			stmt.setString(1, comp.getName());
			Date introduced=new Date(comp.getIntroduced().getTime());
			Date discontinued=new Date(comp.getDiscontinued().getTime());
			stmt.setDate(2, introduced);
			stmt.setDate(3, discontinued);
			stmt.setLong(4, comp.getCompany().getId());
			stmt.setLong(5, comp.getId());
			rs= stmt.executeUpdate();
			logger.debug("count"+rs);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DaoFactory.closeConnection(cn, stmt, null);
		}
		return (rs!=0);
	}
	
	public boolean insertOne(Computer comp) {
		int rs=0;
		PreparedStatement stmt = null;
		Connection cn=DaoFactory.getConnection();
		try {
			stmt = cn.prepareStatement("INSERT INTO computer (name,introduced,discontinued,company_id) VALUES (?,?,?,?);");
			//stmt.setLong(1, comp.getId());
			stmt.setString(1, comp.getName());
			Date introduced=new Date(comp.getIntroduced().getTime());
			Date discontinued=new Date(comp.getDiscontinued().getTime());
			stmt.setDate(2, introduced);
			stmt.setDate(3, discontinued);
			stmt.setLong(4, comp.getCompany().getId());
			rs= stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DaoFactory.closeConnection(cn, stmt, null);
		}
		return (rs!=0);
	}
	
	public boolean deleteOne(long id) {
		int rs=0;
		PreparedStatement stmt = null;
		Connection cn=DaoFactory.getConnection();
		try {
			stmt = cn.prepareStatement("DELETE FROM computer WHERE id=?;");
			stmt.setLong(1, id);
			//stmt.setLong(1, comp.getId());
			rs= stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DaoFactory.closeConnection(cn, stmt, null);
		}
		return (rs!=0);
	}
	
	public static void main(String args[]) {
		
	}
	

}
