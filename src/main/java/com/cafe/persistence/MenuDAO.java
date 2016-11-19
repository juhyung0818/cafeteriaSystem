package com.cafe.persistence;

import java.util.List;

import com.cafe.domain.MenuVO;
/**
 * Cafeteria dao interface
 * @author YJH
 * 2016.11.08.Tue
 */
public interface MenuDAO {

	// insert menu 
	public void menuRegister(MenuVO menu) throws Exception;
	// diplay all menu list
	public List<MenuVO> menuList() throws Exception;
	//menu search
	public List<MenuVO> searchMenu(String cafeName, String keyword) throws Exception;
}
