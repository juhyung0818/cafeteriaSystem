package com.cafe.exception;

/**
 * Result is not exist
 * @author YJH
 * 2016.11.20.Sun
 */
public class NotExistException extends CafeException{

	@Override
	public ExceptionCode getExceptionCode() {
		return ExceptionCode.NOT_EXIST;
	}

}
