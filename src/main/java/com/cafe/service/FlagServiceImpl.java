package com.cafe.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cafe.domain.WeeklyVO;
import com.cafe.flags.WeekFlag;
import com.cafe.persistence.FlagDAO;

/**
 * Weekly Service class
 * @author YJH
 * 2016.11.19.Sat
 * register, delete, list, search
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
