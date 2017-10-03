package com.coikontroly.dao;

import java.util.Collection;

import org.bson.Document;

public interface InspectionDao {
	/**
	 * Searches for inspections by given ico param.
	 * @param ico Identification of organization
	 * @return List of org.bson.Document objects. Each item of list represents one inspection. If no inspection is found
	 * empty list is returned
	 */
	Collection<Document> findInspectionByICO(Long ico);
}
