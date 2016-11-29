package com.cafe.persistence;

import java.util.List;

import com.cafe.domain.DetailVO;
import com.cafe.domain.FixedVO;

/**
 * Fixed menu dao interface
 * @author YJH
 * 2016.11.20.Sun
 */
public interface FixedDAO {

	// fixed menu register
	public void register(FixedVO fixed) throws Exception;
	// fixed menu delete
	public void delete(FixedVO fixed) throws Exception;
	// display fixed menu list
	public List<FixedVO> fixedList(String cafeName) throws Exception;
	//dispaly fixed menu search list
	public List<FixedVO> fixedSearch(String cafeName, String keyword) throws Exception;
	//check already exist
	public int check(FixedVO fixed) throws Exception;
	
}
