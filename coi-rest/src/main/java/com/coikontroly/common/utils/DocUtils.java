package com.coikontroly.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.bson.Document;

import com.mongodb.client.FindIterable;

public class DocUtils {

	private DocUtils() { }

	public static Document toDocument(String key, FindIterable<Document> findIterable) {
		Document ret = new Document(key, null);

		if (findIterable != null) {
			List<Document> docList = new ArrayList<>();
			findIterable.forEach((Consumer<Document>) d -> docList.add(d));
			ret.put(key, docList);
		}

		return ret;
	}

	public static String toJson(String key, FindIterable<Document> findIterable) {
		return toDocument(key, findIterable).toJson();
	}

	public static <T> Document getSuccessResult(String key, T value) {
		Document ret = new Document(Constants.KEY_RESULT_TYPE, ResultType.SUCCESS.name());
		ret.put(key, value);
		return ret;
	}

	public static <T> Document getErrorResult(String key, T value) {
		Document ret = new Document(Constants.KEY_RESULT_TYPE, ResultType.ERROR.name());
		ret.put(key, value);
		return ret;
	}
}
