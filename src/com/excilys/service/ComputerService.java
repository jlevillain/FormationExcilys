package com.excilys.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.excilys.dao.CompanyDao;
import com.excilys.dao.ComputerDao;
import com.excilys.dao.DaoFactory;
import com.excilys.om.Computer;

public interface ComputerService {
	public List<Computer> getAll();
	public int getSize();
	public boolean insertOne(Computer comp);
	public boolean deleteOne(long id);
	public boolean updateOne(Computer comp);
}
