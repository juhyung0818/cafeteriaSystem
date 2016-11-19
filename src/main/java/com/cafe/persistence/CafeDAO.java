package com.cafe.persistence;

import java.util.List;

import com.cafe.domain.CafeVO;
/**
 * Cafeteria dao interface
 * @author YJH
 * 2016.11.08.Tue
 */
public interface CafeDAO {

	public void cafeRegister(CafeVO cafe) throws Exception;
	public List<CafeVO> cafeList() throws Exception;
}
