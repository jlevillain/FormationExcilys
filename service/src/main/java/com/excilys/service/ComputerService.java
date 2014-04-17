package com.excilys.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.excilys.dao.CompanyDao;
import com.excilys.dao.ComputerDao;
import com.excilys.dao.DaoFactory;
import com.excilys.om.Computer;

public interface ComputerService {
	/**
	 * get all computer
	 * @return list of computer
	 */
	public List<Computer> getAll();
	/**
	 * get the size of list of computer
	 * @param search search parameter
	 * @return the size of list of computer
	 */
	public int getSize(String search);
	/**
	 * insert one computer
	 * @param comp computer to insert
	 * @return success of the method
	 */
	public boolean insertOne(Computer comp);
	/**
	 * delete one computer
	 * @param id id of computer
	 * @return success of the method
	 */
	public boolean deleteOne(long id);
	/**
	 * update one computer
	 * @param comp computer to update
	 * @return success of computer
	 */
	public boolean updateOne(Computer comp);
	/**
	 * get one computer
	 * @param id id of the computer
	 * @return a computer
	 */
	public Computer getOne(long id);
	/**
	 * get a list of computer with the good parameter
	 * @param search search parameter
	 * @param begin 
	 * @param number number of page
	 * @param order sort by order
	 * @param desc descendant sort
	 * @return list of computer
	 */
	public List<Computer> getAll(String search, int begin,int number, int order, boolean asc);
}
