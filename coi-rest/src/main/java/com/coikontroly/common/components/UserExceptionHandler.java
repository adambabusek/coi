package com.coikontroly.common.components;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.coikontroly.common.domain.UserException;
import com.coikontroly.common.utils.DocUtils;

@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({UserException.class})
	public ResponseEntity<Object> handleUserException(UserException ex, WebRequest request) {
		String responseBody = DocUtils.getErrorDoc(ex.getType(), ex.getUserMessage()).toJson();
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
		return handleExceptionInternal(ex, responseBody, headers, HttpStatus.OK, request);
	}
}
