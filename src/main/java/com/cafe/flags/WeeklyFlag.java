package com.cafe.flags;

/**
 * week express enum type
 * @author YJH
 * 2016.11.19.Sat
 */
public enum WeeklyFlag {

	/* enums */
	SUNDAY(0, "weekend"),
	MONDAY(1, "weekday"),
	TUESDAY(2, "weekday"),
	WEDNESDAY(3, "weekday"),
	THURSDAY(4, "weekday"),
	FRIDAY(5, "weekday"),
	SATURDAY(6, "weekend");
	
	private int num;
	private String week;
	
	/**
	 * constructor
	 * @param num 
	 * @param week
	 */
	private WeeklyFlag(int num, String week) {
		this.num = num;
		this.week = week;
	}

	/* getter methods */
	public int getNum() {
		return num;
	}

	public String getWeek() {
		return week;
	}

}
