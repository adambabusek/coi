package com.coikontroly.service.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.regex.Pattern;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.coikontroly.dao.InspectionDao;
import com.coikontroly.service.InspectionService;

@Component
public class InspectionServiceImpl implements InspectionService{

	public static final String REGEXP_ICO = "\\d+";

	@Autowired
	private InspectionDao inspectionDao;

	@Override
	public Collection<Document> findInspections(String ico) {
		if (!StringUtils.hasText(ico) || !Pattern.matches(REGEXP_ICO, ico)) {
			return Collections.emptyList();
		}
		return inspectionDao.findInspections(Long.valueOf(ico));
	}


}
