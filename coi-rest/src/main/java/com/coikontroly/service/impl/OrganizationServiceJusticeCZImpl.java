package com.coikontroly.service.impl;

import java.io.IOException;

import org.bson.Document;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coikontroly.common.components.MessageResolver;
import com.coikontroly.common.utils.CheckUtils;
import com.coikontroly.common.utils.Constants;
import com.coikontroly.service.OrganizationService;

@Component("justiceSvc")
public class OrganizationServiceJusticeCZImpl implements OrganizationService {

	private static final String CSS_QUERY_TABLE = "table.result-details";

	@Autowired
	private MessageResolver msgRes;

	@Override
	public Document findOrganization(String ico) throws IOException {
		CheckUtils.checkIco(ico, msgRes);

		Document ret = new Document();
		ret.append(Constants.KEY_ICO, ico);

		org.jsoup.nodes.Document doc = Jsoup.connect(msgRes.getSetting("setting.searchOrganizationUrl", ico)).get();
		Elements table = doc.select(CSS_QUERY_TABLE);
		if (table == null || !table.hasText()) {
			// TODO log
			// organization cannot be found so returned Document is filled only with ICO value
			return ret;
		}

		Elements cells = table.select("td");
		ret.append(Constants.KEY_NAME, findNameValue(cells));
		ret.append(Constants.KEY_PLACE, findPlaceValue(cells));
		return ret;
	}

	private String findPlaceValue(Elements cells) {
		return cells.get(cells.size() - 1)
					.select("span")
					.get(1)
					.html().trim();
	}

	private String findNameValue(Elements cells) {
		return cells.get(0)
					.select("strong")
					.html().trim();
	}

}
