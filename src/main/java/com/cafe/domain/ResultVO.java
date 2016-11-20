package com.cafe.domain;

import com.cafe.exception.ExceptionCode;
/**
 * Value Object for result to send 
 * @author YJH
 * 2016.11.21.Mon
 * @param <T> for template
 */
public class ResultVO<T> {
	// fields : error code, error messagem, object 
	private int code = ExceptionCode.NONE.getCode();
	private String message =ExceptionCode.NONE.getMessage();
	private T result; //object
	
	//constructors
	public ResultVO() {}
	public ResultVO(T result){
		this.result = result;
	}
		
	/* getter, setter, toString methods */
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(T result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "ResultVO [code=" + code + ", message=" + message + ", result=" + result + "]";
	}
}
