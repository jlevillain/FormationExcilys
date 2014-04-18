package com.excilys.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.excilys.dao.ComputerDao;
import com.excilys.dao.DaoFactory;
import com.excilys.dao.LogDao;
import com.excilys.om.Computer;
import com.excilys.om.Log;


@Service
@Transactional(readOnly=true)
public class ComputerServiceImpl implements ComputerService {
	
	Logger logger = LoggerFactory.getLogger(ComputerService.class);
	
	@Autowired
	DaoFactory daoFactory;
	@Autowired
	ComputerDao computerDao;
	@Autowired
	LogDao logDao;
	
	public int getSize(String search) {
		int size=0;
		size=computerDao.getSize(search);
		return size;
	}
	
	@Transactional(readOnly=false)
	public boolean insertOne(Computer comp)throws DataAccessException {
		boolean result=false;
		result = computerDao.insertOne(comp);
		logDao.insertOne(Log.build().request("insertOne Computer "+comp).build());	
		return result;
		 
	}

	@Transactional(readOnly=false)
	public boolean deleteOne(long id) throws DataAccessException {
		// TODO Auto-generated method stub
		boolean result=false;
		result = computerDao.deleteOne(id);
		logDao.insertOne(Log.build().request("deleteOne Computer "+id).build());
		return result;
	}

	@Transactional(readOnly=false)
	public boolean updateOne(Computer comp)throws DataAccessException {
		// TODO Auto-generated method stub
		boolean result=false;
		result = computerDao.updateOne(comp);
		logDao.insertOne(Log.build().request("updateOne Computer "+comp).build());
		return result;
	}
	
	public Computer getOne(long id) {
		Computer result=null;
		result = computerDao.getOne(id);
		return result;
		 
	}
	
	public List<Computer> getAll(String search, int begin,int number, int order, boolean desc) {
		List<Computer> result=null;
		result = computerDao.getAll(search,begin, number,order,desc);
		return result;
	}

	public List<Computer> getAll() {
		// TODO Auto-generated method stub
		List<Computer> result=null;
		result = computerDao.getAll();
		return result;
	}
	
}
