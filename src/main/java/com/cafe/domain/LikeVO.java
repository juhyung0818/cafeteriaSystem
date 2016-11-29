package com.cafe.domain;

public class LikeVO {
	
	private String uid;
	private String cafeName;
	private String detailName;
	private String menuName;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
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
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	@Override
	public String toString() {
		return "LikeVO [uid=" + uid + ", cafeName=" + cafeName + ", detailName=" + detailName + ", menuName=" + menuName
				+ "]";
	}
	
}
