package com.cafe.dto;

public class searchDTO {
	private String uid;
	private String keyword;

	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	@Override
	public String toString() {
		return "searchDTO [uid=" + uid + ", keyword=" + keyword + "]";
	}
	
	
}
