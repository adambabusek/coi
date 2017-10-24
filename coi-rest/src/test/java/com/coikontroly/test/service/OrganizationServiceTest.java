package com.coikontroly.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.bson.Document;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.coikontroly.common.domain.ErrorType;
import com.coikontroly.common.domain.UserException;
import com.coikontroly.common.utils.Constants;
import com.coikontroly.service.OrganizationService;
import com.coikontroly.test.common.BaseTest;

public class OrganizationServiceTest extends BaseTest {

	private static final String ICO_1 = "27082440";
	private static final String ICO_EMPTY = "";
	private static final String ICO_INVALID = "9x9x9x9x";

	@Autowired
	private OrganizationService orgSvc;

	@Test
	public void findOrganizationTest() throws IOException{
		Document doc = orgSvc.findOrganization(ICO_1);
		assertNotNull(doc);
		assertTrue(doc.get(Constants.KEY_ICO).equals(ICO_1));
		assertTrue(doc.get(Constants.KEY_NAME).equals("Alza.cz a.s."));
		assertTrue(doc.get(Constants.KEY_PLACE).equals("Praha 7, Jateční 33a, PSČ 17000"));
	}

	@Test
	public void findOrganizationErrorTest() throws IOException  {
		try {
			orgSvc.findOrganization(ICO_EMPTY);
		} catch (UserException ex) {
			assertEquals(ex.getType(), ErrorType.EMPTY_ICO);
		}

		try {
			orgSvc.findOrganization(ICO_INVALID);
		} catch (UserException ex) {
			assertEquals(ex.getType(), ErrorType.INVALID_ICO);
		}
	}
}
