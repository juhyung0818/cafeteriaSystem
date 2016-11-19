package com.cafe.service;

import javax.inject.Inject;

import com.cafe.domain.WeeklyVO;
import com.cafe.persistence.FlagDAO;

/**
 * 
 * @author YJH
 *
 */
public class FlagServiceImpl implements FlagService{

	@Inject
	private FlagDAO flagDao;
	
	@Override
	public void register(WeeklyVO weekly) throws Exception {
		flagDao.register(weekly);
	}

}
