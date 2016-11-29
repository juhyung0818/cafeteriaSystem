package com.cafe.flag;

/**
 * time express enum type
 * @author YJH
 * 2016.11.19.Sat
 */
public enum DateFlag {

	/* enums */
	BREAKFAST(0, "breakfast"),
	LUNCH(1, "lunch"),
	DINNER(2, "dinner");
	
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
	
	public static DateFlag valueOF(int num){
		switch(num){
			case 0: return DateFlag.BREAKFAST;
			case 1: return DateFlag.LUNCH;
			case 2: return DateFlag.DINNER;
			// TODO need exception define
			default: throw new AssertionError();
		}
	}
	
}


