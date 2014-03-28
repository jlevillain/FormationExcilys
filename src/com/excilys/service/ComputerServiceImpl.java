package com.excilys.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.excilys.dao.DaoFactory;
import com.excilys.om.Computer;

public enum ComputerServiceImpl implements ComputerService {
	INSTANCE;
	Logger logger = LoggerFactory.getLogger(ComputerService.class);

	public List<Computer> getAll() {
		List<Computer> list=null;
		Connection cn = DaoFactory.INSTANCE.getConnectionPool();
		try {
			cn.setAutoCommit(false);
			DaoFactory.INSTANCE.getComputerDao().getAll();
			DaoFactory.INSTANCE.getLogDao().insertOne("getAll Computer");
			cn.commit();
		}catch (SQLException e) {
			logger.debug(new StringBuilder("getAll SqlException").append(e.getMessage()).append(e.getStackTrace()).toString());
			try {
				cn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.debug("rollback fail getAll Computer");
			}
		}finally {
			DaoFactory.INSTANCE.closeConnection();
		}
		return list;
	}
	
	
	public int getSize(String search) {
		Connection cn = DaoFactory.INSTANCE.getConnectionPool();
		int size=0;
		try {
			cn.setAutoCommit(false);
			size=DaoFactory.INSTANCE.getComputerDao().getSize(search);
			DaoFactory.INSTANCE.getLogDao().insertOne("getSize Computer");
			cn.commit();
		}catch (SQLException e) {
			logger.debug(new StringBuilder("getSize SqlException").append(e.getMessage()).append(e.getStackTrace()).toString());
			try {
				cn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.debug("rollback fail getAll Computer"+e1.getMessage());
			}
			
		}finally {
			DaoFactory.INSTANCE.closeConnection();
		}
		return size;
	}
	
	public boolean insertOne(Computer comp) {
		Connection cn = DaoFactory.INSTANCE.getConnectionPool();
		boolean result=false;
		try {	
			cn.setAutoCommit(false);
			result = DaoFactory.INSTANCE.getComputerDao().insertOne(comp);
			DaoFactory.INSTANCE.getLogDao().insertOne("insertOne Computer "+comp);
			cn.commit();
		}catch (SQLException e) {
			logger.debug(new StringBuilder("getinsertOne SqlException").append(e.getMessage()).append(e.getStackTrace()).toString());
			try {
				cn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.debug("rollback fail insertOne Computer"+e1.getMessage());
			}
		}finally {
			DaoFactory.INSTANCE.closeConnection();
		}
		return result;
		 
	}

	@Override
	public boolean deleteOne(long id) {
		// TODO Auto-generated method stub
		Connection cn = DaoFactory.INSTANCE.getConnectionPool();
		boolean result=false;
		try {
			cn.setAutoCommit(false);
			result = DaoFactory.INSTANCE.getComputerDao().deleteOne(id);
			DaoFactory.INSTANCE.getLogDao().insertOne("deleteOne Computer "+id);
			cn.commit();
		}catch (SQLException e) {
			logger.debug(new StringBuilder("getAll SqlException").append(e.getMessage()).append(e.getStackTrace()).toString());
			try {
				cn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.debug("rollback fail insertOne Computer"+e1.getMessage());
			}
		}finally {
			DaoFactory.INSTANCE.closeConnection();
		}
		return result;
	}

	@Override
	public boolean updateOne(Computer comp) {
		// TODO Auto-generated method stub
		Connection cn = DaoFactory.INSTANCE.getConnectionPool();
		boolean result=false;
		try {
			cn.setAutoCommit(false);
			result = DaoFactory.INSTANCE.getComputerDao().updateOne(comp);
			DaoFactory.INSTANCE.getLogDao().insertOne("updateOne Computer "+comp);
			cn.commit();
		}catch (SQLException e) {
			logger.debug(new StringBuilder("update SqlException").append(e.getMessage()).append(e.getStackTrace()).toString());
			try {
				cn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.debug("rollback fail insertOne Computer"+e1.getMessage());
			}
		}finally {
			DaoFactory.INSTANCE.closeConnection();
		}
		return result;
	}
	
	public Computer getOne(long id) {
		Connection cn = DaoFactory.INSTANCE.getConnectionPool();
		Computer result=null;
		try {
			cn.setAutoCommit(false);
			result = DaoFactory.INSTANCE.getComputerDao().getOne(id);
			DaoFactory.INSTANCE.getLogDao().insertOne("getOne Computer "+id);
			cn.commit();
		}catch (SQLException e) {
			logger.debug(new StringBuilder("getOne SqlException").append(e.getMessage()).append(e.getStackTrace()).toString());
			try {
				cn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.debug("rollback fail insertOne Computer"+e1.getMessage());
			}
		}finally {
			DaoFactory.INSTANCE.closeConnection();
		}
		return result;
		 
	}
	
	public List<Computer> getAll(String search, int begin,int number, int order, boolean asc) {
		Connection cn = DaoFactory.INSTANCE.getConnectionPool();
		List<Computer> result=null;
		try {
			cn.setAutoCommit(false);
			result = DaoFactory.INSTANCE.getComputerDao().getAll(search,begin, number,order,asc);
			DaoFactory.INSTANCE.getLogDao().insertOne("getAll Computer ");
			cn.commit();
		}catch (SQLException e) {
			logger.debug(new StringBuilder("getAll SqlException").append(e.getMessage()).append(e.getStackTrace()).toString());
			try {
				cn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.debug("rollback fail  getAll Computer"+e1.getMessage());
			}
		}finally {
			DaoFactory.INSTANCE.closeConnection();
		}
		return result;
	}
	
}
