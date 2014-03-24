package com.excilys.service;

import java.util.List;

import com.excilys.dao.DaoFactory;
import com.excilys.om.Company;


public class CompanyServiceImpl implements CompanyService{
	
	public CompanyServiceImpl() {
		
	}
	public List<Company> getAll() {
		return DaoFactory.getCompanyDao().getAll();
	}
}
