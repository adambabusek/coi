package com.coikontroly.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coikontroly.dao.InspectionDao;

@RestController
@RequestMapping("/inspection")
public class InspectionController {

	@Autowired
	private InspectionDao inspectionDao;

	@RequestMapping(value="/{ico}", method=RequestMethod.GET, produces="application/json")
	public String findInspections(@PathVariable(value="ico") Long ico) {
		return inspectionDao.findInspectionByICO(ico).toJson();
	}
}
