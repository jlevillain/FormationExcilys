package com.excilys.dao;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.excilys.exception.SQLRuntimeException;
import com.excilys.om.Company;
import com.jolbox.bonecp.BoneCPDataSource;

/**
 * class managing the database for company
 * @author jlevillain
 *
 */
@Repository
public class CompanyDaoImpl implements CompanyDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	Logger logger = LoggerFactory.getLogger(CompanyDaoImpl.class);
	
	@Autowired
	DaoFactory daoFactory;
	
	/**
	 * get one company
	 * @param id id of the company
	 * @return a company
	 * @throws SQLRuntimeException
	 */
	public Company getOne(long id) throws SQLRuntimeException {
		Company company =null;	
		JdbcTemplate select=this.jdbcTemplate;
		company=select.queryForObject("SELECT id,name FROM company where id=?", new Object[] {id}, new BeanPropertyRowMapper<Company>(Company.class));
		return company;
	}

	/**
	 * get a list of company
	 * @return the list of company
	 * @throws SQLRuntimeException
	 */
	public List<Company> getAll() throws SQLRuntimeException {
		List<Company> liste = null;
		JdbcTemplate select=this.jdbcTemplate;
		liste=select.query("SELECT id, name FROM company order by name", new BeanPropertyRowMapper<Company>(Company.class));
		return liste;
	}
	
	
}
