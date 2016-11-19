package com.cafe.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cafe.domain.WeeklyVO;
import com.cafe.persistence.FlagDAO;

/**
 * 
 * @author YJH
 *
 */
@Service
public class FlagServiceImpl implements FlagService{

	@Inject
	private FlagDAO flagDao;
	
	@Override
	public void register(WeeklyVO weekly) throws Exception {
		flagDao.register(weekly);
	}

}
