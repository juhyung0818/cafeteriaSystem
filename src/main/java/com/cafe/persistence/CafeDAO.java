package com.cafe.persistence;

import java.util.List;

import com.cafe.domain.CafeVO;
/**
 * Cafeteria dao interface
 * @author YJH
 * 2016.11.08.Tue
 */
public interface CafeDAO {

	//add cafe
	public void cafeRegister(CafeVO cafe) throws Exception;
	//display cafe list
	public List<CafeVO> cafeList() throws Exception;
	//remove cafe
	public void deleteCafe(String cafeName) throws Exception;
	//search cafe
	public List<CafeVO> cafeSearch(String keyword) throws Exception;
	//check cafe name
	public int cafeCheck(String cafeName) throws Exception;
}
