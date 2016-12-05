package com.cafe.dto;

public class FixedDTO {

	// fields
	private String cafeName;
	private String detailName;
	private String menuName;
	private String uid;
	private boolean isLike;
	private int price;
	private float point;
	private int likeNum;
	private String path;
	
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
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public boolean getIsLike() {
		return isLike;
	}
	public void setIsLike(boolean isLike) {
		this.isLike = isLike;
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
	@Override
	public String toString() {
		return "FixedDTO [cafeName=" + cafeName + ", detailName=" + detailName + ", menuName=" + menuName + ", uid="
				+ uid + ", isLike=" + isLike + ", price=" + price + ", point=" + point + ", likeNum=" + likeNum
				+ ", path=" + path + "]";
	} 
	
}
