package com.excilys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.excilys.om.Company;
import com.excilys.om.Computer;
import com.sun.jndi.cosnaming.CNCtx;
import com.sun.org.apache.bcel.internal.generic.Type;
import  com.excilys.exception.SQLRuntimeException;

import java.sql.Date;

@Repository("computerDao")
public class ComputerDao {
	Logger logger = LoggerFactory.getLogger(ComputerDao.class);
	
	@Autowired
	DaoFactory daoFactory;
	
	public Computer getOne(long id) throws SQLRuntimeException {
		Computer comp=null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection cn=daoFactory.getConnectionPool();
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
	
			rs.close();
			stmt.close();
		}catch(SQLException e) {
			throw new SQLRuntimeException("getOne "+e.getMessage(),e.getStackTrace());
		}finally {
			daoFactory.closeConnection(rs, stmt);
		}
		return comp;
	
	}
	
	public List<Computer> getAll() throws SQLRuntimeException {
		List<Computer> liste = new ArrayList<Computer>();
		ResultSet rs = null;
		Statement stmt = null;
		Connection cn=daoFactory.getConnectionPool();
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
		}catch(SQLException e) {
			throw new SQLRuntimeException("getAll() "+e.getMessage(),e.getStackTrace());
		}finally {
			daoFactory.closeConnection(rs, stmt);
		}
		return liste;
	
	}
	
	public int getSize(String search) throws SQLRuntimeException {
		ResultSet rs = null;
		PreparedStatement stmt = null;
		int size=0;
		
		Connection cn=daoFactory.getConnectionPool();
		try {			
			stmt = cn.prepareStatement("SELECT COUNT(*) FROM computer WHERE name LIKE ?");
			stmt.setString(1,new StringBuilder("%").append(search).append("%").toString());
			rs = stmt.executeQuery();
			rs.next();
			size=rs.getInt(1);
		} catch ( SQLException e) {
			// TODO: handle exception
			throw new SQLRuntimeException("getSize "+e.getMessage(),e.getStackTrace());
		}finally {
			daoFactory.closeConnection(rs, stmt);
		}
		return size;
	}
	
	public List<Computer> getAll(String search, int begin, int number, int order, boolean desc) throws SQLRuntimeException {
		List<Computer> liste = new ArrayList<Computer>();
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection cn=daoFactory.getConnectionPool();
		try {
			StringBuilder request=new StringBuilder("SELECT c.id, c.name, c.introduced, c.discontinued, c.company_id, company.name FROM computer as c ");
			request.append("LEFT JOIN company ON c.company_id=company.id where c.name LIKE ? order by ?");
		    if (desc) {
		    	request.append(" DESC");
		    }
		    request.append(" LIMIT ? OFFSET ?");
		    logger.debug(request.toString());
			stmt = cn.prepareStatement(request.toString());
			stmt.setString(1,new StringBuilder("%").append(search).append("%").toString());
			stmt.setInt(2, order);
			stmt.setInt(3, number);
			stmt.setInt(4, begin);
			
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
		}catch(SQLException e) {
			throw new SQLRuntimeException("getAll "+e.getMessage(),e.getStackTrace());
		}finally {
			daoFactory.closeConnection(rs, stmt);
		}
		return liste;
	}
	public boolean updateOne(Computer comp) throws SQLRuntimeException {
		int rs=0;
		PreparedStatement stmt = null;
		Connection cn=daoFactory.getConnectionPool();
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
		} catch (SQLException e) {
			throw new SQLRuntimeException("updateOne "+e.getMessage(),e.getStackTrace());
		}finally {
			daoFactory.closeConnection(null, stmt);
		}
		return (rs!=0);
	}
	
	public boolean insertOne(Computer comp) throws SQLRuntimeException {
		int rs=0;
		PreparedStatement stmt = null;
		Connection cn=daoFactory.getConnectionPool();
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
		}catch(SQLException e) {
			throw new SQLRuntimeException("insertOne "+e.getMessage(),e.getStackTrace());
		}finally {
			daoFactory.closeConnection(null, stmt);
		}
		return (rs!=0);
	}
	
	public boolean deleteOne(long id) throws SQLRuntimeException {
		int rs=0;
		PreparedStatement stmt = null;
		Connection cn=daoFactory.getConnectionPool();
		try {
			stmt = cn.prepareStatement("DELETE FROM computer WHERE id=?;");
			stmt.setLong(1, id);
			//stmt.setLong(1, comp.getId());
			rs= stmt.executeUpdate();
		}catch(SQLException e) {
			throw new SQLRuntimeException("deleteOne "+e.getMessage(),e.getStackTrace());
		}finally {
			daoFactory.closeConnection(null, stmt);
		}
		return (rs!=0);
	}
	
	

}
