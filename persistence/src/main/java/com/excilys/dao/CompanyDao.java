package com.excilys.dao;

import java.util.List;
import com.excilys.om.Company;

public interface CompanyDao {
	public Company getOne(long id);
	public List<Company> getAll();
}
