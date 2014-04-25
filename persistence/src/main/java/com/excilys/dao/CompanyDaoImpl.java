package com.excilys.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.excilys.om.Company;
import com.excilys.om.QCompany;
import com.mysema.query.hql.HQLQuery;
import com.mysema.query.hql.hibernate.HibernateQuery;

/**
 * class managing the database for company
 * 
 * @author jlevillain
 * 
 */
@Repository
public class CompanyDaoImpl implements CompanyDao {
	@Autowired
	private SessionFactory sessionFactory;

	Logger logger = LoggerFactory.getLogger(CompanyDaoImpl.class);

	/**
	 * get one company
	 * 
	 * @param id
	 *            id of the company
	 * @return a company
	 * @throws SQLRuntimeException
	 */
	public Company getOne(long id) {
		Company company = null;
		company = (Company) sessionFactory.getCurrentSession().get(
				Company.class, id);
		return company;
	}

	/**
	 * get a list of company
	 * 
	 * @return the list of company
	 * @throws SQLRuntimeException
	 */
	public List<Company> getAll() {
		List<Company> liste = null;
		QCompany company = QCompany.company;
		HQLQuery query = new HibernateQuery(sessionFactory.getCurrentSession());
		liste = query.from(company).orderBy(company.name.asc()).list(company);
		return liste;
	}

}
