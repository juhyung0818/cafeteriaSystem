package com.cafe.service;

import javax.inject.Inject;

import com.cafe.domain.WeeklyVO;
import com.cafe.flags.WeekFlag;
import com.cafe.persistence.FlagDAO;

/**
 * Weekly Service class
 * @author YJH
 * 2016.11.19.Sat
 * register, delete, list, search
 */
public class FlagServiceImpl implements FlagService{

	@Inject
	private FlagDAO flagDao;
	
	@Override
	public void register(WeeklyVO weekly) throws Exception {
		
		flagDao.register(weekly);
	}

}
