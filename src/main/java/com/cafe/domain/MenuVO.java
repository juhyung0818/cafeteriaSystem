package com.cafe.domain;

/**
 * Value Object
 * @author YJH
 * 2016.11.09.Wed
 */

public class MenuVO {

	private String cafeName;
	private String menuName;
	private float point;
	private int likeNum;
	private String path;
	
	//getter, setter methods
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
	public float getPoint() {
		return point;
	}
	public void setPoint(float point) {
		this.point = point;
	}
	public int getLikeNum() {
		return likeNum;
	}
	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	//toString method for log
	@Override
	public String toString() {
		return "MenuVO [cafeName=" + cafeName + ", menuName=" + menuName + ", point=" + point + ", likeNum=" + likeNum
				+ ", path=" + path + "]";
	}
	
	
}
