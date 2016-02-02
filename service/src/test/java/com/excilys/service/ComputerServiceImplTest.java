package com.excilys.service;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.excilys.dao.ComputerDao;
import com.excilys.dao.LogDao;
import com.excilys.om.Computer;
import com.excilys.om.Log;

@RunWith(MockitoJUnitRunner.class)
public class ComputerServiceImplTest {
	private static final long size = 2;
	private static final String search = "search";
	private static final int begin = 1;
	private static final int number = 10;
	private static final int order = 2;
	private static final boolean desc = false;
	private static final long id = 1L;
	private static final String name = "name";

	private static final long id2 = 0L;
	private static final String name2 = "name2";

	private List<Computer> computerList;
	@Mock
	ComputerDao computerDao;

	@Mock
	LogDao logDao;
	
	@Mock
	Page<Computer> pageComputer;

	@InjectMocks
	ComputerServiceImpl computerServiceImpl = new ComputerServiceImpl();

	@Before
	public void setUp() {
		computerList = new ArrayList<>();
		computerList.add(Computer.build().id(id).name(name).build());
		computerList.add(Computer.build().id(id2).name(name2).build());
	}

	@Test
	public void getSize() {
		when(computerDao.countByNameLikeOrCompanyNameLike(anyString(), anyString())).thenReturn(size);

		int actualSize = computerServiceImpl.getSize(search);

		verify(computerDao).countByNameLikeOrCompanyNameLike(anyString(), anyString());
		assertEquals(size, actualSize);
	}

	@Test
	public void insertOne() {
		Computer computer = Computer.build().id(id).name(name).build();

		computerServiceImpl.insertOne(computer);

		verify(computerDao).save(computer);
		verify(logDao).save(any(Log.class));
	}

	@Test
	public void deleteOne() {
		computerServiceImpl.deleteOne(id);

		verify(computerDao).delete(id);
		verify(logDao).save(any(Log.class));
	}

	@Test
	public void updateOne() {
		Computer computer = Computer.build().id(id).name(name).build();

		computerServiceImpl.updateOne(computer);

		verify(computerDao).save(computer);
		verify(logDao).save(any(Log.class));
	}

	@Test
	public void getOne() {
		Computer computer = Computer.build().id(id).name(name).build();
		when(computerDao.findOne(id)).thenReturn(computer);

		Computer actualComputer = computerServiceImpl.getOne(id);

		verify(computerDao).findOne(id);
		assertEquals(computer, actualComputer);
	}

	@Test
	public void getAll() {
		when(computerDao.findAll()).thenReturn(computerList);
		List<Computer> actualList = computerServiceImpl.getAll();

		verify(computerDao).findAll();
		assertEquals(computerList.size(), actualList.size());
	}

	@Test
	public void getAllPage() {
		when(computerDao.findByNameLikeOrCompanyNameLike(anyString(), anyString(), any(PageRequest.class))).thenReturn(pageComputer); 
		when(pageComputer.getContent()).thenReturn(computerList);
		
		List<Computer> actualList = computerServiceImpl.getAll(search, begin, number, order, desc);

		verify(computerDao).findByNameLikeOrCompanyNameLike(anyString(), anyString(), any(PageRequest.class));
		assertEquals(computerList.size(), actualList.size());
	}
}
