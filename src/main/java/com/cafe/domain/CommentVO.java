package com.cafe.domain;

public class CommentVO {

	private int commentNum;
	private String cafeName;
	private String menuName;
	private String detailName;
	private String contents;
	private String uid;
	private int likeNum;
	private String regDate;
	
	/* getter, setter, toString method */
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
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
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public int getLikeNum() {
		return likeNum;
	}
	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "CommentVO [commentNum=" + commentNum + ", cafeName=" + cafeName + ", menuName=" + menuName
				+ ", detailName=" + detailName + ", contents=" + contents + ", uid=" + uid + ", likeNum=" + likeNum
				+ ", regDate=" + regDate + "]";
	}
	
}