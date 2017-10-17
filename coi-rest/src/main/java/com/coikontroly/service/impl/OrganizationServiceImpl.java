package com.coikontroly.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.annotation.Resource;

import org.bson.Document;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import com.coikontroly.service.OrganizationService;

@Component
public class OrganizationServiceImpl implements OrganizationService {

	@Resource(name="settingSource")
	private ReloadableResourceBundleMessageSource settingSource;

	@Override
	public Document findOrganization(String ico) throws NoSuchMessageException, IOException {
		Document ret = new Document();
		ret.append("ico", ico);
		ret.append("name", "Ajajaj s.r.o.");
		ret.append("place", "č.p. 12/A, 100 00 Praha");

		URL url = new URL(settingSource.getMessage("setting.searchOrganizationUrl", new Object[] {ico}, null));
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", "application/json");

		InputStream response = con.getInputStream();
		try (Scanner scanner = new Scanner(response)) {
		    String responseBody = scanner.useDelimiter("\\A").next();
		    System.out.println(responseBody);
		}

		return ret;
	}

}
