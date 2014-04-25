package com.excilys.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.excilys.om.Company;
import com.excilys.om.Computer;
import com.excilys.om.QCompany;
import com.excilys.om.QComputer;
import com.mysema.query.hql.HQLQuery;
import com.mysema.query.hql.hibernate.HibernateQuery;
import com.mysema.query.types.OrderSpecifier;

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
	public List<Computer> getAll() throws DataAccessException {
		List<Computer> liste = null;
		QComputer computer = QComputer.computer;
		HQLQuery query = new HibernateQuery(sessionFactory.getCurrentSession());
		liste = query.from(computer).orderBy(computer.name.asc()).list(computer);
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
		QCompany company=QCompany.company;
		HQLQuery subQuery = new HibernateQuery(sessionFactory.getCurrentSession());
		List<Long> compList=subQuery.from(company)
				.where(company.name.like(new StringBuilder("%").append(search).append("%").toString()))
				.list(company.id);
		if (compList.size()==0) {
			compList.add(new Long(0));
		}
		logger.debug("getSize : "+size);
		QComputer computer=QComputer.computer;
		HQLQuery query = new HibernateQuery(sessionFactory.getCurrentSession());
		size=(int)query.from(computer)
				.where(computer.name.like(new StringBuilder("%").append(search).append("%").toString())
						.or(computer.company.id.in(compList)))
				.count();
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
		QComputer computer=QComputer.computer;
		QCompany company=QCompany.company;
		OrderSpecifier[] nameAsc={computer.id.asc(),computer.id.asc(),computer.name.asc(),
				computer.introduced.asc(),computer.discontinued.asc(),computer.company.id.asc(),computer.company.name.asc()};
		OrderSpecifier[] nameDesc={computer.id.desc(),computer.id.desc(),computer.name.desc(),
				computer.introduced.desc(),computer.discontinued.desc(),computer.company.id.desc(),computer.company.name.desc()};
		
		HQLQuery subQuery = new HibernateQuery(sessionFactory.getCurrentSession());
		List<Long> compList=subQuery.from(company)
				.where(company.name.like(new StringBuilder("%").append(search).append("%").toString()))
				.list(company.id);
		if (compList.size()==0) {
			compList.add(new Long(0));
		}
		logger.debug(""+compList);
		
		HQLQuery query = new HibernateQuery(sessionFactory.getCurrentSession());
		query=query.from(computer)
				.where(computer.name.like(new StringBuilder("%").append(search).append("%").toString())
						.or(computer.company.id.in(compList)));
		if(desc) {
			query=query.orderBy(nameDesc[order]);
		}else {
			query=query.orderBy(nameAsc[order]);
		}
		liste=query.offset(begin).limit(number).list(computer);
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
