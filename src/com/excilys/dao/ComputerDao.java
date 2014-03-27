package com.excilys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.excilys.om.Company;
import com.excilys.om.Computer;
import com.sun.org.apache.bcel.internal.generic.Type;

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
				comp.setIntroduced(rs.getDate(3));
				comp.setDiscontinued(rs.getDate(4));
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
			rs = stmt.executeQuery("SELECT c.id, c.name, c.introduced, c.discontinued, c.company_id, company.name FROM computer as c LEFT JOIN company ON c.company_id=company.id order by c.name;");
			while (rs.next()) {
				Computer comp=new Computer();
				comp.setId(rs.getLong(1));
				comp.setName(rs.getString(2));
				comp.setIntroduced(rs.getDate(3));
				comp.setDiscontinued(rs.getDate(4));
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
	
	public List<Computer> getAll(int begin, int number) {
		List<Computer> liste = new ArrayList<Computer>();
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection cn=DaoFactory.getConnection();
		try {
			stmt = cn.prepareStatement("SELECT c.id, c.name, c.introduced, c.discontinued, c.company_id, company.name FROM computer as c LEFT JOIN company ON c.company_id=company.id order by c.name LIMIT ? OFFSET ?;");
			stmt.setInt(1, number);
			stmt.setInt(2, begin);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Computer comp=new Computer();
				comp.setId(rs.getLong(1));
				comp.setName(rs.getString(2));
				comp.setIntroduced(rs.getDate(3));
				comp.setDiscontinued(rs.getDate(4));
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
	
	public List<Computer> getSearch(String search) {
		List<Computer> liste = new ArrayList<Computer>();
		ResultSet rs = null;
		Statement stmt = null;
		Connection cn=DaoFactory.getConnection();
		try {
			stmt = cn.createStatement();
			rs = stmt.executeQuery("SELECT c.id, c.name, c.introduced, c.discontinued, c.company_id, company.name FROM computer as c LEFT JOIN company ON c.company_id=company.id where c.name LIKE '%"+search+"%';");
			
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
	public int getSize(String search) {
		ResultSet rs = null;
		Statement stmt = null;
		Connection cn=DaoFactory.getConnection();
		int size=0;
		try {
			stmt = cn.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(*) FROM computer WHERE name LIKE '%"+search+"%';");
			rs.next();
			size=rs.getInt(1);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DaoFactory.closeConnection(cn, stmt, rs);
		}
		return size;
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
	
	public List<Computer> getAll(String search, int begin, int number) {
		List<Computer> liste = new ArrayList<Computer>();
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection cn=DaoFactory.getConnection();
		try {
			stmt = cn.prepareStatement("SELECT c.id, c.name, c.introduced, c.discontinued, c.company_id, company.name FROM computer as c LEFT JOIN company ON c.company_id=company.id where c.name LIKE '%"+search+"%' order by 2 LIMIT ? OFFSET ?;");
			stmt.setInt(1, number);
			stmt.setInt(2, begin);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Computer comp=new Computer();
				comp.setId(rs.getLong(1));
				comp.setName(rs.getString(2));
				comp.setIntroduced(rs.getDate(3));
				comp.setDiscontinued(rs.getDate(4));
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
	
	public List<Computer> getAll(String search, int begin, int number, int order) {
		List<Computer> liste = new ArrayList<Computer>();
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection cn=DaoFactory.getConnection();
		try {
			stmt = cn.prepareStatement("SELECT c.id, c.name, c.introduced, c.discontinued, c.company_id, company.name FROM computer as c LEFT JOIN company ON c.company_id=company.id where c.name LIKE '%"+search+"%' order by ? LIMIT ? OFFSET ?;");
			stmt.setInt(1, order);
			stmt.setInt(2, number);
			stmt.setInt(3, begin);
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Computer comp=new Computer();
				comp.setId(rs.getLong(1));
				comp.setName(rs.getString(2));
				comp.setIntroduced(rs.getDate(3));
				comp.setDiscontinued(rs.getDate(4));
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
	public List<Computer> getAll(String search, int begin, int number, int order, boolean asc) {
		List<Computer> liste = new ArrayList<Computer>();
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection cn=DaoFactory.getConnection();
		try {
			StringBuilder request=new StringBuilder("SELECT c.id, c.name, c.introduced, c.discontinued, c.company_id, company.name FROM computer as c LEFT JOIN company ON c.company_id=company.id where c.name LIKE '%");
			request.append(search);
		    request.append("%' order by ?");
		    if (asc==false) {
		    	request.append(" DESC");
		    }
		    request.append(" LIMIT ? OFFSET ?;");
		    logger.debug(request.toString());
			stmt = cn.prepareStatement(request.toString());
			stmt.setInt(1, order);
			stmt.setInt(2, number);
			stmt.setInt(3, begin);
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Computer comp=new Computer();
				comp.setId(rs.getLong(1));
				comp.setName(rs.getString(2));
				comp.setIntroduced(rs.getDate(3));
				comp.setDiscontinued(rs.getDate(4));
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
	public boolean updateOne(Computer comp) {
		int rs=0;
		PreparedStatement stmt = null;
		Connection cn=DaoFactory.getConnection();
		try {
			stmt = cn.prepareStatement("UPDATE computer SET name=?, introduced=?, discontinued=?, company_id=? where id=?");
			//stmt.setLong(1, comp.getId());
			stmt.setString(1, comp.getName());
			Date introduced=null;
			Date discontinued=null;

			if(comp.getIntroduced()==null) {
				stmt.setObject(2, Types.NULL);
			}else {
				introduced=new Date(comp.getIntroduced().getTime());
				stmt.setObject(2, introduced);
			}
			if (comp.getDiscontinued()==null) {
				stmt.setObject(3, Types.NULL);
			}else {
				discontinued=new Date(comp.getDiscontinued().getTime());
				stmt.setDate(3, discontinued);
				
			}
			if (comp.getCompany()!=null) {
				stmt.setLong(4, comp.getCompany().getId());
			}else {
				stmt.setNull(4, java.sql.Types.NULL);
			}
			stmt.setLong(5, comp.getId());
			rs= stmt.executeUpdate();
			logger.debug("updateone nbLigne modify"+rs);
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
			Date introduced=null;
			Date discontinued=null;
			
			if(comp.getIntroduced()==null) {
				stmt.setObject(2, Types.NULL);
			}else {
				introduced=new Date(comp.getIntroduced().getTime());
				stmt.setObject(2, introduced);
			}
			if (comp.getDiscontinued()==null) {
				stmt.setObject(3, Types.NULL);
			}else {
				discontinued=new Date(comp.getDiscontinued().getTime());
				stmt.setDate(3, discontinued);
				
			}		
		
			if (comp.getCompany()!=null) {
				stmt.setLong(4, comp.getCompany().getId());
			}else {
				stmt.setNull(4, java.sql.Types.NULL);
			}
			rs= stmt.executeUpdate();
			logger.debug("insertOne nbLigne modify"+rs);
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
