package com.coikontroly.rest.controllers;

import java.util.Collection;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coikontroly.common.utils.Constants;
import com.coikontroly.service.InspectionService;

@RestController
@RequestMapping("/inspection")
public class InspectionController {

	@Autowired
	private InspectionService inspectionSvc;

	@RequestMapping(value="/{ico}", method=RequestMethod.GET, produces="application/json")
	public String findInspections(@PathVariable(value="ico") String ico) {
		Collection<Document> result = inspectionSvc.findInspections(ico);
		return new Document(Constants.KEY_INSPECTIONS, result).toJson();
	}
}
