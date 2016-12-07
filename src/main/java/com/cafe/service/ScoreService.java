package com.cafe.service;

import com.cafe.domain.ScoreVO;
/**
 * 
 * @author kwom
 * 2016.11.24.thu
 */
public interface ScoreService {

	public void scoreRegister(ScoreVO score) throws Exception;
	
	public double getScore(String uid) throws Exception;
}