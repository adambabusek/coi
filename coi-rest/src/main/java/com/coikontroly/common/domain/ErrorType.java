package com.coikontroly.common.domain;

public enum ErrorType {
	/** unknown error */
	UNKNOWN_ERROR(0),
	/** organization was not found by ico */
	ORGANIZATION_NOT_FOUND(1),
	/** ico is not valid */
	NON_VALID_ICO(2),
	/** empty ico */
	EMPTY_ICO(3);

	private int id;

	private ErrorType(int id) {
		this.id = id;
	}
}
