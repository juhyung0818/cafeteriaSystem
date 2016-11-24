package com.cafe.domain;

public class CommentVO {

	private int commentNum;
	private String cafeName;
	private String menuName;
	private String contents;
	private String uid;
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
	@Override
	public String toString() {
		return "CommentVO [commentNum=" + commentNum + ", cafeName=" + cafeName + ", menuName=" + menuName
				+ ", contents=" + contents + ", uid=" + uid + "]";
	}
	
}