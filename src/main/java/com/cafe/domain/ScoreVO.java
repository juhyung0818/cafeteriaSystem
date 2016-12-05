package com.cafe.domain;
/**
 * value object for score
 * @author kwon
 * 2016.11.25.Fri
 */
public class ScoreVO {

	private String cafeName;
	private String detailName;
	private String menuName;
	private String uid;
	private float score;
	
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
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "ScoreVO [cafeName=" + cafeName + ", detailName=" + detailName + ", menuName=" + menuName + ", uid="
				+ uid + ", score=" + score + "]";
	}
	
}
