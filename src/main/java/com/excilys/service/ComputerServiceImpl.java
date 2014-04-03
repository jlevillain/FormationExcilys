package com.excilys.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.excilys.dao.ComputerDao;
import com.excilys.dao.DaoFactory;
import com.excilys.dao.LogDao;
import com.excilys.om.Computer;
import com.excilys.om.Log;
import  com.excilys.exception.SQLRuntimeException;

@Service
public class ComputerServiceImpl implements ComputerService {
	
	Logger logger = LoggerFactory.getLogger(ComputerService.class);
	
	@Autowired
	DaoFactory daoFactory;
	@Autowired
	ComputerDao computerDao;
	@Autowired
	LogDao logDao;
	
	public int getSize(String search) {
		Connection cn = daoFactory.getConnectionPool();
		int size=0;
		try {
			size=computerDao.getSize(search);
		}catch (SQLRuntimeException e) {
			// TODO: handle exceptio
			logger.debug(e.getMessage());
			throw e;
		}finally {
			daoFactory.closeConnection();
		}
		return size;
	}
	
	public boolean insertOne(Computer comp) {
		daoFactory.getConnectionPool();
		boolean result=false;
		try {	
			daoFactory.startTransaction();
			result = computerDao.insertOne(comp);
			logDao.insertOne(Log.build().request("insertOne Computer "+comp).build());
			daoFactory.commit();
		}catch (SQLRuntimeException e) {
			logger.debug(new StringBuilder("getinsertOne SqlException").append(e.getMessage()).append(e.getStackTrace()).toString());
			daoFactory.rollback();
			logger.debug("rollback fail insertOne Computer"+e.getMessage());
			throw e;
		}finally {
			daoFactory.closeConnection();
		}
		return result;
		 
	}

	public boolean deleteOne(long id) {
		// TODO Auto-generated method stub
		Connection cn = daoFactory.getConnectionPool();
		boolean result=false;
		try {
			daoFactory.startTransaction();
			result = computerDao.deleteOne(id);
			logDao.insertOne(Log.build().request("deleteOne Computer "+id).build());
			daoFactory.commit();
		}catch (SQLRuntimeException e) {
			logger.debug(new StringBuilder("getAll SqlException").append(e.getMessage()).append(e.getStackTrace()).toString());
			daoFactory.rollback();
			throw e;
		}finally {
			daoFactory.closeConnection();
		}
		return result;
	}

	public boolean updateOne(Computer comp) {
		// TODO Auto-generated method stub
		Connection cn = daoFactory.getConnectionPool();
		boolean result=false;
		try {
			daoFactory.startTransaction();
			result = computerDao.updateOne(comp);
			logDao.insertOne(Log.build().request("updateOne Computer "+comp).build());
			daoFactory.commit();
		}catch (SQLRuntimeException e) {
			logger.debug(new StringBuilder("update SqlException").append(e.getMessage()).append(e.getStackTrace()).toString());
			daoFactory.rollback();
			throw e;
		}finally {
			daoFactory.closeConnection();
		}
		return result;
	}
	
	public Computer getOne(long id) {
		Connection cn = daoFactory.getConnectionPool();
		Computer result=null;
		try {
			result = computerDao.getOne(id);
		}catch (SQLRuntimeException e) {
			logger.debug(new StringBuilder("getOne SqlException").append(e.getMessage()).append(e.getStackTrace()).toString());
			throw e;
		}finally {
			daoFactory.closeConnection();
		}
		return result;
		 
	}
	
	public List<Computer> getAll(String search, int begin,int number, int order, boolean desc) {
		Connection cn = daoFactory.getConnectionPool();
		List<Computer> result=null;
		try {
			result = computerDao.getAll(search,begin, number,order,desc);
		}catch (SQLRuntimeException e) {
			logger.debug(new StringBuilder("getAll SqlException").append(e.getMessage()).append(e.getStackTrace()).toString());
			throw e;
		}finally {
			daoFactory.closeConnection();
		}
		return result;
	}

	public List<Computer> getAll() {
		// TODO Auto-generated method stub
		Connection cn = daoFactory.getConnectionPool();
		List<Computer> result=null;
		try {
			result = computerDao.getAll();
		}catch (SQLRuntimeException e) {
			logger.debug(new StringBuilder("getAll SqlException").append(e.getMessage()).append(e.getStackTrace()).toString());
			throw e;
		}finally {
			daoFactory.closeConnection();
		}
		return result;
	}
	
}
