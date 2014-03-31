package com.excilys.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.excilys.dao.DaoFactory;
import com.excilys.om.Computer;

import  com.excilys.exception.SQLRuntimeException;

public enum ComputerServiceImpl implements ComputerService {
	INSTANCE;
	Logger logger = LoggerFactory.getLogger(ComputerService.class);

	
	
	public int getSize(String search) {
		Connection cn = DaoFactory.INSTANCE.getConnectionPool();
		int size=0;
		try {
			size=DaoFactory.INSTANCE.getComputerDao().getSize(search);
		}catch (SQLRuntimeException e) {
			// TODO: handle exceptio
			logger.debug(e.getMessage());
			throw e;
		}finally {
			DaoFactory.INSTANCE.closeConnection();
		}
		return size;
	}
	
	public boolean insertOne(Computer comp) {
		DaoFactory.INSTANCE.getConnectionPool();
		boolean result=false;
		try {	
			DaoFactory.INSTANCE.startTransaction();
			result = DaoFactory.INSTANCE.getComputerDao().insertOne(comp);
			DaoFactory.INSTANCE.getLogDao().insertOne("insertOne Computer "+comp);
			DaoFactory.INSTANCE.commit();
		}catch (SQLRuntimeException e) {
			logger.debug(new StringBuilder("getinsertOne SqlException").append(e.getMessage()).append(e.getStackTrace()).toString());
			DaoFactory.INSTANCE.rollback();
			logger.debug("rollback fail insertOne Computer"+e.getMessage());
			throw e;
		}finally {
			DaoFactory.INSTANCE.closeConnection();
		}
		return result;
		 
	}

	public boolean deleteOne(long id) {
		// TODO Auto-generated method stub
		Connection cn = DaoFactory.INSTANCE.getConnectionPool();
		boolean result=false;
		try {
			DaoFactory.INSTANCE.startTransaction();
			result = DaoFactory.INSTANCE.getComputerDao().deleteOne(id);
			DaoFactory.INSTANCE.getLogDao().insertOne("deleteOne Computer "+id);
			DaoFactory.INSTANCE.commit();
		}catch (SQLRuntimeException e) {
			logger.debug(new StringBuilder("getAll SqlException").append(e.getMessage()).append(e.getStackTrace()).toString());
			DaoFactory.INSTANCE.rollback();
			throw e;
		}finally {
			DaoFactory.INSTANCE.closeConnection();
		}
		return result;
	}

	public boolean updateOne(Computer comp) {
		// TODO Auto-generated method stub
		Connection cn = DaoFactory.INSTANCE.getConnectionPool();
		boolean result=false;
		try {
			DaoFactory.INSTANCE.startTransaction();
			result = DaoFactory.INSTANCE.getComputerDao().updateOne(comp);
			DaoFactory.INSTANCE.getLogDao().insertOne("updateOne Computer "+comp);
			DaoFactory.INSTANCE.commit();
		}catch (SQLRuntimeException e) {
			logger.debug(new StringBuilder("update SqlException").append(e.getMessage()).append(e.getStackTrace()).toString());
			DaoFactory.INSTANCE.rollback();
			throw e;
		}finally {
			DaoFactory.INSTANCE.closeConnection();
		}
		return result;
	}
	
	public Computer getOne(long id) {
		Connection cn = DaoFactory.INSTANCE.getConnectionPool();
		Computer result=null;
		try {
			result = DaoFactory.INSTANCE.getComputerDao().getOne(id);
		}catch (SQLRuntimeException e) {
			logger.debug(new StringBuilder("getOne SqlException").append(e.getMessage()).append(e.getStackTrace()).toString());
			throw e;
		}finally {
			DaoFactory.INSTANCE.closeConnection();
		}
		return result;
		 
	}
	
	public List<Computer> getAll(String search, int begin,int number, int order, boolean asc) {
		Connection cn = DaoFactory.INSTANCE.getConnectionPool();
		List<Computer> result=null;
		try {
			result = DaoFactory.INSTANCE.getComputerDao().getAll(search,begin, number,order,asc);
		}catch (SQLRuntimeException e) {
			logger.debug(new StringBuilder("getAll SqlException").append(e.getMessage()).append(e.getStackTrace()).toString());
			throw e;
		}finally {
			DaoFactory.INSTANCE.closeConnection();
		}
		return result;
	}

	public List<Computer> getAll() {
		// TODO Auto-generated method stub
		Connection cn = DaoFactory.INSTANCE.getConnectionPool();
		List<Computer> result=null;
		try {
			result = DaoFactory.INSTANCE.getComputerDao().getAll();
		}catch (SQLRuntimeException e) {
			logger.debug(new StringBuilder("getAll SqlException").append(e.getMessage()).append(e.getStackTrace()).toString());
			throw e;
		}finally {
			DaoFactory.INSTANCE.closeConnection();
		}
		return result;
	}
	
}
