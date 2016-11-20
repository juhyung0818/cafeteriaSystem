package com.cafe.domain;
/**
 * Value Object for complain
 * @author YJH
 * 2016.11.21.Mon
 */
public class ComplainVO {

	private int complainNum;
	private String title;
	private String content;
	private String uid;
	private String reply;
	
	/* getter, setter, toString methods */
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getReply() {
		return reply;
	}
	public void setRelpy(String relpy) {
		this.reply = reply;
	}
	
	@Override
	public String toString() {
		return "ComplainVO [complainNum=" + complainNum + ", title=" + title + ", content=" + content + ", uid=" + uid
				+ ", reply=" + reply + "]";
	}
}
