package com.coikontroly.service.impl;

import java.io.IOException;

import javax.annotation.Resource;

import org.bson.Document;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import com.coikontroly.common.utils.Constants;
import com.coikontroly.service.OrganizationService;

@Component
public class OrganizationServiceJusticeCZImpl implements OrganizationService {

	private static final String CSS_QUERY_TABLE = "table.result-details";

	@Resource(name="settingSource")
	private ReloadableResourceBundleMessageSource settingSource;

	@Override
	public Document findOrganization(String ico) throws NoSuchMessageException, IOException, SAXException {
		Document ret = new Document();
		ret.append(Constants.KEY_ICO, ico);

		org.jsoup.nodes.Document doc = Jsoup.connect(settingSource.getMessage("setting.searchOrganizationUrl", new Object[] {ico}, null)).get();
		Elements cells = doc.select(CSS_QUERY_TABLE).select("td");
		ret.append(Constants.KEY_NAME, findNameValue(cells));
		ret.append(Constants.KEY_PLACE, findPlaceValue(cells));

		return ret;
	}

	private String findPlaceValue(Elements cells) {
		return cells.get(cells.size() - 1).select("span").get(1).html();
	}

	private String findNameValue(Elements cells) {
		return cells.get(0).select("strong").html();
	}

}
