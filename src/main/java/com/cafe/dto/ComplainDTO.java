package com.cafe.dto;
/**
 * 
 * @author kwon
 * 2016.11.25.Fri
 */
public class ComplainDTO {
	
	private int complainNum;
	private String title;
	private String uid;
	private String regDate;
	private boolean isReply;
	
	public int getComplainNum() {
		return complainNum;
	}
	public void setComplainNum(int complainNum) {
		this.complainNum = complainNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public boolean getIsReply() {
		return isReply;
	}
	public void setIsReply(boolean isReply) {
		this.isReply = isReply;
	}
	@Override
	public String toString() {
		return "ComplainDTO [complainNum=" + complainNum + ", title=" + title + ", uid=" + uid + ", regDate=" + regDate
				+ ", isReply=" + isReply + "]";
	}
	
	
}
