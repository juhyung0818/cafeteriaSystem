package com.cafe.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cafe.domain.WeeklyVO;
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

}
