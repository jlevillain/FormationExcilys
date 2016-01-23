package com.excilys.wrapper;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import com.excilys.dto.ComputerDto;

@RunWith(MockitoJUnitRunner.class)
public class PageTest {
	private static final int secondPage = 2;
	private static final int interval = 10;
	private static final boolean desc = true;
	private static final String search = "search";
	private static final List<ComputerDto> computerList = null;
	private static final int computerSize = 0;
	private static final int orderBy = 1;
	private static final int nbPage = 20;

	private static final int defaultPage = 1;
	private static final int defaultInterval = 5;
	private static final boolean defaultDesc = false;
	private static final String defaultSearch = "";
	private static final List<ComputerDto> defaultComputerList = null;
	private static final int defaultComputerSize = 0;
	private static final int defaultOrderBy = 2;
	private static final int defaultNbPage = 10;

	@Test
	public void pageBuilder() {
		Page page = Page.build().page(secondPage).interval(interval).isDesc(desc).search(search)
				.computerList(computerList).computerSize(computerSize).orderBy(orderBy).nbPage(nbPage).build();

		assertEquals(secondPage, page.getPage());
		assertEquals(interval, page.getInterval());
		assertEquals(desc, page.isDesc());
		assertEquals(search, page.getSearch());
		assertEquals(computerList, page.getComputerList());
		assertEquals(computerSize, page.getComputerSize());
		assertEquals(orderBy, page.getOrderBy());
		assertEquals(nbPage, page.getNbPage());
	}

	@Test
	public void pageDefaultBuilder() {
		Page page = Page.build().build();

		assertEquals(defaultPage, page.getPage());
		assertEquals(defaultInterval, page.getInterval());
		assertEquals(defaultDesc, page.isDesc());
		assertEquals(defaultSearch, page.getSearch());
		assertEquals(defaultComputerList, page.getComputerList());
		assertEquals(defaultComputerSize, page.getComputerSize());
		assertEquals(defaultOrderBy, page.getOrderBy());
		assertEquals(defaultNbPage, page.getNbPage());

	}
}
