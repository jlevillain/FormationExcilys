package com.excilys.dao;

import com.excilys.exception.SQLRuntimeException;
import com.excilys.om.Log;

public interface LogDao {
	public boolean insertOne( Log request) throws SQLRuntimeException;
}
