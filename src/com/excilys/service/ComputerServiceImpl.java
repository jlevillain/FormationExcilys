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
	
	public int getSize(String search) {
		return DaoFactory.getComputerDao().getSize(search);
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
	public List<Computer> getAll(int begin, int end) {
		return DaoFactory.getComputerDao().getAll(begin, end);
	}
	public List<Computer> getAll(String search, int begin, int number) {
		return DaoFactory.getComputerDao().getAll(search,begin, number);
	}
	public List<Computer> getAll(String search, int begin,int number, int order) {
		return DaoFactory.getComputerDao().getAll(search,begin, number,order);
	}
	
	public List<Computer> getAll(String search, int begin,int number, int order, boolean asc) {
		return DaoFactory.getComputerDao().getAll(search,begin, number,order,asc);
	}
	
}
