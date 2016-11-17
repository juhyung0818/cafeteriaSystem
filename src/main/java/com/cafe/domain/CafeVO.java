package com.cafe.domain;
/**
 * Value Object
 * @author YJH
 * 2016.11.08.Tue
 */
public class CafeVO {

	//fields
	private String cafeName;
	private String info;
	
	/* getter, setter methods */
	public String getCafeName() {
		return cafeName;
	}
	public void setCafeName(String cafeName) {
		this.cafeName = cafeName;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	/* toString method for log */
	@Override
	public String toString() {
		return "CafeVO [cafeName=" + cafeName + ", info=" + info + "]";
	}
}
