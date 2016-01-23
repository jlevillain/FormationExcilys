package com.excilys.dto;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ComputerDtoTest {

	private static final String id = "id";
	private static final String name = "name";
	private static final String introduced = "introduced";
	private static final String discontinued = "discontinued";
	private static final CompanyDto company = null;
	
	private static final String defaultId = "";
	private static final String defaultName = "";
	private static final String defaultIntroduced = "";
	private static final String defaultDiscontinued = "";
	private static final CompanyDto defaultCompany = null;

	@Test
	public void computerDTOBuilder() {
		ComputerDto computer = ComputerDto.build().id(id).name(name).introduced(introduced).discontinued(discontinued)
				.company(company).build();
		assertEquals(id, computer.getId());
		assertEquals(name, computer.getName());
		assertEquals(introduced, computer.getIntroduced());
		assertEquals(discontinued, computer.getDiscontinued());
		assertEquals(company, computer.getCompany());
	}
	
	@Test
	public void computerDTODefaultBuilder() {
		ComputerDto computer = ComputerDto.build().build();
		assertEquals(defaultId, computer.getId());
		assertEquals(defaultName, computer.getName());
		assertEquals(defaultIntroduced, computer.getIntroduced());
		assertEquals(defaultDiscontinued, computer.getDiscontinued());
		assertEquals(defaultCompany, computer.getCompany());
	}
}