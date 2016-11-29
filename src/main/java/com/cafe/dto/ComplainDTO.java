package com.cafe.dto;
/**
 * 
 * @author kwon
 * 2016.11.25.Fri
 */
public class ComplainDTO {
	
	private int complainNum;
	private String title;
	private String content;
	private String uid;
	private String nick;
	private String regDate;
	private boolean isReply;
	private String reply; 
	private String replyDate;
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
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
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
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}
	@Override
	public String toString() {
		return "ComplainDTO [complainNum=" + complainNum + ", title=" + title + ", content=" + content + ", uid=" + uid
				+ ", nick=" + nick + ", regDate=" + regDate + ", isReply=" + isReply + ", reply=" + reply
				+ ", replyDate=" + replyDate + "]";
	}
	

	
}
