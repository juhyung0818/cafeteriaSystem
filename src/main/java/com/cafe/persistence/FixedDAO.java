package com.cafe.persistence;

import java.util.List;

import com.cafe.domain.FixedVO;
import com.cafe.domain.MenuVO;

/**
 * Fixed menu dao interface
 * @author YJH
 * 2016.11.20.Sun
 */
public interface FixedDAO {

	// fixed menu register
	public void register(FixedVO fixed) throws Exception;
	// fixed menu delete
	public void remove(FixedVO fixed) throws Exception;
	// display fixed menu list
	public List<MenuVO> fixedList(String cafeName) throws Exception;
}
