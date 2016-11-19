package com.cafe.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cafe.domain.WeeklyVO;
import com.cafe.flag.DateFlag;
import com.cafe.flag.WeeklyFlag;
import com.cafe.persistence.WeeklyDAO;

/**
 * 
 * @author YJH
 * 2016.11.19.Sat
 */
@Service
public class WeeklyServiceImpl implements WeeklyService{

	@Inject
	private WeeklyDAO flagDao;
	
	@Override
	public void register(WeeklyVO weekly) throws Exception {
		flagDao.register(weekly);
	}

	@Override
	public void clearWeekly() throws Exception {
		flagDao.clearWeekly();
	}

	@Override
	public void delete(String menuName, WeeklyFlag wFlag, DateFlag dateFlag) throws Exception {
		flagDao.delete(menuName, wFlag, dateFlag);
	}

}
