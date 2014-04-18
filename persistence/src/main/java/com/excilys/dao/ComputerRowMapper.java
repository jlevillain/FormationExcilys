package com.excilys.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.joda.time.DateTime;
import org.springframework.jdbc.core.RowMapper;

import com.excilys.om.Company;
import com.excilys.om.Computer;

public class ComputerRowMapper implements RowMapper<Computer> {

	@Override
	public Computer mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		DateTime introduced, discontinued;
		if (rs.getDate("c.introduced")==null) {
			introduced=null;
		}else {
			introduced=new DateTime(rs.getDate("c.introduced").getTime());
		}
		if (rs.getDate("c.discontinued")==null) {
			discontinued=null;
		}else {
			discontinued=new DateTime(rs.getDate("c.discontinued").getTime());
		}
		Company company=new Company();
		company.setId(rs.getLong("company.id"));
		company.setName(rs.getString("company.name"));
		Computer computer=Computer.build().
				id(rs.getLong("c.id")).
				name(rs.getString("c.name")).
				introduced(introduced).
				discontinued(discontinued).
				company(company)
				.build();
		return computer;
	}
	
}
