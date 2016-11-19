package com.cafe.persistence;

import com.cafe.domain.WeeklyVO;
import com.cafe.flag.DateFlag;
import com.cafe.flag.WeeklyFlag;

/**
 * Weekly menu dao interface
 * @author YJH
 * 2016.11.19.Sat
 */
public interface WeeklyDAO {
	
	//menu table register
	public void register(WeeklyVO weekly) throws Exception;
	//all delete weekly
	public void clearWeekly() throws Exception;
	//delete a weekly menu
	public void delete(String menuName, WeeklyFlag wFlag, DateFlag dateFlag) throws Exception;
}
