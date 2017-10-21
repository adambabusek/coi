package com.coikontroly.common.domain;

public class UserException extends RuntimeException {
	private static final long serialVersionUID = -5256733415633110220L;

	private ErrorType type;
	private String userMessage;

	public UserException(ErrorType type, String userMessage) {
		super();
		this.type = type;
		this.userMessage = userMessage;
	}

	public ErrorType getType() {
		return type;
	}

	public void setType(ErrorType type) {
		this.type = type;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

}
