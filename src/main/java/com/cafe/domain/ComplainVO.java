package com.cafe.domain;

import java.sql.Timestamp;

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
	private Timestamp regDate;
	private String reply;
	private Timestamp replyDate;
	private String nick;
	
	/* getter, setter methods*/
	public int getComplainNum() {
		return complainNum;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
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
	public void setReply(String reply) {
		this.reply = reply;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	public Timestamp getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(Timestamp replyDate) {
		this.replyDate = replyDate;
	}
	
}
