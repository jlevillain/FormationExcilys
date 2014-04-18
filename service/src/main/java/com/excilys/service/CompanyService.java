package com.excilys.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.excilys.dao.DaoFactory;
import com.excilys.om.Company;
import com.excilys.om.Computer;

public interface CompanyService {
	/**
	 * get all company
	 * @return list of company
	 */
	public List<Company> getAll();
	
}