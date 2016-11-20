package com.cafe.persistence;

import java.util.List;

import com.cafe.domain.WeeklyVO;

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
	public void delete(WeeklyVO weekly) throws Exception;
	// weekly list
	public List<WeeklyVO> weeklyList(String cafeName) throws Exception;
}
