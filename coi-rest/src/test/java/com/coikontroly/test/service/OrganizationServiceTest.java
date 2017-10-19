package com.coikontroly.test.service;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.bson.Document;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.NoSuchMessageException;
import org.xml.sax.SAXException;

import com.coikontroly.service.OrganizationService;
import com.coikontroly.test.common.BaseTest;

public class OrganizationServiceTest extends BaseTest {

	@Autowired
	private OrganizationService orgSvc;

	@Test
	public void firstTest() throws NoSuchMessageException, IOException, SAXException {
		Document doc = orgSvc.findOrganization("28528492");
		assertNotNull(doc);
	}
}
