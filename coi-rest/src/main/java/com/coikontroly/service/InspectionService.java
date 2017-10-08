package com.coikontroly.service;

import java.util.Collection;

import org.bson.Document;

public interface InspectionService {

	/**
	 * Searches for inspections by given ico param.
	 * @param ico Identification of organization
	 * @return Collection of org.bson.Document objects. Each item of collection represents one inspection.
	 * If no inspection is found or param ico is invalid empty collection is returned
	 */
	Collection<Document> findInspections(String ico);
}
