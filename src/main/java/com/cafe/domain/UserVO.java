package com.cafe.domain;

public class UserVO {

	private String uid;
	private String nick;
	
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
	@Override
	public String toString() {
		return "UserVO [uid=" + uid + ", nick=" + nick + "]";
	}
}
