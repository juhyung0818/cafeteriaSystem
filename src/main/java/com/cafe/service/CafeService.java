
package com.cafe.service;

import java.util.List;

import com.cafe.domain.CafeVO;
/**
 * Cafeteria service interface
 * @author YJH
 * 2016.11.08.Tue
 */
public interface CafeService {
	
	public void cafeRegister(CafeVO cafe) throws Exception;
	public List<CafeVO> cafeList() throws Exception;
	
}
