package com.excilys.service;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.excilys.dao.CompanyDao;
import com.excilys.om.Company;

@RunWith(MockitoJUnitRunner.class)
public class CompanyServiceImplTest {
	
	@Mock
	CompanyDao companyDao;
	
	@InjectMocks
	CompanyServiceImpl companyServiceImpl = new CompanyServiceImpl();
	
	@Test
	public void getAll() {
		List<Company> list = new ArrayList<>();
		when(companyDao.findAll(new Sort(Direction.ASC,"name"))).thenReturn(list);
		
		List<Company> list2 = companyServiceImpl.getAll();
		
		verify(companyDao).findAll(new Sort(Direction.ASC,"name"));
		assertEquals(list, list2);
	}
}
