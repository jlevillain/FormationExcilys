package com.excilys.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.excilys.om.Company;
import com.mysema.query.hql.jpa.JPASessionHolder;

public interface CompanyDao extends JpaRepository<Company, Long> {
}
