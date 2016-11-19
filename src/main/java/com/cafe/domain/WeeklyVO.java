package com.cafe.domain;

/**
 * Value Object for Weekly
 * @author YJH
 * 2016.11.19.Sat
 */
public class WeeklyVO {

	//fields
	private String cafeName;
	private String menuName;
	private String wFlag;
	private String dateFlag;
	
	/* getter, setter, toString methods */
	public String getCafeName() {
		return cafeName;
	}
	public void setCafeName(String cafeName) {
		this.cafeName = cafeName;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getwFlag() {
		return wFlag;
	}
	public void setwFlag(String wFlag) {
		this.wFlag = wFlag;
	}
	public String getDateFlag() {
		return dateFlag;
	}
	public void setDateFlag(String dateFlag) {
		this.dateFlag = dateFlag;
	}
	
	@Override
	public String toString() {
		return "Weekly [cafeName=" + cafeName + ", menuName=" + menuName + ", wFlag=" + wFlag + ", dateFlag=" + dateFlag
				+ "]";
	}

}
