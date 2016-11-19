package com.cafe.persistence;

import com.cafe.domain.WeeklyVO;
import com.cafe.flag.DateFlag;
import com.cafe.flag.WeeklyFlag;

public interface WeeklyDAO {
	
	//menu table register
	public void register(WeeklyVO weekly) throws Exception;
	//all delete weekly
	public void clearWeekly() throws Exception;
	//delete a weekly menu
	public void delete(String menuName, WeeklyFlag wFlag, DateFlag dateFlag) throws Exception;
}
