package com.excilys.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.excilys.dao.DaoFactory;
import com.excilys.om.Computer;

public class ComputerServiceImpl implements ComputerService {
	Logger logger = LoggerFactory.getLogger(ComputerService.class);
	private static ComputerService computerService=null;
	public ComputerServiceImpl() {
		
	}

	public List<Computer> getAll() {
		return DaoFactory.getComputerDao().getAll();
	}
	
	public int getSize() {
		return DaoFactory.getComputerDao().getSize();
	}
	
	public boolean insertOne(Computer comp) {
		return DaoFactory.getComputerDao().insertOne(comp);
	}

	@Override
	public boolean deleteOne(long id) {
		// TODO Auto-generated method stub
		return DaoFactory.getComputerDao().deleteOne(id);
	}

	@Override
	public boolean updateOne(Computer comp) {
		// TODO Auto-generated method stub
		return DaoFactory.getComputerDao().updateOne(comp);
	}
	
	public Computer getOne(long id) {
		return DaoFactory.getComputerDao().getOne(id);
	}
	
	public List<Computer> getSearch(String search) {
		return DaoFactory.getComputerDao().getSearch(search);
	}
}
