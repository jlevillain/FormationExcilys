package com.excilys.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excilys.om.Log;

public interface LogDao extends JpaRepository<Log, Long>{
}
