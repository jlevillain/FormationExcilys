package com.excilys.dao;

import java.sql.Date;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.excilys.om.Company;
import com.excilys.om.Computer;
import com.jolbox.bonecp.BoneCPDataSource;

/**
 * class managing the database for computer
 * @author jlevillain
 *
 */
@Repository
public class ComputerDaoImpl implements ComputerDao {
	Logger logger = LoggerFactory.getLogger(ComputerDaoImpl.class);
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	DaoFactory daoFactory;
	
	/**
	 * get one computer from the database
	 * @param id id of computer
	 * @return computer 
	 * @throws DataAccessException
	 */
	public Computer getOne(long id) throws DataAccessException {
		Computer comp=null;
		comp=(Computer)sessionFactory.getCurrentSession().get(Computer.class, id);
		return comp;
	}
	
	/**
	 * get all computer from the database
	 * @return list of computer
	 * @throws DataAccessException
	 */
	@SuppressWarnings("unchecked")
	public List<Computer> getAll() throws DataAccessException {
		List<Computer> liste = null;
		liste=sessionFactory.getCurrentSession().createCriteria(Computer.class).list();
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
		@SuppressWarnings("unchecked")
		List<Long> compList=sessionFactory.getCurrentSession().createCriteria(Company.class)
				.add(Restrictions.like("name", new StringBuilder("%").append(search).append("%").toString()))
				.setProjection(Projections.id()).list();
		if (compList.size()==0) {
			compList.add(new Long(0));
		}
		size=((Long)sessionFactory.getCurrentSession().createCriteria(Computer.class)
				.add(Restrictions.or(Restrictions.like("name", 
						new StringBuilder("%").append(search).append("%").toString()),
						Restrictions.in("company.id",compList)))
		.setProjection(Projections.rowCount()).uniqueResult()).intValue();
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
	@SuppressWarnings("unchecked")
	public List<Computer> getAll(String search, int begin, int number, int order, boolean desc) throws DataAccessException {
		List<Computer> liste = null;
		String[] name={"","c.id","name","introduced","discontinued","company.id","company.id"};
		List<Long> compList=sessionFactory.getCurrentSession().createCriteria(Company.class)
		.add(Restrictions.like("name", new StringBuilder("%").append(search).append("%").toString()))
		.setProjection(Projections.id()).list();
		if (compList.size()==0) {
			compList.add(new Long(0));
		}
		logger.debug(""+compList);
		Criteria request=sessionFactory.getCurrentSession().createCriteria(Computer.class)
		.add(Restrictions.or(Restrictions.like("name", 
				new StringBuilder("%").append(search).append("%").toString()),
				Restrictions.in("company.id",compList)));
		if(desc) {
			request=request.addOrder(Order.desc(name[order]));
		}else {
			request=request.addOrder(Order.asc(name[order]));
		}
		liste=request.setFirstResult(begin).setMaxResults(number).list();
		return liste;
	}
	
	/**
	 * update a computer
	 * @param comp a computer to update
	 * @return the success of the method
	 * @throws DataAccessException
	 */
	public boolean updateOne(Computer comp) throws DataAccessException {
		sessionFactory.getCurrentSession().update(comp);
		return true;
	}
	
	/**
	 * insert a computer
	 * @param comp computer
	 * @return the success of the method
	 * @throws DataAccessException
	 */
	public boolean insertOne(Computer comp) throws DataAccessException {
		sessionFactory.getCurrentSession().save(comp);
		return true;
	}
	
	/**
	 * delete one computer 
	 * @param id id of the computer
	 * @return success of the method
	 * @throws DataAccessException
	 */
	public boolean deleteOne(long id) throws DataAccessException {
		Computer comp=null;
		comp=(Computer)sessionFactory.getCurrentSession().get(Computer.class,id);
		if (comp!=null) {
			sessionFactory.getCurrentSession().delete(comp);
		}
		return true;
	}
	
	

}
