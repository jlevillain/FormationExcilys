package com.excilys.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.excilys.om.Computer;

public interface ComputerDao extends JpaRepository<Computer, Long>{
//	public Computer getOne(long id) throws DataAccessException;
//	public List<Computer> getAll() throws DataAccessException;
//	public int getSize(String search) throws DataAccessException;
//	public List<Computer> getAll(String search, int begin, int number, int order, boolean desc) throws DataAccessException;
//	public boolean updateOne(Computer comp) throws DataAccessException;
//	public boolean insertOne(Computer comp) throws DataAccessException;
//	public boolean deleteOne(long id) throws DataAccessException;
	public Page<Computer> findByNameLikeOrCompanyNameLike(String name, String companyName, Pageable page);
	long countByNameLikeOrCompanyNameLike(String name, String companyName);
//	long countLikeNameOrLikeCompanyName(String name, String companyName);
}
