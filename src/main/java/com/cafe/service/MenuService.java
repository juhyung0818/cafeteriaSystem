package com.cafe.service;

import java.util.List;

import com.cafe.domain.MenuVO;

public interface MenuService {

	public void menuRegister(MenuVO menu) throws Exception;
	public List<MenuVO> menuList() throws Exception;
}
