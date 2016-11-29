package com.cafe.exception;

public class NotAuthorityException extends CafeException{

	@Override
	public ExceptionCode getExceptionCode() {
		
		return ExceptionCode.NOT_AUTHORITY;
	}

}
