package com.cafe.flags;

/**
 * time express enum type
 * @author YJH
 * 2016.11.19.Sat
 */
public enum DateFlag {

	/* enums */
	BREAKFAST(0, "breakfast"),
	LUNCH(1, "lunch"),
	DINER(2, "diner");
	
	private int num;
	private String time;
	
	//constructor
	private DateFlag(int num, String time) {
		this.num = num;
		this.time = time;
	}

	/* getter methods */
	public int getNum() {
		return num;
	}

	public String getTime() {
		return time;
	}
	
}
