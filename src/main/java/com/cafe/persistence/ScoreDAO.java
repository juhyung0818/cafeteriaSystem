package com.cafe.persistence;

import com.cafe.domain.ScoreVO;

/**
 * 
 * @author kwom
 * 2016.11.24.thu
 */
public interface ScoreDAO {

	public void scoreRegister(ScoreVO score) throws Exception;
//	public void scoreDelete(ScoreVO score) throws Exception;
	public void scoreUpdate(ScoreVO score) throws Exception;
	
	public int isScored(ScoreVO score) throws Exception;
	public float getAVG(ScoreVO score) throws Exception;
	
}
