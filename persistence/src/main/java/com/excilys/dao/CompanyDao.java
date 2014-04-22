package com.excilys.dao;

import java.util.List;

import com.excilys.exception.SQLRuntimeException;
import com.excilys.om.Company;

public interface CompanyDao {
	public Company getOne(long id) throws SQLRuntimeException;
	public List<Company> getAll() throws SQLRuntimeException;
}
