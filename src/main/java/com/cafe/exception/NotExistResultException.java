package com.cafe.exception;

/**
 * Result is not exist
 * @author YJH
 * 2016.11.20.Sun
 */
public class NotExistResultException extends NotExistException{

	@Override
	public ExceptionCode getExceptionCode() {
		return ExceptionCode.NOT_EXIST_RESULT;
	}

}
