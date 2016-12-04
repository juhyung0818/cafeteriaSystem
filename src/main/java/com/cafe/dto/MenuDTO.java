package com.cafe.dto;

public class MenuDTO {

	private String cafeName;
	private String menuName;
	private String detailName;
	private int price;
	private float point;
	private int likeNum;
	private String path;
	private boolean isLike;
	private String uid;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
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
	public boolean getIsLike() {
		return isLike;
	}
	public void setIsLike(boolean isLike) {
		this.isLike = isLike;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "MenuDTO [cafeName=" + cafeName + ", menuName=" + menuName + ", detailName=" + detailName + ", price="
				+ price + ", point=" + point + ", likeNum=" + likeNum + ", path=" + path + ", isLike=" + isLike
				+ ", uid=" + uid + "]";
	}
	
}
