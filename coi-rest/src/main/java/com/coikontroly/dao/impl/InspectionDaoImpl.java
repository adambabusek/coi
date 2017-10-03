package com.coikontroly.dao.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.coikontroly.common.utils.Constants;
import com.coikontroly.dao.InspectionDao;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

@Repository
public class InspectionDaoImpl implements InspectionDao {

	@Value("#{mongoClient.getDatabase(databaseName)}")
	private MongoDatabase mongoDb;

	@Override
	public Collection<Document> findInspectionByICO(Long ico) {
		FindIterable<Document> search = mongoDb.getCollection(Constants.COLL_KONTROLY)
												.find(new Document(Constants.KEY_ICO, ico));
		Collection<Document> ret = new ArrayList<>();
		search.into(ret);
		return ret;
	}

}
