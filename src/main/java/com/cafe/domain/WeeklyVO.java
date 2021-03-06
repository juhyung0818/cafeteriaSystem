package com.cafe.domain;

import com.cafe.flag.DateFlag;
import com.cafe.flag.WeeklyFlag;


/**
 * Value Object for Weekly menu
 * @author YJH
 * 2016.11.19.Sat
 */
public class WeeklyVO {

	
	//fields
	private String cafeName;
	private String menuName;
	private String detailName;
	private	WeeklyFlag wFlag;
	private DateFlag dateFlag;
	private String uid;
	
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
	public String getDetailName() {
		return detailName;
	}
	public void setDetailName(String detailName) {
		this.detailName = detailName;
	}
	public WeeklyFlag getwFlag() {
		return wFlag;
	}
	public void setwFlag(WeeklyFlag wFlag) {
		this.wFlag = wFlag;
	}
	public DateFlag getDateFlag() {
		return dateFlag;
	}
	public void setDateFlag(DateFlag dateFlag) {
		this.dateFlag = dateFlag;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "WeeklyVO [cafeName=" + cafeName + ", menuName=" + menuName + ", detailName=" + detailName + ", wFlag="
				+ wFlag + ", dateFlag=" + dateFlag + ", uid=" + uid + "]";
	}
	

}
