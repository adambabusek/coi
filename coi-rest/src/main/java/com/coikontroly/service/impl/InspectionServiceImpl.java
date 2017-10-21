package com.coikontroly.service.impl;

import java.io.IOException;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coikontroly.common.components.MessageResolver;
import com.coikontroly.common.utils.CheckUtils;
import com.coikontroly.common.utils.Constants;
import com.coikontroly.common.utils.DocUtils;
import com.coikontroly.dao.InspectionDao;
import com.coikontroly.service.InspectionService;
import com.coikontroly.service.OrganizationService;

@Component
public class InspectionServiceImpl implements InspectionService {

	@Autowired
	private MessageResolver msgRes;

	@Autowired
	private InspectionDao inspectionDao;

	@Autowired
	private OrganizationService organizationSvc;

	@Override
	public Document findInspections(String ico) throws IOException {
		CheckUtils.checkIco(ico, msgRes);
		Document ret = DocUtils.getSuccessDoc();
		ret.append(Constants.KEY_ORGANIZATION, organizationSvc.findOrganization(ico));
		ret.append(Constants.KEY_INSPECTIONS, inspectionDao.findInspections(Long.valueOf(ico)));
		return ret;
	}


}
