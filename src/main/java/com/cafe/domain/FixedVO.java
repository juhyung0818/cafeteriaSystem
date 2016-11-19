package com.cafe.domain;

/**
 * Value Object for fixed menu
 * @author YJH
 * 2016.11.19.Sat
 */
public class FixedVO {
	
	// fields
	private String cafeName;
	private String menuName;
	
	/* getter, setter methods */
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

	@Override
	public String toString() {
		return "FixedVO [cafeName=" + cafeName + ", menuName=" + menuName + "]";
	}
	
}
