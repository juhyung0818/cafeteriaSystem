package com.cafe.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cafe.domain.ScoreVO;
import com.cafe.persistence.ScoreDAO;
/**
 * 
 * @author kwom
 * 2016.11.24.thu
 */
@Service
public class ScoreServiceImpl implements ScoreService{
	
	@Inject
	ScoreDAO scoreDao;

	@Override
	public void scoreRegister(ScoreVO score) throws Exception {
		
		if(scoreDao.isScored(score)==0)
			scoreDao.scoreRegister(score);
		else
			scoreDao.scoreUpdate(score);
	}

	@Override
	public void scoreDelete(ScoreVO score) throws Exception {

		scoreDao.scoreDelete(score);
	}
}
