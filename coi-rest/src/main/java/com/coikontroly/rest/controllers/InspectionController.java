package com.coikontroly.rest.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coikontroly.service.InspectionService;

@RestController
@RequestMapping("/inspections")
public class InspectionController {

	@Autowired
	private InspectionService inspectionSvc;

	@RequestMapping(value="/{ico}", method=RequestMethod.GET, produces="application/json")
	public String findInspections(@PathVariable(value="ico") String ico) throws IOException {
		return inspectionSvc.findInspections(ico).toJson();
	}
}
