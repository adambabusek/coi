package com.coikontroly.dao;

import org.bson.Document;

public interface InspectionDao {
	/**
	 * Searches for inspections by given ico param.
	 * @param ico Identification of organization
	 * @return org.bson.Document object with key "result" and value as array of found documents. Returned object
	 * is never null. If no inspections is found the returned document has null value.
	 */
	Document findInspectionByICO(Long ico);
}
