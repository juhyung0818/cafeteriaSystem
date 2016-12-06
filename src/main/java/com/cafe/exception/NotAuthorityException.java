package com.cafe.exception;

/**
 * User is not authority 
 * @author kwon
 * 2016.11.20.Sun
 */
public class NotAuthorityException extends CafeException{

	@Override
	public ExceptionCode getExceptionCode() {
		
		return ExceptionCode.NOT_AUTHORITY;
	}

}
