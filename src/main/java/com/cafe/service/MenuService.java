package com.cafe.service;

import java.util.List;

import com.cafe.domain.MenuVO;
/**
 * Menu service interface
 * @author YJH
 * 2016.11.08.Tue
 */
public interface MenuService {

	public void menuRegister(MenuVO menu) throws Exception;
	public List<MenuVO> menuList(String cafeName) throws Exception;
	//menu search
	public List<MenuVO> searchMenu(String cafeName, String keyword) throws Exception;
	//delete a menu
	public void deleteMenu(String cafeName, String menuName) throws Exception;
}
