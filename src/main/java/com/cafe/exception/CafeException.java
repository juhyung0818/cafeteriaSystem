package com.cafe.exception;

/**
 * exception class
 * @author YJH
 * 2016.11.20.Sun
 */
public abstract class CafeException extends RuntimeException{
	private static final long serialVersionUID = 8570300479191506240L;

	public abstract ExceptionCode getExceptionCode();
}
