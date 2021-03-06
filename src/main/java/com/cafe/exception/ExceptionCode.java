package com.cafe.exception;

/**
 * exception define enum class
 * @author YJH
 * 2016.11.20.Sun
 */
public enum ExceptionCode {

	//exception enums
	NONE(200, "success"),
	PRIMARY_KEY_DUPLICATE(100, "primary key duplicated"),
	NOT_EXIST(400, "not exist"),
		NOT_EXIST_RESULT(410, "search result is not exist "),
		NOT_EXIST_URL(420, "URL is not exist "),
	ACCESS_DENIED(500, "you don't have permission."),
	NOT_AUTHORITY(1000, "you don't have authority.");
	
	//fields
	private int code;
	private String message;
	
	//constructor
	ExceptionCode(int code, String message){
		this.code = code;
		this.message = message;
	}

	/* getter, setter methods */
	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
