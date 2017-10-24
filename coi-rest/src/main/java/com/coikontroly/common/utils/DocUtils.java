package com.coikontroly.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.bson.Document;

import com.coikontroly.common.components.MessageResolver;
import com.coikontroly.common.domain.ErrorType;
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

	/**
	 * Creates org.bson.Document object with value success=true
	 * @return
	 */
	public static Document getSuccessDoc() {
		Document ret = new Document(Constants.KEY_SUCCESS, true);
		return ret;
	}

	/**
	 * Creates org.bson.Document object with values success=false and error object.
	 * @param errorType
	 * @param userMessage
	 * @return
	 */
	public static Document getErrorDoc(ErrorType errorType, String userMessage) {
		Document ret = new Document(Constants.KEY_SUCCESS, false);
		Document error = new Document(Constants.KEY_ERROR_TYPE, errorType.name());
		error.append(Constants.KEY_USER_MESSAGE, userMessage);
		ret.append(Constants.KEY_ERROR, error);
		return ret;
	}

	/**
	 * Creates org.bson.Document object with values success=false and error object with type UNKNOWN_ERROR.
	 * If MessageResolver is null then userMessage of error is empty.
	 * @param msgRes
	 * @return
	 */
	public static Document getUnknownErrorDoc(MessageResolver msgRes) {
		return getErrorDoc(ErrorType.UNKNOWN_ERROR, msgRes != null
													? msgRes.getMessage("error.unknown")
													: "");
	}
}
