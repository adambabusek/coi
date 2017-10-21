package com.coikontroly.service;

import java.io.IOException;

import org.bson.Document;

public interface InspectionService {

	/**
	 * Searches for inspections by given ico param.
	 * @param ico Identification of organization
	 * @return org.bson.Document objects with collection of inspections.
	 * If no inspection is found empty collection is returned
	 */
	Document findInspections(String ico) throws IOException;
}
