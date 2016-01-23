package com.excilys.om;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CompanyTest {

	public static final long id = 1L;
	public static final String name = "name";
	public static final long defaultId = 0L;
	public static final String defaultName = "";

	@Test
	public void companyBuilder() {
		Company company = Company.build().id(id).name(name).build();

		assertEquals(id, company.getId());
		assertEquals(name, company.getName());
	}

	@Test
	public void companyDefaultBuilder() {
		Company company = Company.build().build();

		assertEquals(defaultId, company.getId());
		assertEquals(defaultName, company.getName());
	}

	@Test
	public void companyEquality() {
		Company company1 = Company.build().id(id).name(name).build();
		Company company2 = Company.build().id(id).name(name).build();
		boolean actual = company1.equals(company2);
		assertTrue(actual);
	}

	@Test
	public void companyInequality() {
		Company company1 = Company.build().id(id).name(name).build();
		Company company2 = Company.build().id(defaultId).name(defaultName).build();
		boolean actual = company1.equals(company2);
		assertFalse(actual);
	}
}
