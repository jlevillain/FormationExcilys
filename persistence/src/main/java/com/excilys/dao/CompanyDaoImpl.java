package com.excilys.dao;


import java.util.List;

import javax.websocket.Session;

import org.hibernate.SessionFactory;
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
	private SessionFactory sessionFactory;
	
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
		company=(Company) sessionFactory.getCurrentSession().get(Company.class, id);
		return company;
	}

	/**
	 * get a list of company
	 * @return the list of company
	 * @throws SQLRuntimeException
	 */
	@SuppressWarnings("unchecked")
	public List<Company> getAll() throws SQLRuntimeException {
		List<Company> liste = null;
		liste=this.sessionFactory.getCurrentSession().createQuery("from Company").list();
		return liste;
	}

}
