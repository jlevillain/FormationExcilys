package com.excilys.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
		String search2=new StringBuilder("%").append(search).append("%").toString();
		size=(int)computerDao.countByNameLikeOrCompanyNameLike(search2,search2 );
		return size;
	}
	
	@Transactional(readOnly=false)
	public boolean insertOne(Computer comp)throws DataAccessException {
		computerDao.save(comp);
		logDao.save(Log.build().request("insertOne Computer "+comp).build());
		return true;
		 
	}

	@Transactional(readOnly=false)
	public boolean deleteOne(long id) throws DataAccessException {
		// TODO Auto-generated method stub
		computerDao.delete(id);
		logDao.save(Log.build().request("deleteOne Computer "+id).build());
		return true;
	}

	@Transactional(readOnly=false)
	public boolean updateOne(Computer comp)throws DataAccessException {
		// TODO Auto-generated method stub
		computerDao.save(comp);
		logDao.save(Log.build().request("updateOne Computer "+comp).build());
		return true;
	}
	
	public Computer getOne(long id) {
		Computer result=null;
		result = computerDao.findOne(id);
		return result;
		 
	}
	
	public List<Computer> getAll(String search, int begin,int number, int order, boolean desc) {
		String[] name={"id","id","name","introduced","discontinued","company.id","company.name"};
		String search2=new StringBuilder("%").append(search).append("%").toString();
		Page<Computer> pageComputer;
		if (desc) {
			pageComputer=computerDao.findByNameLikeOrCompanyNameLike(search2, search2,
					new PageRequest(begin, number, new Sort(Sort.Direction.DESC, name[order])));
		}else {
			pageComputer=computerDao.findByNameLikeOrCompanyNameLike(search2, search2,
					new PageRequest(begin, number, new Sort(Sort.Direction.ASC, name[order])));
		}
		return pageComputer.getContent();
	}

	public List<Computer> getAll() {
		// TODO Auto-generated method stub
		List<Computer> result=null;
		result = computerDao.findAll();
		return result;
	}
	
}
