package com.excilys.om;

import org.junit.Test;
import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.runner.RunWith;
import org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ComputerTest {

	private static final long id = 1L;
	private static final String name = "name";
	private static final DateTime introduced = null;
	private static final DateTime discontinued = null;
	private static final Company company = null;

	private static final long defaultId = 0L;
	private static final String defaultName = "";
	private static final DateTime defaultIntroduced = null;
	private static final DateTime defaultDiscontinued = null;
	private static final DateTime defaultCompanyNot = null;

	@Test
	public void computerBuilder() {
		Computer computer = Computer.build().id(id).name(name).introduced(introduced).discontinued(discontinued)
				.company(company).build();

		assertEquals(id, computer.getId());
		assertEquals(name, computer.getName());
		assertEquals(introduced, computer.getIntroduced());
		assertEquals(discontinued, computer.getDiscontinued());
		assertEquals(company, computer.getCompany());
	}

	@Test
	public void computerDefaultBuilder() {
		Computer computer = Computer.build().build();

		assertEquals(defaultId, computer.getId());
		assertEquals(defaultName, computer.getName());
		assertEquals(defaultIntroduced, computer.getIntroduced());
		assertEquals(defaultDiscontinued, computer.getDiscontinued());
		assertNotEquals(defaultCompanyNot, computer.getCompany());
	}
	
	@Test
	public void computerEquality() {
		Computer computer1 = Computer.build().id(id).name(name).build();
		Computer computer2 = Computer.build().id(id).name(name).build();
		boolean actual = computer1.equals(computer2);
		assertTrue(actual);
	}
	
	@Test
	public void computerInequality() {
		Computer computer1 = Computer.build().id(id).name(name).build();
		Computer computer2 = Computer.build().id(defaultId).name(defaultName).build();
		boolean actual = computer1.equals(computer2);
		assertFalse(actual);
	} 
}
