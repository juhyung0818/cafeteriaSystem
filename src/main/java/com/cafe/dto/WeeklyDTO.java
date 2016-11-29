package com.cafe.dto;



import java.util.List;

import com.cafe.domain.MenuVO;
import com.cafe.flag.DateFlag;
import com.cafe.flag.WeeklyFlag;

public class WeeklyDTO {
	
	private MenuVO weekly;
	private	WeeklyFlag wFlag;
	private DateFlag dateFlag;
	public MenuVO getWeekly() {
		return weekly;
	}
	public void setWeekly(MenuVO weekly) {
		this.weekly = weekly;
	}
	public WeeklyFlag getwFlag() {
		return wFlag;
	}
	public void setwFlag(WeeklyFlag wFlag) {
		this.wFlag = wFlag;
	}
	public DateFlag getDateFlag() {
		return dateFlag;
	}
	public void setDateFlag(DateFlag dateFlag) {
		this.dateFlag = dateFlag;
	}
	@Override
	public String toString() {
		return "WeeklyDTO [weekly=" + weekly + ", wFlag=" + wFlag + ", dateFlag=" + dateFlag + "]";
	}
	
		
}
