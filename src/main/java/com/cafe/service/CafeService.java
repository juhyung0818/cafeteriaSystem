
package com.cafe.service;

import java.util.List;

import com.cafe.domain.CafeVO;
/**
 * Cafeteria service interface
 * @author YJH
 * 2016.11.08.Tue
 */
public interface CafeService {
	
	//check to exist and register cafe
	public void cafeRegister(CafeVO cafe) throws Exception;
	//display cafe
	public List<CafeVO> cafeList() throws Exception;
	//remove cafe
	public void deleteCafe(String cafeName) throws Exception;
	//search cafe
	public List<CafeVO> cafeSearch(String keyword) throws Exception;
	
}
