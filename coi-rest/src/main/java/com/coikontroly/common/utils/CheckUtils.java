package com.coikontroly.common.utils;

import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

import com.coikontroly.common.components.MessageResolver;
import com.coikontroly.common.domain.ErrorType;
import com.coikontroly.common.domain.UserException;

public class CheckUtils {

	public static final String REGEXP_ICO = "\\d+";

	private CheckUtils() { }

	public static void checkIco(String ico, MessageResolver msgRes) {
		if (!StringUtils.hasText(ico)) {
			throw new UserException(ErrorType.EMPTY_ICO, msgRes.getMessage("error.emptyIco"));
		}
		ico = ico.replaceAll("\\s+", "");
		if (!Pattern.matches(REGEXP_ICO, ico)) {
			throw new UserException(ErrorType.NON_VALID_ICO, msgRes.getMessage("error.nonValidIco"));
		}
	}
}
