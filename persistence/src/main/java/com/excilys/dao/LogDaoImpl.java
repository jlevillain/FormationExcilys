package com.excilys.dao;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.excilys.exception.SQLRuntimeException;
import com.excilys.om.Log;
/**
 * class managing with the database for log
 * @author jlevillain
 *
 */
@Repository
public class LogDaoImpl implements LogDao{
	Logger logger = LoggerFactory.getLogger(LogDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	DaoFactory daoFactory;
	
	/**
	 * insert a log in the database
	 * @param request request effectuated
	 * @return success of the method
	 * @throws SQLRuntimeException
	 */
	public boolean insertOne( Log request) throws SQLRuntimeException {
		int rs=0;
		sessionFactory.getCurrentSession().save(request);	
		return (rs!=0);
	}
}
