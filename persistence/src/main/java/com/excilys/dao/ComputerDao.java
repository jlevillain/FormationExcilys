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

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import com.excilys.om.Company;
import com.excilys.om.Computer;
import com.jolbox.bonecp.BoneCPDataSource;

import java.sql.Date;

import javax.sql.DataSource;

/**
 * class managing the database for computer
 * @author jlevillain
 *
 */
@Repository("computerDao")
public class ComputerDao {
	Logger logger = LoggerFactory.getLogger(ComputerDao.class);
	
	@Autowired
	DaoFactory daoFactory;
	
	@Autowired
	@Qualifier("dataSource")
	BoneCPDataSource dataSource;
	
	/**
	 * get one computer from the database
	 * @param id id of computer
	 * @return computer 
	 * @throws DataAccessException
	 */
	public Computer getOne(long id) throws DataAccessException {
		Computer comp=null;
		JdbcTemplate select = new JdbcTemplate(dataSource);
		comp=select.queryForObject("SELECT c.id, c.name, c.introduced, c.discontinued, company.id, company.name FROM computer as c LEFT JOIN company ON c.company_id=company.id where c.id=?",
				new Object[] {id}, new ComputerRowMapper());
		return comp;
	}
	
	/**
	 * get all computer from the database
	 * @return list of computer
	 * @throws DataAccessException
	 */
	public List<Computer> getAll() throws DataAccessException {
		List<Computer> liste = null;
		JdbcTemplate select = new JdbcTemplate(dataSource);
		liste=select.query("SELECT c.id, c.name, c.introduced, c.discontinued, company.id, company.name FROM computer as c LEFT JOIN company ON c.company_id=company.id order by c.name"
				, new ComputerRowMapper());
		return liste;
	}
	/**
	 * get the size of list of computer
	 * @param search search parameter 
	 * @return size of list of computer
	 * @throws DataAccessException
	 */
	public int getSize(String search) throws DataAccessException {
		int size=0;
		JdbcTemplate select = new JdbcTemplate(dataSource);
		size=select.queryForObject("SELECT COUNT(*) FROM computer WHERE name LIKE ?",new Object[]{new StringBuilder("%").append(search).append("%")},Integer.class);
		logger.debug("getSize : "+size);
		return size;
	}
	
	/**
	 * get the list of computer with the good parameter
	 * @param search search parameter
	 * @param begin 
	 * @param number number of page
	 * @param order sort by order
	 * @param desc descendant sort
	 * @return list of computer
	 * @throws DataAccessException
	 */
	public List<Computer> getAll(String search, int begin, int number, int order, boolean desc) throws DataAccessException {
		List<Computer> liste = null;
		JdbcTemplate select = new JdbcTemplate(dataSource);
		StringBuilder request=new StringBuilder("SELECT c.id, c.name, c.introduced, c.discontinued, company.id, company.name FROM computer as c ");
		request.append("LEFT JOIN company ON c.company_id=company.id where c.name LIKE ? order by ?");
	    if (desc) {
	    	request.append(" DESC");
	    }
	    request.append(" LIMIT ? OFFSET ?");
	    logger.debug(request.toString());
		liste=select.query(request.toString(), 
				new Object[] {new StringBuilder("%").append(search).append("%").toString(),order,number,begin}, 
				new ComputerRowMapper());
		
		return liste;
	}
	
	/**
	 * update a computer
	 * @param comp a computer to update
	 * @return the success of the method
	 * @throws DataAccessException
	 */
	public boolean updateOne(Computer comp) throws DataAccessException {
		int rs=0;
		Date introduced=null;
		Date discontinued=null;
		Long company=null;
		if(comp.getIntroduced()!=null) {
			introduced=new Date(comp.getIntroduced().getMillis());
		}
		if (comp.getDiscontinued()!=null) {
			discontinued=new Date(comp.getDiscontinued().getMillis());
		}		
		if (comp.getCompany()!=null) {
			company=comp.getCompany().getId();
		}
		JdbcTemplate insert=new JdbcTemplate(dataSource);
		Object[] parameter=new Object[]{comp.getName(),introduced,discontinued,company,comp.getId()};
		logger.debug("parameter : "+introduced+" "+discontinued);
		rs=insert.update("UPDATE computer SET name=?, introduced=?, discontinued=?, company_id=? where id=?", parameter);
		return (rs!=0);
	}
	
	/**
	 * insert a computer
	 * @param comp computer
	 * @return the success of the method
	 * @throws DataAccessException
	 */
	public boolean insertOne(Computer comp) throws DataAccessException {
		int rs=0;
		Object introduced=null;
		Object discontinued=null;
		Long company=null;
		if(comp.getIntroduced()!=null) {
			introduced=new Date(comp.getIntroduced().getMillis());
		}else{
			introduced=Types.NULL;
		}
		if (comp.getDiscontinued()!=null) {
			discontinued=new Date(comp.getDiscontinued().getMillis());
		}else {
			discontinued=Types.NULL;
		}	
		if (comp.getCompany()!=null) {
			company=comp.getCompany().getId();
		}
		JdbcTemplate insert=new JdbcTemplate(dataSource);
		Object[] parameter=new Object[]{comp.getName(),introduced,discontinued,company};
		logger.debug("parameter : "+introduced+" "+discontinued);
		rs=insert.update("INSERT INTO computer (name,introduced,discontinued,company_id) VALUES (?,?,?,?)", parameter);
		return (rs!=0);
	}
	
	/**
	 * delete one computer 
	 * @param id id of the computer
	 * @return success of the method
	 * @throws DataAccessException
	 */
	public boolean deleteOne(long id) throws DataAccessException {
		int rs=0;
		JdbcTemplate delete=new JdbcTemplate(dataSource);
		rs=delete.update("DELETE FROM computer WHERE id=?", new Object[] {id});
		return (rs!=0);
	}
	
	

}
