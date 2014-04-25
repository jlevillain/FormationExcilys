package com.excilys.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.excilys.dao.CompanyDao;
import com.excilys.om.Company;

@Service
@Transactional(readOnly=true)
public class CompanyServiceImpl implements CompanyService{
	
	Logger logger = LoggerFactory.getLogger(ComputerService.class);
	@Autowired
	CompanyDao companyDao;
	public List<Company> getAll() {
		List<Company> list=null;
		list = companyDao.findAll(new Sort(Direction.ASC,"name"));
		return list;
	}
}
