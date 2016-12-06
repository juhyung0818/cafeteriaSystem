package com.cafe.exception;

/**
 * User is not authority 
 * @author YJH
 * 2016.11.20.Sun
 */
public class NotAuthoriedException extends CafeException{

	@Override
	public ExceptionCode getExceptionCode() {
		return ExceptionCode.ACCESS_DENIED;
	}

}
