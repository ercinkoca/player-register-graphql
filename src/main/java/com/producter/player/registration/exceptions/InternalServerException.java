package com.producter.player.registration.exceptions;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InternalServerException extends RuntimeException implements GraphQLError {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7780632864549174639L;
	
	public InternalServerException(String exception) {
		super(exception);
	}

	@Override
	public List<SourceLocation> getLocations() {
		return null;
	}

	@Override
	public ErrorType getErrorType() {
		return null;
	}

}
