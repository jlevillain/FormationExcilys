package com.excilys.dto;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CompanyDtoTest {

	private static final String id = "id";
	private static final String name = "name";

	@Test
	public void computerDTOBuilder() {
		CompanyDto companyDto = CompanyDto.build().id(id).name(name).build();
		assertEquals(id, companyDto.getId());
		assertEquals(name, companyDto.getName());
	}

	@Test
	public void computerDTODefaultBuilder() {
		CompanyDto companyDTO = CompanyDto.build().build();
		assertNull(companyDTO.getId());
		assertNull(companyDTO.getName());
	}
}
