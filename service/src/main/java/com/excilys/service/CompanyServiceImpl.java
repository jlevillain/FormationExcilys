package com.excilys.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.excilys.dao.CompanyDao;
import com.excilys.dao.CompanyDaoImpl;
import com.excilys.dao.DaoFactory;
import com.excilys.om.Company;
import  com.excilys.exception.SQLRuntimeException;

@Service
@Transactional(readOnly=true)
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private SessionFactory sessionFactory;
	Logger logger = LoggerFactory.getLogger(ComputerService.class);
	@Autowired
	CompanyDao companyDao;
	public List<Company> getAll() {
		List<Company> list=null;
		list = companyDao.getAll();
		return list;
	}
}
