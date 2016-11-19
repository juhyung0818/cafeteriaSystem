package com.cafe.exception;

/**
 * When insert MySQL, primary key already exists
 * @author YJH
 * 2016.11.20.Sun
 */
public class PrimaryKeyDuplicatedException extends CafeException{

	@Override
	public ExceptionCode getExceptionCode() {
		return ExceptionCode.PRIMARY_KEY_DUPLICATE;
	}
	
}
