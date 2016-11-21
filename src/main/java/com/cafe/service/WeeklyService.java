package com.cafe.service;

import java.util.List;

import com.cafe.domain.MenuVO;
import com.cafe.domain.WeeklyVO;
import com.cafe.flag.DateFlag;
import com.cafe.flag.WeeklyFlag;

public interface WeeklyService {

	//menu table register
	public void register(WeeklyVO weekly) throws Exception;
	//all delete weekly
	public void clearWeekly() throws Exception;
	//delete a weekly menu
	public void delete(WeeklyVO weekly) throws Exception;
	// weekly list
	public List<WeeklyVO> weeklyList(String cafeName) throws Exception;
}
