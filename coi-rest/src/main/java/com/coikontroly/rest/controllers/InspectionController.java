package com.coikontroly.rest.controllers;

import java.io.IOException;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.NoSuchMessageException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coikontroly.common.utils.Constants;
import com.coikontroly.service.InspectionService;
import com.coikontroly.service.OrganizationService;

@RestController
@RequestMapping("/inspection")
public class InspectionController {

	@Autowired
	private InspectionService inspectionSvc;

	@Autowired
	private OrganizationService organizationSvc;

	@RequestMapping(value="/{ico}", method=RequestMethod.GET, produces="application/json")
	public String findInspections(@PathVariable(value="ico") String ico) throws NoSuchMessageException, IOException {
		Document ret = new Document();
		Document organization = organizationSvc.findOrganization(ico);
		if (organization != null) {
			ret.append(Constants.KEY_ORGANIZATION, organization);
		}
		ret.append(Constants.KEY_INSPECTIONS, inspectionSvc.findInspections(ico));
		return ret.toJson();
	}
}
