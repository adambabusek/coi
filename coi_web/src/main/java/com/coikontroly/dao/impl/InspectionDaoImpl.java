package com.coikontroly.dao.impl;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.coikontroly.common.utils.Constants;
import com.coikontroly.common.utils.DocUtils;
import com.coikontroly.dao.InspectionDao;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

@Repository
public class InspectionDaoImpl implements InspectionDao {

	@Value("#{mongoClient.getDatabase(databaseName)}")
	private MongoDatabase mongoDb;

	@Override
	@Cacheable("inspections")
	public Document findInspectionByICO(Long ico) {
		FindIterable<Document> search = mongoDb.getCollection(Constants.COLL_KONTROLY)
												.find(new Document(Constants.KEY_ICO, ico));
		return DocUtils.toDocument(Constants.KEY_RESULT, search);
	}

}
