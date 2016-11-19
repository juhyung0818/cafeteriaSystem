package com.cafe.persistence;

import com.cafe.domain.WeeklyVO;

public interface FlagDAO {
	
	//menu table register
	public void register(WeeklyVO weekly) throws Exception;
}
