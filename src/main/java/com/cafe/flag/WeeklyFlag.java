package com.cafe.flag;

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
	
	public static WeeklyFlag valueOf(int num){
		switch(num){
			case 0: return WeeklyFlag.SUNDAY;
			case 1: return WeeklyFlag.MONDAY;
			case 2: return WeeklyFlag.TUESDAY;
			case 3: return WeeklyFlag.WEDNESDAY;
			case 4: return WeeklyFlag.THURSDAY;
			case 5: return WeeklyFlag.FRIDAY;
			case 6: return WeeklyFlag.SATURDAY;
			//TODO need exception define
			default: throw new AssertionError(); 
		}
	}

}