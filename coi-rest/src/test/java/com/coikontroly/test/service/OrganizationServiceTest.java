package com.coikontroly.test.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.bson.Document;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.NoSuchMessageException;
import org.xml.sax.SAXException;

import com.coikontroly.common.utils.Constants;
import com.coikontroly.service.OrganizationService;
import com.coikontroly.test.common.BaseTest;

public class OrganizationServiceTest extends BaseTest {

	private static final String ICO_1 = "27082440";

	@Autowired
	private OrganizationService orgSvc;

	@Test
	public void findOrganizationTest() throws NoSuchMessageException, IOException, SAXException {
		Document doc = orgSvc.findOrganization(ICO_1);
		assertNotNull(doc);
		assertTrue(doc.get(Constants.KEY_ICO).equals(ICO_1));
		assertTrue(doc.get(Constants.KEY_NAME).equals("Alza.cz a.s."));
		assertTrue(doc.get(Constants.KEY_PLACE).equals("Praha 7, Jateční 33a, PSČ 17000"));
	}
}
