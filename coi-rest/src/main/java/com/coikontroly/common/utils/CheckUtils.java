package com.coikontroly.common.utils;

import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

import com.coikontroly.common.components.MessageResolver;
import com.coikontroly.common.domain.ErrorType;
import com.coikontroly.common.domain.UserException;

/**
 * Class contains static methods for checking values of various types. *
 */
public class CheckUtils {

	public static final String REGEXP_ICO = "\\d+";

	private CheckUtils() { }

	/**
	 * Checks if ICO is valid. If ICO is not valid the UserException is thrown filled by corresponding
	 * error type and user message.
	 * @param ico
	 * @param msgRes
	 */
	public static void checkIco(String ico, MessageResolver msgRes) {
		if (!StringUtils.hasText(ico)) {
			throw new UserException(ErrorType.EMPTY_ICO, msgRes.getMessage("error.emptyIco"));
		}
		ico = ico.replaceAll("\\s+", "");
		if (!Pattern.matches(REGEXP_ICO, ico)) {
			throw new UserException(ErrorType.INVALID_ICO, msgRes.getMessage("error.invalidIco"));
		}
	}
}
