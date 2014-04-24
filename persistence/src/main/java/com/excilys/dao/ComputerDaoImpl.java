package com.excilys.dao;

import java.sql.Date;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
		liste=sessionFactory.getCurrentSession().createQuery("from Computer").list();
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
		size=((Long)sessionFactory.getCurrentSession().createQuery("select count(*) from Computer as c where c.name like ?")
				.setString(0, "%"+search+"%").uniqueResult()).intValue();
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
		String[] name={"","c.id","c.name","c.introduced","c.discontinued","c.company.id","c.company.id"};
		StringBuilder request=new StringBuilder("FROM Computer as c ");
		request.append("where c.name LIKE ? or c.company.id IN")
		.append("( SELECT co.id FROM Company as co where co.name LIKE ? ) order by ")
		.append(name[order]);
	    if (desc) {
	    	request.append(" DESC");
	    }
	    logger.debug(request.toString());
		liste =(ArrayList<Computer>)sessionFactory.getCurrentSession().createQuery(request.toString())
				.setString(0, new StringBuilder("%").append(search).append("%").toString())
				.setString(1, new StringBuilder("%").append(search).append("%").toString())
				.setFirstResult(begin).setMaxResults(number).list();
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
