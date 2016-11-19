package com.cafe.exception;
/**
 * InvalidTypeException
 * type of sql attribute and type of application variable are different  
 * @author YJH
 * 2016.11.20.Sun
 */
public class InvalidTypeException extends CafeException {

	@Override
	public ExceptionCode getExceptionCode() {
		return ExceptionCode.INVALID_TYPE;
	}

}
