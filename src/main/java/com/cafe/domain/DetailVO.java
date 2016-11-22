package com.cafe.domain;

/**
 * Value Object for detail cafeteria
 * @author YJH
 * 2016.11.21.Mon
 */
public class DetailVO {
	
	//fields
	private String cafeName;
	private String detailName;
	
	//getter, setter, toString methods
	public String getCafeName() {
		return cafeName;
	}
	public void setCafeName(String cafeName) {
		this.cafeName = cafeName;
	}
	public String getDetailName() {
		return detailName;
	}
	public void setDetailName(String detailName) {
		this.detailName = detailName;
	}
	
	@Override
	public String toString() {
		return "DetailVO [cafeName=" + cafeName + ", detailName=" + detailName + "]";
	}
	
}
