package com.coikontroly.test.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.coikontroly.service.OrganizationService;
import com.coikontroly.test.common.BaseTest;

public class OrganizationServiceTest extends BaseTest {

	@Autowired
	private OrganizationService orgSvc;

	@Test
	public void firstTest() {
		assertNotNull(orgSvc);
	}
}
