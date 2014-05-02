package com.excilys.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.excilys.dao.ComputerDao;
import com.excilys.dao.LogDao;
import com.excilys.om.Computer;
import com.excilys.om.Log;


@Service
@Transactional(readOnly=true)
public class ComputerServiceImpl implements ComputerService {
	private static String[] name={"id","id","name","introduced","discontinued","company.id","company.name"};
	Logger logger = LoggerFactory.getLogger(ComputerService.class);

	@Autowired
	ComputerDao computerDao;
	@Autowired
	LogDao logDao;
	
	public int getSize(String search) {
		String search2=new StringBuilder("%").append(search).append("%").toString();
		return (int)computerDao.countByNameLikeOrCompanyNameLike(search2,search2 );
	}
	
	@Transactional(readOnly=false)
	public void insertOne(Computer comp)throws DataAccessException {
		computerDao.save(comp);
		logDao.save(Log.build().request("insertOne Computer "+comp).build());
	}

	@Transactional(readOnly=false)
	public void deleteOne(long id) throws DataAccessException {
		// TODO Auto-generated method stub
		computerDao.delete(id);
		logDao.save(Log.build().request("deleteOne Computer "+id).build());
	}

	@Transactional(readOnly=false)
	public void updateOne(Computer comp)throws DataAccessException {
		// TODO Auto-generated method stub
		computerDao.save(comp);
		logDao.save(Log.build().request("updateOne Computer "+comp).build());
	}
	
	public Computer getOne(long id) {
		return computerDao.findOne(id); 
	}
	
	public List<Computer> getAll(String search, int begin,int number, int order, boolean desc) {
		
		String search2=new StringBuilder("%").append(search).append("%").toString();
		Page<Computer> pageComputer;
			pageComputer=computerDao.findByNameLikeOrCompanyNameLike(search2, search2,
					new PageRequest(begin, number, new Sort((desc)?Sort.Direction.DESC:Sort.Direction.ASC, name[order])));
		return pageComputer.getContent();
	}

	public List<Computer> getAll() {
		// TODO Auto-generated method stub
		return computerDao.findAll();
	}
	
}
