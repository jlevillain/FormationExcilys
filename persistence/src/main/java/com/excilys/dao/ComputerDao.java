package com.excilys.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.excilys.om.Computer;

public interface ComputerDao {
	public Computer getOne(long id) throws DataAccessException;
	public List<Computer> getAll() throws DataAccessException;
	public int getSize(String search) throws DataAccessException;
	public List<Computer> getAll(String search, int begin, int number, int order, boolean desc) throws DataAccessException;
	public boolean updateOne(Computer comp) throws DataAccessException;
	public boolean insertOne(Computer comp) throws DataAccessException;
	public boolean deleteOne(long id) throws DataAccessException;
}
